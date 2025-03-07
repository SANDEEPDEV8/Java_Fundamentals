# Understanding `static` in Java (with Edge Cases & Code Examples)

The `static` keyword in Java is a **non-access modifier** used for memory management. It can be applied to **variables, methods, blocks, and inner classes**.

---

## **1. `static` Variables (Class Variables)**
- A `static` variable belongs to the **class** rather than instances.
- Only **one copy** of a `static` variable exists, **shared across all instances**.
- Can be accessed **without creating an object**.

### **Example:**
```java
class Example {
    static int count = 0; // Static variable

    Example() {
        count++;
        System.out.println("Instance created, count: " + count);
    }

    public static void main(String[] args) {
        Example e1 = new Example();
        Example e2 = new Example();
        Example e3 = new Example();
    }
}
```
### **Output:**
```
Instance created, count: 1
Instance created, count: 2
Instance created, count: 3
```
#### **Edge Case:**
- If you **modify a static variable**, it affects **all instances**.

---

## **2. `static` Methods**
- A `static` method **belongs to the class**, not instances.
- It **cannot access non-static members** (variables or methods).
- It **cannot use `this` or `super`**.

### **Example:**
```java
class MathUtils {
    static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        System.out.println("Square of 5: " + MathUtils.square(5));
    }
}
```
### **Output:**
```
Square of 5: 25
```
#### **Edge Cases:**
1. **Cannot Access Non-Static Members:**
   ```java
   class Example {
       int a = 10;
       static void show() {
           // System.out.println(a); // ❌ ERROR: Non-static field cannot be referenced from a static context
       }
   }
   ```
2. **Cannot Use `this` or `super`:**
   ```java
   class Parent {
       int a = 10;
       static void show() {
           // System.out.println(this.a); // ❌ ERROR: Cannot use 'this' in a static method
       }
   }
   ```

---

## **3. `static` Blocks (Static Initialization Block)**
- A **static block executes once**, when the class is loaded.
- Used to initialize `static` variables.

### **Example:**
```java
class Test {
    static int a;
    
    static {
        a = 100;
        System.out.println("Static Block Executed");
    }

    public static void main(String[] args) {
        System.out.println("Value of a: " + a);
    }
}
```
### **Output:**
```
Static Block Executed
Value of a: 100
```
#### **Edge Case:**
- Static blocks **execute before `main()`** when the class is loaded.

---

## **4. `static` Inner Classes**
- A `static` inner class **can be instantiated without an object** of the outer class.
- Cannot **access non-static members** of the outer class.

### **Example:**
```java
class Outer {
    static class Inner {
        void show() {
            System.out.println("Inside static inner class");
        }
    }

    public static void main(String[] args) {
        Outer.Inner obj = new Outer.Inner(); // No need to create an Outer instance
        obj.show();
    }
}
```
### **Output:**
```
Inside static inner class
```
#### **Edge Case:**
- A static inner class **cannot access non-static variables** of the outer class.

---

## **5. `static` and `final` Together**
- `static final` makes a **constant**.

### **Example:**
```java
class Config {
    static final int MAX_USERS = 100;
}
```
#### **Edge Case:**
- The value of a `static final` variable **must be initialized at declaration**.

---

## **6. `static` and Abstract Methods (Not Allowed)**
- **Static methods cannot be `abstract`** because `static` methods belong to the class, whereas `abstract` methods require **overriding in subclasses**.

```java
abstract class Example {
    // static abstract void display(); ❌ ERROR: Static methods cannot be abstract
}
```

---

## **Key Takeaways**
| Feature            | Static Variable | Static Method | Static Block | Static Class |
|--------------------|----------------|--------------|--------------|--------------|
| **Belongs To**    | Class          | Class        | Class        | Class        |
| **Instances Share?** | ✅ Yes | ✅ Yes | ✅ Yes | ✅ Yes |
| **Can Access Non-Static Members?** | ❌ No | ❌ No | ❌ No | ❌ No |
| **Executed Only Once?** | ✅ Yes | ❌ No | ✅ Yes | ✅ Yes |
| **Needs Object Creation?** | ❌ No | ❌ No | ❌ No | ❌ No |

---

### **Final Edge Case**
```java
class Test {
    static int x = 10;

    static {
        System.out.println("Static block executed");
        x = 20;
    }

    public static void main(String[] args) {
        System.out.println("Main executed, x: " + x);
    }
}
```
### **Output:**
```
Static block executed
Main executed, x: 20
```
💡 **Explanation:** The static block runs **before `main()`**, initializing `x` to `20`.

---

