package com.omar.learn.abstract_classes;

/**
 * @author Omar
 * @version 10/17/22
 */
public class Main {

    public static void main(String[] args) {
        Animal a = new Dog();
        a.eat();
        a.run();

    }
}

abstract class Animal {

    public void run() {
        System.out.println("Animal is running");
    }

     abstract public void eat();
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }
}

/*
*   Rules for abstract keyword:
*       1. Abstract classes
*           * You cannot create an object of an abstract class
*           * You can create a reference of an abstract class
*           * It may or may not contain abstract methods
*
*      2. Abstract methods
*          * No method body. You cannot write code inside the method
*          * It is mandatory to override the abstract method in the subclass
*
*
*/
