package oops;

public class Circle {
    private double radius;

    public Circle() {
        this.radius = 1.0; // Default radius
    }

    public Circle(double newRadius) {
        this.radius = newRadius;
    }

    public double getArea() {
        return Math.PI * radius * radius; // Area = π * r^2
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius; // Perimeter = 2 * π * r
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    public double getRadius() {
        return radius;
    }

}
