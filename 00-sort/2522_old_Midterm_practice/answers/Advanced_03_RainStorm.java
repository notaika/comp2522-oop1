package org.bcit.comp2522.winter2023.midterm_takeup.answers;


import java.util.ArrayList;

public class Advanced_03_RainStorm implements Advanced_03_RainStormComponent{
  private ArrayList<Advanced_03_RainStormComponent> components = new ArrayList<>();


  public void add(Advanced_03_RainStorm component) {
    components.add((Advanced_03_RainStormComponent) component);
  }



  public void add(Advanced_03_RainStormComponent component) {
    components.add(component);
  }


  public void remove(Advanced_03_RainStormComponent component) {
    components.remove(component);
  }

  public double getTotalVolume() {
    double totalVolume = 0;
    for (Advanced_03_RainStormComponent component : components) {
      totalVolume += component.getVolume();
    }
    return totalVolume;
  }

  @Override
  public double getVolume() {
    return 0;
  }
}
