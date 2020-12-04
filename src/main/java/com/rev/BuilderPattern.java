package com.rev;

public class BuilderPattern {

  private static final int DEFAULT = 0;

  private int first = DEFAULT;
  private int second = DEFAULT;
  private int third = DEFAULT;

  private BuilderPattern(Builder builder) {
    this.first = builder.first;
    this.second = builder.second;
    this.third = builder.third;
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

  public static class Builder {
    private int first;
    private int second;
    private int third;

    public Builder() {}

    public Builder first(int first) {
      this.first = first;
      return this;
    }

    public Builder second(int second) {
      this.second = second;
      return this;
    }

    public Builder third(int third) {
      this.third = third;
      return this;
    }

    public BuilderPattern build() {
      // We can do extra stuff in here! Like validate the values, etc...
      return new BuilderPattern(this);
    }
  }
}
