package org.bcit.comp2522.winter2023.midterm_takeup.questions;

/**
 * The Intermediate_06_CharComparable class is a version of the original
 * Intermediate_06_Comparable question. This question tests the ability
 * to follow interface requirements by implementing a CharComparable class.
 *
 * In the original question, the task was to create a class called
 * Intermediate_06_Comparable with a float attribute and make the class
 * implement the Comparable interface, comparing the instances based on
 * the float attribute.
 *
 * In this question, the concept remains the same, but the subject has
 * been changed to a CharComparable class with a char attribute.
 */
public class Intermediate_06_CharComparable {
  // Idea: tests your ability to follow interface requirements.


  private char c;
  public Intermediate_06_CharComparable(char c) {
    this.c = c;
  }

  // TODO 1: Implement an equals method that checks the class
  // attribute c against the incoming object. Equality should be only
  // between classes that are the same.

  // TODO 2: Make this class implement Comparable. Implement all of the
  // methods that the interface demands. Compare along the c dimension.
  // Ensure that equality in the equals method is the same as in compareTo.

  // TODO 3: Create a main method that demonstrates EACH of the Comparable
  // conditions, including the exceptions.
}
