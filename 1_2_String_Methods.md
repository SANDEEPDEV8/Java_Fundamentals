# **String Methods in Java**

## **1. char charAt(int index)**
- Returns the character at the specified index.

### **Example:**
```java
String str = "Hello";
System.out.println(str.charAt(1)); // Output: e
```

---

## **2. int length()**
- Returns the length of the string.

### **Example:**
```java
String str = "Hello";
System.out.println(str.length()); // Output: 5
```

---

## **3. String substring(int beginIndex)**
- Returns the substring from the given `beginIndex` to the end.

### **Example:**
```java
String str = "HelloWorld";
System.out.println(str.substring(5)); // Output: World
```

---

## **4. String substring(int beginIndex, int endIndex)**
- Returns a substring between `beginIndex` and `endIndex`.

### **Example:**
```java
String str = "HelloWorld";
System.out.println(str.substring(0, 5)); // Output: Hello
```

---

## **5. boolean contains(CharSequence s)**
- Returns `true` if the string contains the given sequence.

### **Example:**
```java
String str = "HelloWorld";
System.out.println(str.contains("World")); // Output: true
```

---

## **6. static String join(CharSequence delimiter, CharSequence... elements)**
- Joins multiple strings with a delimiter.

### **Example:**
```java
String result = String.join("-", "Hello", "World", "Java");
System.out.println(result); // Output: Hello-World-Java
```

---

## **7. boolean equals(Object another)**
- Checks if two strings are equal.

### **Example:**
```java
String str1 = "Hello";
String str2 = "Hello";
System.out.println(str1.equals(str2)); // Output: true
```

---

## **8. boolean isEmpty()**
- Returns `true` if the string is empty.

### **Example:**
```java
String str = "";
System.out.println(str.isEmpty()); // Output: true
```

---

## **9. String concat(String str)**
- Concatenates the specified string.

### **Example:**
```java
String str = "Hello";
str = str.concat(" World");
System.out.println(str); // Output: Hello World
```

---

## **10. String replace(char old, char new)**
- Replaces all occurrences of a character.

### **Example:**
```java
String str = "Java";
System.out.println(str.replace('a', 'o')); // Output: Jovo
```

---

## **11. String replace(CharSequence old, CharSequence new)**
- Replaces all occurrences of a substring.

### **Example:**
```java
String str = "Java is fun";
System.out.println(str.replace("fun", "awesome")); // Output: Java is awesome
```

---

## **12. static String equalsIgnoreCase(String another)**
- Compares two strings ignoring case.

### **Example:**
```java
String str1 = "HELLO";
String str2 = "hello";
System.out.println(str1.equalsIgnoreCase(str2)); // Output: true
```

---

## **13. String[] split(String regex)**
- Splits the string based on regex.

### **Example:**
```java
String str = "Java,Python,C++";
String[] arr = str.split(",");
for(String s : arr) {
    System.out.println(s);
}
```
**Output:**
```
Java
Python
C++
```

---

## **14. String intern()**
- Returns a string from the **string pool**.

### **Example:**
```java
String s1 = new String("Hello").intern();
String s2 = "Hello";
System.out.println(s1 == s2); // Output: true
```

---

## **15. int indexOf(String str)**
- Returns the index of the first occurrence of a substring.

### **Example:**
```java
String str = "HelloWorld";
System.out.println(str.indexOf("World")); // Output: 5
```

---

## **16. String toLowerCase()**
- Converts to lowercase.

### **Example:**
```java
String str = "HELLO";
System.out.println(str.toLowerCase()); // Output: hello
```

---

## **17. String toUpperCase()**
- Converts to uppercase.

### **Example:**
```java
String str = "hello";
System.out.println(str.toUpperCase()); // Output: HELLO
```

---

## **18. String trim()**
- Removes leading and trailing spaces.

### **Example:**
```java
String str = "  Java  ";
System.out.println(str.trim()); // Output: Java
```

---

## **19. static String valueOf(int value)**
- Converts an integer to a string.

### **Example:**
```java
int num = 100;
String str = String.valueOf(num);
System.out.println(str); // Output: 100
```

---

