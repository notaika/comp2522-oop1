package org.bcit.comp2522.winter2023.midterm_takeup.answers;

public class Advanced_04_ShrinkingRectangle {
  private double width;
  private double height;

  public Advanced_04_ShrinkingRectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  public void shrink() {
    if (width > 0) {
      width = Math.max(width * (2.0 / 3.0), 0);
    }
    if (height > 0) {
      height = Math.max(height * (2.0 / 3.0), 0);
    }
  }
}
