package org.bcit.comp2522.winter2023.midterm_takeup.answers;

public class Intermediate_05_Vegetable implements Intermediate_05_Growable, Intermediate_05_Waterable {
  @Override
  public void grow() {
    System.out.println("The vegetable is growing.");
  }

  @Override
  public void water() {
    System.out.println("The vegetable is being watered.");
  }
}
