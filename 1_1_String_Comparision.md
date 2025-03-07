# **String Comparison in Java**

Java provides multiple ways to compare strings. These methods can be categorized as follows:

---

## **1. Using `==` Operator (Reference Comparison)**
- The `==` operator checks whether two string references point to the **same memory location**.
- It does **not** compare the actual content of the strings.

### **Example:**
```java
public class StringComparison {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        System.out.println(s1 == s2); // true (same string pool reference)
        System.out.println(s1 == s3); // false (different memory locations)
    }
}
```

---

## **2. Using `.equals()` Method (Content Comparison)**
- This method checks whether the **actual content** of the strings is the same.
- It is **case-sensitive**.

### **Example:**
```java
public class StringComparison {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true
    }
}
```

---

## **3. Using `.equalsIgnoreCase()` (Case-Insensitive Comparison)**
- Similar to `.equals()`, but it **ignores case differences**.

### **Example:**
```java
public class StringComparison {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "hello";

        System.out.println(s1.equals(s2)); // false (case-sensitive)
        System.out.println(s1.equalsIgnoreCase(s2)); // true (case-insensitive)
    }
}
```

---

## **4. Using `.compareTo()` Method (Lexicographical Comparison)**
- Used to compare strings **lexicographically** (dictionary order).
- It returns:
  - `0` → if strings are equal.
  - `< 0` → if the first string is smaller.
  - `> 0` → if the first string is greater.

### **Example:**
```java
public class StringComparison {
    public static void main(String[] args) {
        String s1 = "Apple";
        String s2 = "Banana";
        String s3 = "Apple";

        System.out.println(s1.compareTo(s2)); // Negative (-ve) (Apple < Banana)
        System.out.println(s2.compareTo(s1)); // Positive (+ve) (Banana > Apple)
        System.out.println(s1.compareTo(s3)); // 0 (Apple == Apple)
    }
}
```

---

## **5. Using `.matches()` Method (Pattern Matching)**
- This method checks if a string **matches a given regular expression (regex).**

### **Example:**
```java
public class StringComparison {
    public static void main(String[] args) {
        String s = "Hello123";

        System.out.println(s.matches("Hello123")); // true (exact match)
        System.out.println(s.matches("[A-Za-z]+")); // false (contains numbers)
        System.out.println(s.matches("[A-Za-z0-9]+")); // true (only letters and numbers)
    }
}
```

---

## **6. Using `contentEquals()` (String vs StringBuffer/StringBuilder)**
- `.contentEquals()` compares the content of a `String` with a `StringBuffer` or `StringBuilder`.

### **Example:**
```java
public class StringComparison {
    public static void main(String[] args) {
        String s1 = "Hello";
        StringBuffer s2 = new StringBuffer("Hello");

        System.out.println(s1.contentEquals(s2)); // true
    }
}
```

---

## **Summary Table**
| Method | Purpose | Case-Sensitive? | Compares References? | Compares Content? |
|--------|---------|----------------|---------------------|-----------------|
| `==` | Checks if both references point to the same object | Yes | Yes | No |
| `.equals()` | Checks if content is the same | Yes | No | Yes |
| `.equalsIgnoreCase()` | Checks if content is the same (ignoring case) | No | No | Yes |
| `.compareTo()` | Lexicographical comparison | Yes | No | Yes |
| `.matches()` | Compares using regex | Depends on regex | No | Yes |
| `.contentEquals()` | Compares with `StringBuffer/StringBuilder` | Yes | No | Yes |

---

### **Key Takeaways**
- Use `==` for **reference comparison** (not recommended for content comparison).
- Use `.equals()` for **content comparison**.
- Use `.equalsIgnoreCase()` when **case should be ignored**.
- Use `.compareTo()` for **sorting or ordering** strings.
- Use `.matches()` for **pattern-based comparison**.


