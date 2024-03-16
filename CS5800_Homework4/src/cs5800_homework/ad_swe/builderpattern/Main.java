package cs5800_homework.ad_swe.builderpattern;

public class Main {
    public static void main(String[] args) {
        ConcretePizzaBuilder smallPizzaHutBuilder = new ConcretePizzaBuilder();
        ConcretePizzaBuilder mediumPizzaHutBuilder = new ConcretePizzaBuilder();
        ConcretePizzaBuilder largePizzaHutBuilder = new ConcretePizzaBuilder();
//        pizza hut
        ConcretePizzaBuilder pizzaHutLargePizzaBuilder = new ConcretePizzaBuilder();
        ConcretePizzaBuilder pizzaHutSmallPizzaBuilder = new ConcretePizzaBuilder();
//        little caesars
        ConcretePizzaBuilder littleCaesarsMediumPizzaBuilder = new ConcretePizzaBuilder();
        ConcretePizzaBuilder littleCaesarsSmallPizzaBuilder = new ConcretePizzaBuilder();
//        dominos
        ConcretePizzaBuilder dominosSmallPizzaBuilder = new ConcretePizzaBuilder();
        ConcretePizzaBuilder dominosLargePizzaBuilder = new ConcretePizzaBuilder();

        PizzaDirector director = new PizzaDirector();

        Pizza smallPizza = director.constructSmallPizzaOfPizzaHut(smallPizzaHutBuilder);
        Pizza mediumPizza = director.constructMediumPizzaOfPizzaHut(mediumPizzaHutBuilder);
        Pizza largePizza = director.constructLargePizzaOfPizzaHut(largePizzaHutBuilder);

        Pizza ph1 = director.constructPizzaHutLargePizza(pizzaHutLargePizzaBuilder);
        Pizza ph2 = director.constructPizzaHutSmallPizza(pizzaHutSmallPizzaBuilder);

        Pizza lc1 = director.constructLittleCaesarsMediumPizza(littleCaesarsMediumPizzaBuilder);
        Pizza lc2 = director.constructLittleCaesarsSmallPizza(littleCaesarsSmallPizzaBuilder);

        Pizza d1 = director.constructDominosSmallPizza(dominosSmallPizzaBuilder);
        Pizza d2 = director.constructDominosLargePizza(dominosLargePizzaBuilder);



        // Use the constructed pizzas
        eat("Pizza Hut small size pizza", smallPizza);
        eat("Pizza Hut medium size pizza", mediumPizza);
        eat("Pizza Hut large size pizza", largePizza);

        eat("Pizza Hut large size pizza", ph1);
        eat("Pizza Hut small size pizza", ph2);

        eat("Little Caesars medium size pizza", lc1);
        eat("Little Caesars small size pizza", lc2);

        eat("Dominos small size pizza", d1);
        eat("Dominos large size pizza", d2);
    }

    private static void eat(String pizzaType, Pizza pizza) {
        System.out.println(pizzaType + " Specifications:\n"
                + "Pizza Chain Name: " + pizza.getPizzaChainName()
                + "\nPizza Size: " + pizza.getPizzaSize()
                + "\nPizza Toppings List: " + pizza.getPizzaToppingsList() + "\n");
    }
}