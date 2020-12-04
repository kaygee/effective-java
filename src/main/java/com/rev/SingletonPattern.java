package com.rev;

public class SingletonPattern {

  public static final String PRIVATE_CONSTRUCTOR = "PRIVATE_CONSTRUCTOR";
  public static final String STATIC_FACTORY = "STATIC_FACTORY";

  public static final SingletonPattern INSTANCE = new SingletonPattern(PRIVATE_CONSTRUCTOR);

  private static final SingletonPattern ANOTHER_INSTANCE = new SingletonPattern(STATIC_FACTORY);

  private String value;

  private SingletonPattern(String value) {
    // You can't construct me!
    this.value = value;
  }

  public static SingletonPattern getInstance() {
    return ANOTHER_INSTANCE;
  }

  public String getValue() {
    return value;
  }
}
