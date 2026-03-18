package org.bcit.comp2522.winter2023.midterm_takeup.questions;

import java.util.ArrayList;

/**
 * The Basic_04_ZooManager class is an alternative version of the original
 * Basic_04_DrawingManager question that I've created. This question tests
 * the ability to create and use interfaces with a different
 * topic: managing a zoo with different types of animals.
 *
 * In solving this problem, I created an interface called Basic_04_Animal,
 * which promises a single method named makeSound. I then implemented two
 * classes, Basic_04_Lion and Basic_04_Elephant, which represent two
 * different types of animals in the zoo and implement the Basic_04_Animal
 * interface.
 */
public class Basic_04_ZooManager {
  // Idea: tests your ability to create and use interfaces

  // TODO 1: Create an interface called Basic_04_Animal which promises
  // a single "makeSound" method.

  // TODO 2: Make the classes necessary to make the methods below work.
  // All concrete classes, including this one, should implement your interface.

  ArrayList<Basic_04_Animal> animals;

  public Basic_04_ZooManager() {
    this.animals = new ArrayList<Basic_04_Animal>();
  }

  public void add(Basic_04_Lion lion) {
    animals.add(lion);
  }

  public void add(Basic_04_Elephant elephant) {
    animals.add(elephant);
  }

  public void makeAllAnimalsSound() {
    for (Basic_04_Animal animal : animals) {
      animal.makeSound();
    }
  }

  public static void main(String[] args) {
    Basic_04_ZooManager zooManager = new Basic_04_ZooManager();
    Basic_04_Lion lion = new Basic_04_Lion();
    Basic_04_Elephant elephant = new Basic_04_Elephant();
    zooManager.add(lion);
    zooManager.add(elephant);
    zooManager.makeAllAnimalsSound();
  }
}
