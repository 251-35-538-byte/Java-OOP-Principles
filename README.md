

```java
// 1. ABSTRACTION: An abstract class serves as a blueprint
abstract class Animal {
    // 2. ENCAPSULATION: Private field to hide data from direct access
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // Encapsulation: Public getter to access private data safely
    public String getName() {
        return name;
    }

    // Abstraction: Every animal makes a sound, but the implementation is specific
    public abstract void makeSound();
}

// 3. INHERITANCE: Dog "is-an" Animal
class Dog extends Animal {
    public Dog(String name) {
        super(name); // Pass name to parent constructor
    }

    @Override
    public void makeSound() {
        // Accessing name via getter due to encapsulation
        System.out.println(getName() + " says: Woof Woof!");
    }
}

// 3. INHERITANCE: Cat "is-an" Animal
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow Meow!");
    }
}

// Main Class to run the system
public class Zoo {
    public static void main(String[] args) {
        // 4. POLYMORPHISM: Storing different animal types in one Animal array
        Animal[] myPets = {
            new Dog("Buddy"),
            new Cat("Kitty")
        };

        System.out.println("--- Animal Sound System ---");
        for (Animal a : myPets) {
            // Polymorphism: Java decides at runtime which sound to play
            a.makeSound(); 
        }
    }
}
```


