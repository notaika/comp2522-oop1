package org.bcit.comp2522.winter2023.midterm_takeup.questions;

import java.util.ArrayList;

/**
 * This class represents an alternative question that tests the same concepts
 * as the original question, Basic_03_CoffeeMaker. The unique version
 * demonstrates the student's ability to create super/subclasses and extend
 * the functionality of a superclass. In this version, the student is asked
 * to create a Tree subclass that extends the Basic_03_Forest class,
 * adding methods to grow the tree and shed leaves. This alternative question
 * tests the same concepts as the original by requiring the student to inherit
 * existing functionality from a superclass and extend it with new features,
 * while also ensuring that the core functionality of the superclass remains intact.
 */
public class Basic_03_Forest {

  ArrayList<Basic_03_Tree> trees;

  public Basic_03_Forest() {
    trees = new ArrayList<>();
  }

  public void addTree(Basic_03_Tree tree) {
    trees.add(tree);
  }

  public double calculateAverageHeight() {
    double totalHeight = 0;
    for (Basic_03_Tree tree : trees) {
      totalHeight += tree.height;
    }
    return totalHeight / trees.size();
  }

  public int calculateTotalLeaves() {
    int totalLeaves = 0;
    for (Basic_03_Tree tree : trees) {
      totalLeaves += tree.numberOfLeaves;
    }
    return totalLeaves;
  }

  // TODO 1: Create a subclass called Basic_03_Tree that EXTENDS this class by adding
  // functionality to grow the tree and shed leaves. You MUST NOT recreate any functionality
  // that this class already implements. You MUST use this class.

  public static void main(String[] args) {
    Basic_03_Forest forest = new Basic_03_Forest();
    forest.addTree(new Basic_03_Tree(10, 100));
    forest.addTree(new Basic_03_Tree(15, 200));
    forest.addTree(new Basic_03_Tree(7, 50));

    double averageHeight = forest.calculateAverageHeight();
    System.out.println("The forest has an average height of " + averageHeight + " meters.");
    // Output: The forest has an average height of 10.666666666666666 meters.

    int totalLeaves = forest.calculateTotalLeaves();
    System.out.println("The forest has a total of " + totalLeaves + " leaves.");
    // Output: The forest has a total of 350 leaves.
  }
}
