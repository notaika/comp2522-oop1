package org.bcit.comp2522.winter2023.midterm_takeup.answers;

public class Intermediate_05_Flower extends Intermediate_05_Plant implements Intermediate_05_Growable, Intermediate_05_Waterable {
  public Intermediate_05_Flower() {
    this.name = "Flower";
  }

  @Override
  public void grow() {
    System.out.println("The flower is growing.");
  }

  @Override
  public void water() {
    System.out.println("The flower is being watered.");
  }
}
