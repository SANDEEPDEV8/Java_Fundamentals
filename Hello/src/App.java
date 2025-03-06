import oops.Animal;
import oops.Circle;


import java.lang.*;

public class App {

    // run > java App arg1 arg2
    public static void main(String[] args) throws Exception {
        //A_InputOutput.run();

        //OOPS
        Animal animal = new Animal("Fred", 10, true);
        System.out.println(animal.name);


        Animal animal2 = new Animal();
        //----------------------------------
        Circle circle1 = new Circle(); // Default radius
        Circle circle2 = new Circle(25); // Specified radius
        Circle circle3 = new Circle(125); // Specified radius

        // Display properties of each circle
        System.out.println("Circle1: Radius = " + circle1.getRadius() + ", Area = " + circle1.getArea() + ", Perimeter = " + circle1.getPerimeter());
        System.out.println("Circle2: Radius = " + circle2.getRadius() + ", Area = " + circle2.getArea() + ", Perimeter = " + circle2.getPerimeter());
        System.out.println("Circle3: Radius = " + circle3.getRadius() + ", Area = " + circle3.getArea() + ", Perimeter = " + circle3.getPerimeter());

    }
}