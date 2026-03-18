package org.bcit.comp2522.winter2023.midterm_takeup.answers;

import org.bcit.comp2522.winter2023.midterm_takeup.questions.Basic_03_Forest;

public class Basic_03_Tree extends Basic_03_Forest {

  int height;
  int numberOfLeaves;

  public Basic_03_Tree(int height, int numberOfLeaves) {
    this.height = height;
    this.numberOfLeaves = numberOfLeaves;
  }

  public void grow(int additionalHeight) {
    this.height += additionalHeight;
  }

  public void shedLeaves(int leavesLost) {
    this.numberOfLeaves -= leavesLost;
    if (this.numberOfLeaves < 0) {
      this.numberOfLeaves = 0;
    }
  }
}

