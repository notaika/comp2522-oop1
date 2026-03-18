package org.bcit.comp2522.winter2023.midterm_takeup.answers;

public class Advanced_05_CubeIterable {
  public static void main(String[] args) {
    Advanced_05_Cube cube = new Advanced_05_Cube();
    for (Advanced_05_CubeItem item : cube) {
      System.out.println(item.getValue());
    }
  }
}
