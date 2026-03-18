package org.bcit.comp2522.winter2023.midterm_takeup.answers;

import java.util.ArrayList;

public class Basic_08_Control_Ans {
  private String name;
  private boolean enabled;
  private ArrayList<Basic_08_Control_Ans> children;

  public Basic_08_Control_Ans(String name) {
    this.name = name;
    this.enabled = true;
    this.children = new ArrayList<>();
  }

  public void toggle() {
    enabled = !enabled;
  }

  public void setPosition(int position) {
    // Position setting logic goes here.
    // It depends on the specific requirements for position handling.
  }

  public void addChild(Basic_08_Control_Ans child) {
    children.add(child);
  }

  public void removeChild(Basic_08_Control_Ans child) {
    children.remove(child);
  }

  // Getters and setters for name and enabled properties can be added if needed.
}
