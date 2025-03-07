# Understanding Static and Instance Initialization Blocks in Java

The `static` keyword in Java is a **non-access modifier** used for memory management. It can be applied to **variables, methods, blocks, and inner classes**.

---

## **1. Code Execution Order in Java**
```java
class InitTest {
    
    // Constructor with one argument
    InitTest(int x) {
        System.out.println("1-arg const");
    }

    // No-argument constructor
    InitTest() {
        System.out.println("no-arg const");
    }

    // First static block
    static {
        System.out.println("1st static init");
    }

    // First instance initialization block
    {
        System.out.println("1st instance init");
    }

    // Second instance initialization block
    {
        System.out.println("2nd instance init");
    }

    // Second static block
    static {
        System.out.println("2nd static init");
    }

    public static void main(String[] args) {
        new InitTest();   // First instance
        new InitTest(7);  // Second instance
    }
}
```

---

## **2. Expected Output**
```
1st static init
2nd static init
1st instance init
2nd instance init
no-arg const
1st instance init
2nd instance init
1-arg const
```

---

## **3. Explanation of Execution Order**
1. **Static blocks execute first (only once when the class is loaded).**
   - `"1st static init"` is printed.
   - `"2nd static init"` is printed.
   
2. **Instance blocks execute every time an object is created.**
   - First, the **instance initialization blocks** execute in the order they appear.
   - Then, the **constructor executes**.

3. **Steps when creating `new InitTest();`**
   - `"1st instance init"`
   - `"2nd instance init"`
   - `"no-arg const"`

4. **Steps when creating `new InitTest(7);`**
   - `"1st instance init"`
   - `"2nd instance init"`
   - `"1-arg const"`

---

## **4. Key Rules**
- **Static blocks** execute **only once** when the class is **loaded into memory**.
- **Instance blocks** execute **before** the constructor, every time an instance is created.
- The order of execution **matches the order they appear** in the class.
- **Instance blocks are useful** for initializing common values across all constructors without duplicating code.

---

## **5. Edge Cases and Examples**
### **Case 1: Multiple Objects Execution Order**
```java
class Test {
    static {
        System.out.println("Static block");
    }
    
    {
        System.out.println("Instance block");
    }

    Test() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        new Test();
        new Test();
    }
}
```
### **Output**
```
Static block
Instance block
Constructor
Instance block
Constructor
```

---

### **Case 2: Constructor Calling Another Constructor**
```java
class Example {
    {
        System.out.println("Instance Block");
    }

    Example() {
        this(10); // Calling another constructor
        System.out.println("No-arg Constructor");
    }

    Example(int x) {
        System.out.println("1-arg Constructor");
    }

    public static void main(String[] args) {
        new Example();
    }
}
```
### **Output**
```
Instance Block
1-arg Constructor
No-arg Constructor
```

---

### **Case 3: Static Block Accessing Instance Variables**
```java
class Demo {
    int x = 10;

    static {
        // System.out.println(x); // ❌ ERROR: Cannot access instance variable in static block
    }
}
```
💡 **Explanation:** Static blocks **cannot access instance variables** because **they belong to the class, not an instance**.

---

### **Case 4: Static and Instance Blocks Together**
```java
class Mixed {
    static {
        System.out.println("Static Block");
    }

    {
        System.out.println("Instance Block");
    }

    Mixed() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        System.out.println("Main Method");
        new Mixed();
        new Mixed();
    }
}
```
### **Output**
```
Static Block
Main Method
Instance Block
Constructor
Instance Block
Constructor
```

---

## **6. When to Use Static and Instance Blocks?**
| Feature | Static Block | Instance Block |
|---------|-------------|---------------|
| **Execution** | Runs once when the class is loaded | Runs every time an object is created |
| **Access** | Can only access static variables | Can access both static and instance variables |
| **Use Case** | Used for static initializations like database connections | Used to initialize instance variables before constructors |
| **Example** | Initializing a logger or a constant | Setting default values for object fields |

---

## **7. Summary**
- **Static blocks run once** when the class is loaded.
- **Instance blocks run every time an object is created**, before the constructor.
- **Instance blocks are useful** when multiple constructors share common code.
- **Static blocks cannot access instance variables**, but instance blocks can access static variables.

