package com.rev;

public class TelescopingConstructor {

  private static final int DEFAULT = 0;

  private final int first;
  private final int second;
  private final int third;

  public TelescopingConstructor(int first) {
    this(first, DEFAULT, DEFAULT);
  }

  public TelescopingConstructor(int first, int second) {
    this(first, second, DEFAULT);
  }

  public TelescopingConstructor(int first, int second, int third) {
    this.first = first;
    this.second = second;
    this.third = third;
  }

  public int getFirst() {
    return first;
  }

  public int getSecond() {
    return second;
  }

  public int getThird() {
    return third;
  }
}
