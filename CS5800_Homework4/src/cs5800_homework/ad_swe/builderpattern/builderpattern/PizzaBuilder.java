package cs5800_homework.ad_swe.builderpattern;

public interface PizzaBuilder {

    PizzaBuilder setPizzaChainName(String pizzaChainName);
    PizzaBuilder setPizzaSize(String pizzaSize);
    PizzaBuilder setPizzaToppingsList(String... pizzaToppingsList);
    Pizza build();

}
