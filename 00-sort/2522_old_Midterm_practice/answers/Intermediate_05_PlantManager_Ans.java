package org.bcit.comp2522.winter2023.midterm_takeup.answers;

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
public class Intermediate_05_PlantManager_Ans {
  ArrayList<Intermediate_05_Plant> plants;
  ArrayList<Intermediate_05_Growable> growables;
  ArrayList<Intermediate_05_Waterable> waterables;

  public static void main(String[] args) {
    Intermediate_05_PlantManager_Ans plantManager = new Intermediate_05_PlantManager_Ans();


    Intermediate_05_Plant tree = new Intermediate_05_Tree();
    Intermediate_05_Plant flower = new Intermediate_05_Flower();
    Intermediate_05_Growable vegetable = new Intermediate_05_Vegetable();

    plantManager.plants.add(tree);
    plantManager.plants.add(flower);

    plantManager.growables.add(tree);
    plantManager.growables.add(flower);
    plantManager.growables.add(vegetable);

    plantManager.waterables.add(tree);
    plantManager.waterables.add(flower);
    plantManager.waterables.add(vegetable);

    for (Intermediate_05_Growable growable :  plantManager.growables) {
      growable.grow();
    }
    for (Intermediate_05_Waterable waterable :  plantManager.waterables) {
      waterable.water();
    }
  }
}
