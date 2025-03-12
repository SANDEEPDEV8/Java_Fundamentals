# Understanding `final` in Java

The `final` keyword in Java is a **non-access modifier** that can be applied to **variables, methods, and classes** to restrict modifications.

---

## **1. `final` with Variables**
- If a variable is declared as `final`, its value **cannot be changed** once assigned.
- A `final` variable **must be initialized** either at the time of declaration or inside a constructor.

### **Example:**
```java
class FinalVariableExample {
    final int MAX_USERS = 100; // Initialized at declaration
    final int minAge;

    FinalVariableExample() {
        minAge = 18; // Allowed: Initialization inside constructor
    }

    void display() {
        System.out.println("Max Users: " + MAX_USERS);
        System.out.println("Min Age: " + minAge);
    }
}

public class Main {
    public static void main(String[] args) {
        FinalVariableExample obj = new FinalVariableExample();
        obj.display();
    }
}
```
### **Output:**
```
Max Users: 100
Min Age: 18
```
#### **Edge Cases:**
- A `final` variable **cannot be reassigned**.
- If declared but **not initialized**, it must be set in the **constructor**.

---

## **2. `final` with Methods**
- A `final` method **cannot be overridden** by subclasses.

### **Example:**
```java
class Parent {
    final void show() {
        System.out.println("This is a final method.");
    }
}

class Child extends Parent {
    // void show() { ❌ ERROR: Cannot override final method
    //     System.out.println("Attempting to override");
    // }
}

public class Main {
    public static void main(String[] args) {
        Parent obj = new Parent();
        obj.show();
    }
}
```
### **Output:**
```
This is a final method.
```
#### **Edge Cases:**
- A `final` method **can still be inherited** but not overridden.

---

## **3. `final` with Classes**
- A `final` class **cannot be extended (inherited)**.

### **Example:**
```java
final class Vehicle {
    void showType() {
        System.out.println("This is a vehicle.");
    }
}

// class Car extends Vehicle { ❌ ERROR: Cannot inherit from final class
// }

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.showType();
    }
}
```
### **Output:**
```
This is a vehicle.
```
#### **Edge Cases:**
- **Useful for security**: Prevents modification of critical classes (e.g., `java.lang.String` is final).
- **Performance optimization**: Allows compiler optimizations since the class behavior is fixed.

---

## **4. `static final` Variables (Constants)**
- A `static final` variable is **a constant that belongs to the class**.
- It **must be initialized** at declaration or in a **static block**.

### **Example:**
```java
class Constants {
    static final double PI = 3.14159; // Initialized at declaration
    static final int MAX_SPEED;

    static {
        MAX_SPEED = 120; // Allowed inside a static block
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("PI: " + Constants.PI);
        System.out.println("Max Speed: " + Constants.MAX_SPEED);
    }
}
```
### **Output:**
```
PI: 3.14159
Max Speed: 120
```
#### **Edge Cases:**
- **Cannot modify `static final` variables** after initialization.
- **Must be initialized in a static block** if not declared inline.

---

## **5. Summary**
| Feature | `final` Variable | `final` Method | `final` Class |
|---------|----------------|----------------|--------------|
| **Modification Allowed?** | ❌ No | ❌ No (Cannot Override) | ❌ No (Cannot Extend) |
| **Inheritance?** | ✅ Yes | ✅ Yes (Inherited but not Overridden) | ❌ No |
| **Example Usage** | Constants, Immutable Data | Preventing Method Overriding | Preventing Class Inheritance |

