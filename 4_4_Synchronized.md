## **Understanding `synchronized` in Java**
The `synchronized` keyword in Java is a non-access modifier used for thread synchronization. It ensures that only one thread can access a critical section of code at a time, preventing race conditions in multi-threaded environments.

---

### **How `synchronized` Works**
1. **Ensures Mutual Exclusion**: Only one thread can execute a `synchronized` method or block at a time.
2. **Prevents Race Conditions**: Ensures data integrity by preventing multiple threads from modifying shared data simultaneously.
3. **Monitors (Locks) are Used**: Each Java object has a lock (monitor), and when a thread enters a synchronized block/method, it acquires the lock and releases it when exiting.

---

### **Where Can We Use `synchronized`?**
- **On methods**: Synchronizes the entire method.
- **On blocks**: Synchronizes only a part of the method.

---

### **Simple Intuitive Examples**

#### **1. Synchronized Method**
Imagine a bank account where multiple users can deposit money simultaneously.

```java
class BankAccount {
    private int balance = 0;

    // Synchronizing the method to prevent race conditions
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", Balance: " + balance);
    }
}

public class SyncExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Creating multiple threads trying to deposit money
        Thread t1 = new Thread(() -> account.deposit(100), "User1");
        Thread t2 = new Thread(() -> account.deposit(200), "User2");

        t1.start();
        t2.start();
    }
}
```

🔹 **Why use `synchronized`?**
Without synchronization, `balance` might be updated incorrectly due to simultaneous deposits.

---

#### **2. Synchronized Block**
Instead of synchronizing the entire method, we can synchronize only the critical section.

```java
class SharedResource {
    public void printNumbers() {
        // Only this part is synchronized, allowing better performance
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " prints: " + i);
                try {
                    Thread.sleep(100); // Simulating delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class SyncBlockExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread t1 = new Thread(() -> resource.printNumbers(), "Thread1");
        Thread t2 = new Thread(() -> resource.printNumbers(), "Thread2");

        t1.start();
        t2.start();
    }
}
```

🔹 **Why use a `synchronized` block?**
Only the critical code is synchronized, improving performance by allowing multiple threads to run non-critical sections concurrently.

---

### **Edge Cases and Important Notes**
1. **Deadlock Risk**  
   If multiple threads hold locks and wait for each other to release them, a deadlock may occur. Example:

   ```java
   class DeadlockExample {
       private final Object lock1 = new Object();
       private final Object lock2 = new Object();

       public void method1() {
           synchronized (lock1) {
               System.out.println("Method1 locked lock1");
               synchronized (lock2) {
                   System.out.println("Method1 locked lock2");
               }
           }
       }

       public void method2() {
           synchronized (lock2) {
               System.out.println("Method2 locked lock2");
               synchronized (lock1) {
                   System.out.println("Method2 locked lock1");
               }
           }
       }
   }
   ```

   If one thread executes `method1()` and another executes `method2()`, they might both get stuck waiting for each other’s lock.

2. **Performance Overhead**  
   Synchronization adds some performance overhead. If unnecessary, avoid using it.

3. **Atomicity of Primitive Operations**  
   Operations like `int x = 5;` are atomic and don’t need synchronization unless shared between multiple threads.

4. **Volatile vs. Synchronized**  
   - `volatile` ensures visibility but not atomicity.
   - `synchronized` ensures both atomicity and visibility.

---

### **Final Thoughts**
- Use **synchronized methods** when entire operations must be thread-safe.
- Use **synchronized blocks** when only specific parts need protection.
- Be careful of **deadlocks** when using multiple locks.
- Consider **ReentrantLock** or **java.util.concurrent** utilities for more advanced control.

