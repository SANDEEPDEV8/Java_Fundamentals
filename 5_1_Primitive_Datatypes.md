# Primitive Data Types

## Overview
Primitive data types are the most basic types of data available in programming languages like Java. These types are used to represent simple values and are directly supported by the language.

## Data Types Table

| Data Type | Bytes | Min Value | Max Value | Default Value |
|-----------|------|-----------|-----------|--------------|
| **byte**  | 1    | \(-2^7\) (-128) | \(2^7 - 1\) (127) | `0` |
| **short** | 2    | \(-2^{15}\) (-32,768) | \(2^{15} - 1\) (32,767) | `0` |
| **int**   | 4    | \(-2^{31}\) (-2,147,483,648) | \(2^{31} - 1\) (2,147,483,647) | `0` |
| **long**  | 8    | \(-2^{63}\) (-9,223,372,036,854,775,808) | \(2^{63} - 1\) (9,223,372,036,854,775,807) | `0L` |
| **float** | 4    | - | - | `0.0f` |
| **double**| 8    | - | - | `0.0d` |
| **char**  | 2    | `0` | \(2^{16} - 1\) (65,535) | `\u0000` |
| **boolean**| -  | - | - | `false` |

## Value Formulas
For signed integer types (byte, short, int, long):

- **Minimum Value**: \(-2^{(bits-1)}\)
- **Maximum Value**: \(2^{(bits-1)} - 1\)

For `char`, which is unsigned:

- **Range**: `0` to \(2^{16}-1\) (0 to 65,535)

## Examples
### Integer Types
```java
byte b = 127;  // Maximum value for byte
byte b2 = -128; // Minimum value

short s = 32767;
short s2 = -32768;

int i = 2147483647;
int i2 = -2147483648;

long l = 9223372036854775807L;
long l2 = -9223372036854775808L;
```

### Floating-Point Types
```java
float f = 3.14f;
double d = 3.141592653589793;
```

### Character Type
```java
char c = 'A';  // Stores a single character
char c2 = 65;  // Represents 'A'
char c3 = '\u0041';  // Unicode for 'A'
```

### Boolean Type
```java
boolean flag = true;
```

## Edge Cases
1. **Overflow & Underflow**
   - When a value exceeds the max/min limit, it wraps around.
   ```java
   byte b = 127;
   b++;  // Wraps around to -128
   ```

2. **Floating Point Precision Issues**
   ```java
   float f = 0.1f + 0.2f;  // May not be exactly 0.3
   ```

3. **Type Casting & Data Loss**
   - Narrowing conversion can cause precision loss.
   ```java
   int i = (int) 3.99;  // Becomes 3
   ```

