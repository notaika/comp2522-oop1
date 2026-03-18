package org.bcit.comp2522.winter2023.midterm_takeup.questions;

import java.util.ArrayList;

/**
 * The Intermediate_05_PlantManager class is a variation of the original
 * Intermediate_05_ClockManager question. This question tests the ability
 * to create systems of classes for managing different types of plants.
 *
 * In the original question, the goal was to create a system of classes
 * and interfaces for managing clocks and timers, following SOLID principles.
 *
 * In this variation of the question, the focus is on creating a system
 * of classes and interfaces for managing plants with different properties
 * and behaviors, such as growth and water consumption.
 */
public class Intermediate_05_PlantManager {
  ArrayList<Intermediate_05_Plant> plants;
  ArrayList<Intermediate_05_Growable> growables;
  ArrayList<Intermediate_05_Waterable> waterables;

  public static void main(String[] args) {
    Intermediate_05_Plant tree = new Intermediate_05_Tree();
    Intermediate_05_Plant flower = new Intermediate_05_Flower();
    Intermediate_05_Growable vegetable = new Intermediate_05_Vegetable();

    plants.add(tree);
    plants.add(flower);

    growables.add(tree);
    growables.add(flower);
    growables.add(vegetable);

    waterables.add(tree);
    waterables.add(flower);
    waterables.add(vegetable);

    for (Intermediate_05_Growable growable : growables) {
      growable.grow();
    }
    for (Intermediate_05_Waterable waterable : waterables) {
      waterable.water();
    }
  }
}
