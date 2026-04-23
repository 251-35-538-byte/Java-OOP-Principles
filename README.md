

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

## ১. Abstraction (অ্যাবস্ট্রাকশন) – বিমূর্তকরণ
- **`abstract class Animal`** একটি ব্লুপ্রিন্ট (নকশা)। এটির অবজেক্ট সরাসরি তৈরি করা যায় না।
- এখানে `public abstract void makeSound();` – শুধু ঘোষণা আছে, বাস্তবায়ন নেই। প্রতিটি প্রাণী নিজের মতো করে শব্দ করবে, কিন্তু অ্যানিমাল ক্লাস বলে দেয় “যে কোনো Animal-এর একটা `makeSound` মেথড থাকবেই”।
- **কেন ব্যবহার করি?** মূল বিস্তারিত লুকিয়ে শুধু প্রয়োজনীয় জিনিস দেখানো (যেমন: ডগ আর ক্যাট কীভাবে শব্দ করে সেটা তাদের ওপর ছেড়ে দেওয়া)।

## ২. Encapsulation (এনক্যাপসুলেশন) – তথ্য গুটিয়ে রাখা
- **`private String name;`** – name ভেরিয়েবলকে সরাসরি বাইরে থেকে অ্যাক্সেস করা যাবে না। এটি ডেটা হাইডিং করে।
- বাইরে থেকে নাম জানতে হলে **`public String getName()`** মেথড ব্যবহার করতে হবে। এটাই সুরক্ষিত উপায়ে ডেটা অ্যাক্সেসের নিয়ম।
- Dog বা Cat-এর `makeSound()`-এর ভিতরে আমরা `getName()` কল করছি, সরাসরি `name` ব্যবহার করছি না – এটাই encapsulation-এর ব্যবহার।

## ৩. Inheritance (ইনহেরিটেন্স) – বংশগতি
- **`class Dog extends Animal`** এবং **`class Cat extends Animal`** – মানে “Dog হলো একটি Animal” এবং “Cat হলো একটি Animal” (is-a relationship)।
- সব ডগ আর ক্যাট Animal-এর সমস্ত বৈশিষ্ট্য (যেমন name ফিল্ড ও getName মেথড) পেয়ে যায়। এদের শুধু নিজেদের `makeSound` মেথড লিখলেই চলবে।
- `super(name)` দিয়ে প্যারেন্ট ক্লাসের কনস্ট্রাক্টর কল করা হচ্ছে, যাতে name সেট হয়।

## ৪. Polymorphism (পলিমরফিজম) – বহুরূপতা
- **`Animal[] myPets = { new Dog("Buddy"), new Cat("Kitty") };`** – এখানে টাইপ হচ্ছে `Animal`, কিন্তু রিয়েল অবজেক্ট হচ্ছে `Dog` ও `Cat`। একটি প্যারেন্ট টাইপের ভেরিয়েবল বা অ্যারের মাধ্যমে চাইল্ড অবজেক্ট রাখা যায়।
- লুপের ভিতরে `a.makeSound();` কল করলে Java রান টাইমে বুঝতে পারে `a` আসলে কিসের অবজেক্ট – ডগ না ক্যাট – এবং সেই অনুযায়ী সঠিক `makeSound` রান করে। 
  - প্রথমবার `a` ডগ (Buddy) – আউটপুট: `Buddy says: Woof Woof!`
  - দ্বিতীয়বার `a` ক্যাট (Kitty) – আউটপুট: `Kitty says: Meow Meow!`
- এটাই পলিমরফিজম – একই ইন্টারফেস (makeSound) বিভিন্ন আকারে কাজ করে।

## আউটপুট:
```
--- Animal Sound System ---
Buddy says: Woof Woof!
Kitty says: Meow Meow!
```

## সংক্ষেপে চারটি নীতি কেন গুরুত্বপূর্ণ?
- **Abstraction** → জটিলতা কমায়, শুধু প্রয়োজনীয় জিনিস বাইরে দেখায়।
- **Encapsulation** → ডেটা সুরক্ষিত রাখে, ভুলবশত ডেটা নষ্ট হওয়া থেকে বাঁচায়।
- **Inheritance** → কোড পুনঃব্যবহারযোগ্য করে (Animal-এর কোড বারবার লিখতে হয় না)।
- **Polymorphism** → একটি ভেরিয়েবল দিয়ে একাধিক ধরনের অবজেক্ট নিয়ে একই মেথড কল করা যায়, প্রোগ্রাম নমনীয় হয়।

এই কোডটি ছোট হলেও OOP-এর মৌলিক ধারণাগুলো একদম পরিষ্কারভাবে বুঝিয়ে দেয়। 😊
