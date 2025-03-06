package oops;

public class Animal {
    public String name;
    public int numberOfLegs;
    public boolean hungry;

    public Animal() {

    }

    public Animal(String name, int numberOfLegs, boolean hungry) {
        this.name = name;
        this.numberOfLegs = numberOfLegs;
        this.hungry = hungry;

    }

    void eat(){
        System.out.println("Eating...");
    }

    boolean isHungry(){
        return hungry;
    }

    void sleep(){
        System.out.println("Sleeping...");
    }

}
