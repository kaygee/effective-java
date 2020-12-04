package com.rev;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

  private final Set<Topping> toppings;

  Pizza(Builder<?> builder) {
    toppings = builder.toppings.clone();
  }

  public Set<Topping> getToppings() {
    return toppings;
  }

  @Override
  public String toString() {
    return "Pizza{" + "toppings=" + toppings + '}';
  }

  public enum Topping {
    HAM,
    PINEAPPLE,
    CHEESE,
    RED_SAUCE,
    PEPPERONI,
    SAUSAGE
  }

  abstract static class Builder<T extends Builder<T>> {
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

    public T addTopping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping));
      return self();
    }

    abstract Pizza build();

    protected abstract T self();
  }
}
