import java.util.Scanner;
import static java.lang.System.out;

public class A_InputOutput {

    public static void run() {
        System.out.println("Hello, World!");
        // System.out.println(args[0]);

        Scanner sc = new Scanner(System.in); // use >javapjava.util.scanner to see inside or click f12
        // out.println("Enter your name, age, height: ");
        // String name = sc.nextLine();
        // int age = sc.nextInt();
        // float height = sc.nextFloat();

        // out.println("your name is : " + name);
        // out.println("your age is: " + age);
        // out.println("your height is: " + height);

        // out.println("only next: ");
        // String onlyNext = sc.next();
        // out.println("only next is : " + onlyNext);

        // // ADD 2 numbers
        // int x, y;
        // out.println("Enter 2 numbers to add:");
        // x = sc.nextInt();
        // y = sc.nextInt();
        // int added = x + y;
        // out.println("result is : " + added);

        // Read in binary
        out.println("Enter number in binary form:");
        sc.useRadix(2);
        int binary = sc.nextInt(); // 1010
        out.println("result is : " + binary);

        sc.close();
    }
}
