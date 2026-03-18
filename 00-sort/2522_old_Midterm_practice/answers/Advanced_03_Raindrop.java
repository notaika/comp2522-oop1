package org.bcit.comp2522.winter2023.midterm_takeup.answers;

/**
 * Represents a single raindrop with a specific volume.
 */
public class Advanced_03_Raindrop implements Advanced_03_RainStormComponent{
  private double volume;


  public Advanced_03_Raindrop(double volume) {
    this.volume = volume;
  }


  public double getVolume() {
    return volume;
  }
}
