package org.bcit.comp2522.winter2023.midterm_takeup.answers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Advanced_04_ShrinkingRectangleTest {
  private Advanced_04_ShrinkingRectangle rectangle;

  @BeforeEach
  public void setUp() {
    rectangle = new Advanced_04_ShrinkingRectangle(9, 12);
  }

  @Test
  public void testWidthAndHeightAreInitializedCorrectly() {
    assertEquals(9, rectangle.getWidth());
    assertEquals(12, rectangle.getHeight());
  }

  @Test
  public void testShrinkReducesWidthAndHeightByAThird() {
    rectangle.shrink();
    assertEquals(6, rectangle.getWidth());
    assertEquals(8, rectangle.getHeight());
  }

  @Test
  public void testShrinkDoesNotReduceWidthAndHeightToNegativeValues() {
    rectangle = new Advanced_04_ShrinkingRectangle(1, 1);
    rectangle.shrink();
    rectangle.shrink();
    assertEquals(0, rectangle.getWidth());
    assertEquals(0, rectangle.getHeight());
  }

  @Test
  public void testShrinkStopsWhenEitherWidthOrHeightReachesZero() {
    rectangle = new Advanced_04_ShrinkingRectangle(1, 1);
    rectangle.shrink();
    rectangle.shrink();
    rectangle.shrink();
    assertEquals(0, rectangle.getWidth());
    assertEquals(0, rectangle.getHeight());
  }
}
