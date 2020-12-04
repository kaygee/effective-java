package com.rev;

import java.util.Objects;

public class Hawaiian extends Pizza {
  private final Size size;

  private Hawaiian(Builder builder) {
    super(builder);
    size = builder.size;
  }

  public Size getSize() {
    return size;
  }

  public enum Size {
    SMALL,
    MEDIUM,
    LARGE
  }

  public static class Builder extends Pizza.Builder<Builder> {
    private final Size size;

    public Builder(Size size) {
      this.size = Objects.requireNonNull(size);
    }

    @Override
    Hawaiian build() {
      return new Hawaiian(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }
}
