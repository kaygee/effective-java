package com;

public class NonInstantiation {

  public static final String CONSTANT = "Something!";

  private NonInstantiation() {}

  public static final String getSomething() {
    return CONSTANT;
  }
}
