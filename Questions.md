# Secure Password Storage in Java

<details>
  <summary>What is the best way to store passwords in Java?</summary>

## 1. Use `char[]` (Recommended)
- **Why?** `char[]` is preferable over `String` because it allows you to clear the password from memory once it's no longer needed.
- **How?** You can overwrite the array after use.

```java
char[] password = new char[]{'s', 'e', 'c', 'r', 'e', 't'};
// Use the password...
Arrays.fill(password, ' '); // Clear the password from memory
```

## 2. Use `byte[]` (For Hashed Passwords)
- If passwords are stored in a database, **always hash them first** using algorithms like **PBKDF2, BCrypt, or Argon2**.
- Hashes should be stored as `byte[]`, not as a `String`, to avoid exposing sensitive information.

```java
byte[] hashedPassword = hashPassword("secretPassword");
// Store hashedPassword securely (e.g., in a database)
```

## 3. `SecureString` (Not Available in Java by Default)
- Some other languages have a `SecureString` class, but in Java, you'll need to use `char[]` or `byte[]` and manually clear them.

## Why Not `String`?
- **Immutable:** Strings are stored in the Java String Pool, making them harder to clear from memory.
- **Potential Exposure:** They may remain in memory for an unpredictable time and could be accessed by memory dump tools.

## Best Practices for Password Handling in Java
1. **Use `char[]` or `byte[]` instead of `String`.**
2. **Always hash passwords** before storing using PBKDF2, BCrypt, or Argon2.
3. **Use Secure Random Salt** to prevent rainbow table attacks.
4. **Encrypt passwords if storing temporarily in memory.**
5. **Clear the password data** immediately after use to avoid memory leaks.

Would you like a sample implementation of secure password hashing in Java? 🚀

</details>
