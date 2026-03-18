package org.bcit.comp2522.winter2023.midterm_takeup.answers;

public class Advanced_03_CompositeStorm_Ans {
  public static void main(String[] args) {
    Advanced_03_Raindrop raindrop1 = new Advanced_03_Raindrop(1.0);
    Advanced_03_Raindrop raindrop2 = new Advanced_03_Raindrop(2.0);
    Advanced_03_Raindrop raindrop3 = new Advanced_03_Raindrop(3.0);

    Advanced_03_RainStorm storm1 = new Advanced_03_RainStorm();
    storm1.add(raindrop1);
    storm1.add(raindrop2);

    Advanced_03_RainStorm storm2 = new Advanced_03_RainStorm();
    storm2.add(raindrop3);
    storm2.add(storm1);

    System.out.println("Total volume of storm2: " + storm2.getTotalVolume());
  }
}


