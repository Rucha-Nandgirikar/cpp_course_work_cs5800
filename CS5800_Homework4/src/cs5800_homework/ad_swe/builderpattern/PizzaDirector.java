package cs5800_homework.ad_swe.builderpattern;

class PizzaDirector {
    public Pizza constructSmallPizzaOfPizzaHut(PizzaBuilder builder) {
        return builder.setPizzaChainName("Pizza Hut")
                .setPizzaSize("small")
                .setPizzaToppingsList("Pepperoni","Onions","Extra Cheese")
                .build();
    }

    public Pizza constructMediumPizzaOfPizzaHut(PizzaBuilder builder) {
        return builder.setPizzaChainName("Pizza Hut")
                .setPizzaSize("medium")
                .setPizzaToppingsList("Tomato and Basil","Onions","Extra Cheese","Olives","Mushroom","Spinach")
                .build();
    }

    public Pizza constructLargePizzaOfPizzaHut(PizzaBuilder builder) {
        return builder.setPizzaChainName("Pizza Hut")
                .setPizzaSize("large")
                .setPizzaToppingsList("Pepperoni","Sausage","Extra Cheese","Mushrooms","Onions","Peppers","Chicken","Olives","Pesto")
                .build();
    }

    public Pizza constructPizzaHutLargePizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Pizza Hut")
                .setPizzaSize("large")
                .setPizzaToppingsList("Pepperoni","Sausage","Extra Cheese")
                .build();
    }

    public Pizza constructPizzaHutSmallPizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Pizza Hut")
                .setPizzaSize("small")
                .setPizzaToppingsList("Mushrooms","Onions")
                .build();
    }

    public Pizza constructLittleCaesarsMediumPizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Little Caesars")
                .setPizzaSize("large")
                .setPizzaToppingsList("Pepperoni","Sausage","Extra Cheese","Mushrooms","Onions","Peppers","Chicken","Olives")
                .build();
    }
    public Pizza constructLittleCaesarsSmallPizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Little Caesars")
                .setPizzaSize("large")
                .setPizzaToppingsList("Pepperoni","Sausage","Extra Cheese","Mushrooms","Onions","Peppers")
                .build();
    }

    public Pizza constructDominosSmallPizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Dominos")
                .setPizzaSize("small")
                .setPizzaToppingsList("Extra Cheese")
                .build();
    }
    public Pizza constructDominosLargePizza(PizzaBuilder builder) {
        return builder.setPizzaChainName("Dominos")
                .setPizzaSize("large")
                .setPizzaToppingsList("Peppers","Chicken","Olives")
                .build();
    }

}