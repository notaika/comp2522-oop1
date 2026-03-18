package org.bcit.comp2522.winter2023.midterm_takeup.answers;

import java.util.Iterator;

public class Advanced_05_Cube implements Iterable<Advanced_05_CubeItem> {
  private Advanced_05_CubeItem[][][] cube;

  public Advanced_05_Cube() {
    createCube(3, 3, 3);
  }

  private void createCube(int x, int y, int z) {
    cube = new Advanced_05_CubeItem[x][y][z];
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        for (int k = 0; k < z; k++) {
          cube[i][j][k] = new Advanced_05_CubeItem("Item-" + i + "-" + j + "-" + k);
        }
      }
    }
  }

  @Override
  public Iterator<Advanced_05_CubeItem> iterator() {
    return new CubeIterator();
  }

  private class CubeIterator implements Iterator<Advanced_05_CubeItem> {
    private int currentX = 0;
    private int currentY = 0;
    private int currentZ = 0;

    @Override
    public boolean hasNext() {
      return currentX < cube.length && currentY < cube[0].length && currentZ < cube[0][0].length;
    }

    @Override
    public Advanced_05_CubeItem next() {
      Advanced_05_CubeItem currentItem = cube[currentX][currentY][currentZ];
      currentZ++;
      if (currentZ >= cube[0][0].length) {
        currentZ = 0;
        currentY++;
        if (currentY >= cube[0].length) {
          currentY = 0;
          currentX++;
        }
      }
      return currentItem;
    }
  }
}
