# Understanding `volatile` in Java

The `volatile` keyword in Java is a **non-access modifier** used in **multithreading** to ensure visibility of changes to variables across threads.

---

## **1. What is a `volatile` Variable?**
- A `volatile` variable ensures that **changes made by one thread** are **immediately visible to other threads**.
- It prevents **caching optimizations** that might delay updates to the variable.
- Only applicable to **instance and static variables** (not local variables).

### **Example:**
```java
class VolatileExample {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(1000);
                flag = true;
                System.out.println("Writer Thread: Flag updated to true");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread reader = new Thread(() -> {
            while (!flag) {
                // Looping until flag becomes true
            }
            System.out.println("Reader Thread: Detected flag change");
        });

        reader.start();
        writer.start();
    }
}
```
### **Output:**
```
Writer Thread: Flag updated to true
Reader Thread: Detected flag change
```
#### **Edge Cases:**
- Without `volatile`, the reader **might never see the updated flag** due to thread caching.
- `volatile` does **not** provide atomicity (use `synchronized` or `Atomic` classes for compound operations).

---

## **2. `volatile` with `static` and `final` Variables**
- `volatile` **can be applied to `static` variables**.
- `volatile` **cannot be applied to `final` variables**, because `final` variables cannot change once initialized.

### **Example:**
```java
class StaticVolatileExample {
    static volatile int counter = 0;
}
```

#### **Why `volatile final` is Invalid?**
- `final` means a variable **cannot be modified**, while `volatile` is used for variables **that change frequently**.

---

## **3. `volatile` vs `synchronized`**
| Feature | `volatile` | `synchronized` |
|---------|-----------|---------------|
| **Ensures Visibility** | ✅ Yes | ✅ Yes |
| **Ensures Atomicity** | ❌ No | ✅ Yes |
| **Prevents Race Conditions** | ❌ No | ✅ Yes |
| **Performance Impact** | Low (No locking) | High (Locking mechanism) |

---

## **4. Summary**
| Feature | Allowed? | Behavior |
|---------|---------|----------|
| **Volatile Instance Variables** | ✅ Yes | Ensures visibility across threads |
| **Volatile Static Variables** | ✅ Yes | Shared visibility across threads |
| **Volatile Final Variables** | ❌ No | `final` variables cannot change |
| **Volatile Local Variables** | ❌ No | Not allowed |

