package oops;

public  class Car {
    protected String brand;
    public String model;
    public Car() {

    }
    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    // Public method
     void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model);
    }
}
