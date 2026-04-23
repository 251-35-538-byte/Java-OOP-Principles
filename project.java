abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow Meow!");
    }
}

public class Zoo {
    public static void main(String[] args) {
        Animal[] myPets = {
            new Dog("Buddy"),
            new Cat("Kitty")
        };

        System.out.println("--- Animal Sound System ---");
        for (Animal a : myPets) {
            a.makeSound(); 
        }
    }
}
