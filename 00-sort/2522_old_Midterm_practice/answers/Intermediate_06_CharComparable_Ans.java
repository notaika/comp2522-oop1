package org.bcit.comp2522.winter2023.midterm_takeup.answers;


public class Intermediate_06_CharComparable_Ans implements Comparable<Intermediate_06_CharComparable_Ans> {
  private char c;

  public Intermediate_06_CharComparable_Ans(char c) {
    this.c = c;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
    Intermediate_06_CharComparable_Ans other = (Intermediate_06_CharComparable_Ans) obj;
    return this.c == other.c;
  }

  @Override
  public int compareTo(Intermediate_06_CharComparable_Ans other) {
    return Character.compare(this.c, other.c);
  }

  public static void main(String[] args) {
    Intermediate_06_CharComparable_Ans a = new Intermediate_06_CharComparable_Ans('a');
    Intermediate_06_CharComparable_Ans b = new Intermediate_06_CharComparable_Ans('b');
    Intermediate_06_CharComparable_Ans anotherA = new Intermediate_06_CharComparable_Ans('a');

    System.out.println("a equals anotherA: " + a.equals(anotherA)); // true
    System.out.println("a equals b: " + a.equals(b)); // false
    System.out.println("a compareTo anotherA: " + a.compareTo(anotherA)); // 0
    System.out.println("a compareTo b: " + a.compareTo(b)); // negative
    System.out.println("b compareTo a: " + b.compareTo(a)); // positive
  }

}

