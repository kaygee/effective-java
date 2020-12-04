package com.rev;

import com.NonInstantiation;
import org.junit.Test;

import static com.rev.Hawaiian.Size.SMALL;
import static org.assertj.core.api.Assertions.assertThat;

public class ChapterTwo {

  private static final int DEFAULT = 0;

  /** Item 1: Consider static factory methods instead of constructors. */
  @Test
  public void canGetStringUsingConstructor() {
    // Constructors don't have meaningful names.
    String value = new String("constructor!");

    assertThat(value.toString()).isEqualTo(value);
  }

  /** Item 1: Consider static factory methods instead of constructors. */
  @Test
  public void canGetStringUsingStaticFactory() {
    // Static factories have names (valueOf).
    String stringValue = String.valueOf("static factory!");
    assertThat(stringValue.toString()).isEqualTo(stringValue);

    String doubleValue = String.valueOf(1.0);
    assertThat(doubleValue.toString()).isEqualTo(doubleValue);
  }

  @Test
  public void canGetObjectUsingConstructor() {
    Multiply multiply = new Multiply(3, 2);
    assertThat(multiply.getProduct()).isEqualTo(3 * 2);
  }

  @Test
  public void canGetObjectUsingStaticFactory() {
    Multiply multiply = Multiply.numbers(3, 2);
    assertThat(multiply.getProduct()).isEqualTo(3 * 2);
  }

  /** Page 10. */
  @Test
  public void telescopingConstructorExample() {
    int first = 1;
    int second = 2;
    int third = 3;

    TelescopingConstructor firstTelescopingConstructor = new TelescopingConstructor(first);
    assertThat(firstTelescopingConstructor.getFirst()).isEqualTo(first);
    assertThat(firstTelescopingConstructor.getSecond()).isEqualTo(DEFAULT);
    assertThat(firstTelescopingConstructor.getThird()).isEqualTo(DEFAULT);

    TelescopingConstructor secondTelescopingConstructor = new TelescopingConstructor(first, second);
    assertThat(secondTelescopingConstructor.getFirst()).isEqualTo(first);
    assertThat(secondTelescopingConstructor.getSecond()).isEqualTo(second);
    assertThat(secondTelescopingConstructor.getThird()).isEqualTo(DEFAULT);

    TelescopingConstructor thirdTelescopingConstructor =
        new TelescopingConstructor(first, second, third);
    assertThat(thirdTelescopingConstructor.getFirst()).isEqualTo(first);
    assertThat(thirdTelescopingConstructor.getSecond()).isEqualTo(second);
    assertThat(thirdTelescopingConstructor.getThird()).isEqualTo(third);
  }

  /** Page 11. */
  @Test
  public void javaBeanPatternExample() {
    int first = 1;
    int second = 2;
    int third = 3;

    JavaBeanPattern firstJavaBeanPattern = new JavaBeanPattern();
    firstJavaBeanPattern.setFirst(first);
    assertThat(firstJavaBeanPattern.getFirst()).isEqualTo(first);
    assertThat(firstJavaBeanPattern.getSecond()).isEqualTo(DEFAULT);
    assertThat(firstJavaBeanPattern.getThird()).isEqualTo(DEFAULT);

    JavaBeanPattern secondJavaBeanPattern = new JavaBeanPattern();
    secondJavaBeanPattern.setFirst(first);
    secondJavaBeanPattern.setSecond(second);
    assertThat(secondJavaBeanPattern.getFirst()).isEqualTo(first);
    assertThat(secondJavaBeanPattern.getSecond()).isEqualTo(second);
    assertThat(secondJavaBeanPattern.getThird()).isEqualTo(DEFAULT);

    JavaBeanPattern thirdJavaBeanPattern = new JavaBeanPattern();
    thirdJavaBeanPattern.setFirst(first);
    thirdJavaBeanPattern.setSecond(second);
    thirdJavaBeanPattern.setThird(third);
    assertThat(thirdJavaBeanPattern.getFirst()).isEqualTo(first);
    assertThat(thirdJavaBeanPattern.getSecond()).isEqualTo(second);
    assertThat(thirdJavaBeanPattern.getThird()).isEqualTo(third);
  }

  /** Item 2. Page 13. Consider a builder when faced with many constructor parameters. */
  @Test
  public void builderPatternExample() {
    int first = 1;
    int second = 2;
    int third = 3;

    BuilderPattern.Builder firstBuilder = new BuilderPattern.Builder();
    BuilderPattern firstBuilderPattern = firstBuilder.first(first).build();
    assertThat(firstBuilderPattern.getFirst()).isEqualTo(first);
    assertThat(firstBuilderPattern.getSecond()).isEqualTo(DEFAULT);
    assertThat(firstBuilderPattern.getThird()).isEqualTo(DEFAULT);

    BuilderPattern.Builder secondBuilder = new BuilderPattern.Builder();
    BuilderPattern secondBuilderPattern = secondBuilder.first(first).second(second).build();
    assertThat(secondBuilderPattern.getFirst()).isEqualTo(first);
    assertThat(secondBuilderPattern.getSecond()).isEqualTo(second);
    assertThat(secondBuilderPattern.getThird()).isEqualTo(DEFAULT);

    BuilderPattern.Builder thirdBuilder = new BuilderPattern.Builder();
    BuilderPattern thirdBuilderPattern =
        thirdBuilder.first(first).second(second).third(third).build();
    assertThat(thirdBuilderPattern.getFirst()).isEqualTo(first);
    assertThat(thirdBuilderPattern.getSecond()).isEqualTo(second);
    assertThat(thirdBuilderPattern.getThird()).isEqualTo(third);
  }

  /** Item 2. Page 14. Consider a builder when faced with many constructor parameters. */
  @Test
  public void classHierarchyBuilderPatternExample() {
    Hawaiian smallHawaiianPizza =
        new Hawaiian.Builder(SMALL)
            .addTopping(Pizza.Topping.HAM)
            .addTopping(Pizza.Topping.CHEESE)
            .addTopping(Pizza.Topping.RED_SAUCE)
            .addTopping(Pizza.Topping.PINEAPPLE)
            .build();
    assertThat(smallHawaiianPizza.getToppings())
        .containsOnly(
            Pizza.Topping.HAM,
            Pizza.Topping.CHEESE,
            Pizza.Topping.PINEAPPLE,
            Pizza.Topping.RED_SAUCE);
    assertThat(smallHawaiianPizza.getSize()).isEqualTo(SMALL);
  }

  /** Item 3. Page 17. Enforce the singleton property with a private constructor or an enum type. */
  @Test
  public void privateConstructorSingletonExample() {
    assertThat(SingletonPattern.INSTANCE.getValue())
        .isEqualTo(SingletonPattern.PRIVATE_CONSTRUCTOR);
  }

  /** Item 3. Page 17. Enforce the singleton property with a private constructor or an enum type. */
  @Test
  public void staticFactorySingletonExample() {
    assertThat(SingletonPattern.getInstance().getValue())
        .isEqualTo(SingletonPattern.STATIC_FACTORY);
  }

  /** Item 4: Page 19. Enforce non-instantiability with a private constructor . */
  @Test
  public void noninstantiationExample() {
    assertThat(NonInstantiation.getSomething()).isEqualTo(NonInstantiation.CONSTANT);
  }

  /** Item 6: Page 22. Avoid creating unnecessary objects. */
  @Test
  public void avoidCreatingUnnecessaryObjects() {
    String ungood = new String("not necessary");

    String better = "better";
  }
}
