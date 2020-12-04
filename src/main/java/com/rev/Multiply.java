package com.rev;

public class Multiply {

  private int product;

  // Public Constructor
  public Multiply(int multiplicand, int multiplier) {
    this.product = multiplicand * multiplier;
  }

  /**
   * Static Factory Method. <br>
   * Static means that only one instance is created which is shared across all instances of the
   * class.
   */
  public static Multiply numbers(int multiplicand, int multiplier) {
    return new Multiply(multiplicand, multiplier);
  }

  public int getProduct() {
    return product;
  }
}
