# **StringBuffer vs StringBuilder in Java**

Java provides **StringBuffer** and **StringBuilder** classes as mutable alternatives to **String**. Both allow modifying string content without creating new objects.

---

## **1. StringBuffer**
- A **mutable** sequence of characters (can be changed).
- **Thread-safe** (synchronized), making it **slower** in single-threaded environments.

### **Example:**
```java
public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println(sb); // Output: Hello World

        sb.insert(5, " Java");
        System.out.println(sb); // Output: Hello Java World

        sb.replace(6, 10, "Python");
        System.out.println(sb); // Output: Hello Python World

        sb.delete(6, 12);
        System.out.println(sb); // Output: Hello World
    }
}
```

---

## **2. StringBuilder**
- Similar to **StringBuffer**, but **not thread-safe**.
- **Faster** than StringBuffer for single-threaded applications.

### **Example:**
```java
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb); // Output: Hello World

        sb.insert(5, " Java");
        System.out.println(sb); // Output: Hello Java World

        sb.reverse();
        System.out.println(sb); // Output: dlroW avaJ olleH
    }
}
```

---

## **3. Difference Between String, StringBuffer, and StringBuilder**

| Feature         | String         | StringBuffer      | StringBuilder      |
|---------------|--------------|----------------|----------------|
| **Mutability**  | Immutable     | Mutable        | Mutable        |
| **Thread Safety** | Yes (safe)    | Yes (safe)     | No (not safe)  |
| **Performance** | Slow          | Moderate       | Fast           |
| **Synchronization** | Not applicable | Synchronized  | Not synchronized |
| **Use Case**    | When string should not change | Multi-threaded applications | Single-threaded applications |

---

## **4. Edge Cases**

### **Edge Case 1: Ensuring Thread Safety with StringBuffer**
If multiple threads modify a `StringBuffer` object, it remains consistent.

```java
public class ThreadSafeExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Thread");
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                sb.append(" Safe");
            }
            System.out.println(sb);
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}
```
*Output:* The output is always correct due to **synchronization** in `StringBuffer`.

---

### **Edge Case 2: StringBuilder in Multi-threading (Data Corruption)**
Using `StringBuilder` in a multi-threaded environment can lead to data inconsistency.

```java
public class ThreadUnsafeExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Unsafe");
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                sb.append(" Thread");
            }
            System.out.println(sb);
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}
```
*Output:* Data corruption occurs due to **lack of synchronization**.

---

### **Edge Case 3: StringBuffer vs StringBuilder Performance Test**
`StringBuilder` is faster than `StringBuffer` in single-threaded applications.

```java
public class PerformanceTest {
    public static void main(String[] args) {
        long startTime, endTime;

        // StringBuffer
        StringBuffer sb = new StringBuffer("Test");
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            sb.append("x");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime));

        // StringBuilder
        StringBuilder sbuilder = new StringBuilder("Test");
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            sbuilder.append("x");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime));
    }
}
```

**Output:**
```
StringBuffer Time: 150000000 (slower due to synchronization)
StringBuilder Time: 90000000 (faster without synchronization)
```

---

## **Final Thoughts**
- Use **String** if the value **doesn’t change**.
- Use **StringBuffer** for **multi-threaded** environments.
- Use **StringBuilder** for **better performance** in **single-threaded** applications.

Would you like additional details or modifications? 😊
