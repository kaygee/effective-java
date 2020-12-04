package com.rev;

public class JavaBeanPattern {

  private static final int DEFAULT = 0;

  private int first = DEFAULT;
  private int second = DEFAULT;
  private int third = DEFAULT;

  public JavaBeanPattern() {}

  public int getFirst() {
    return first;
  }

  public void setFirst(int first) {
    this.first = first;
  }

  public int getSecond() {
    return second;
  }

  public void setSecond(int second) {
    this.second = second;
  }

  public int getThird() {
    return third;
  }

  public void setThird(int third) {
    this.third = third;
  }
}
