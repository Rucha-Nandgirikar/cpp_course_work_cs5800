package cs5800_homework.ad_swe.builderpattern;

public class Main {
    public static void main(String[] args) {
        PizzaHutPizzaBuilder smallPizzaHutBuilder = new PizzaHutPizzaBuilder();
        PizzaHutPizzaBuilder mediumPizzaHutBuilder = new PizzaHutPizzaBuilder();
        PizzaHutPizzaBuilder largePizzaHutBuilder = new PizzaHutPizzaBuilder();
//        pizza hut
        PizzaHutPizzaBuilder pizzaHutLargePizzaBuilder = new PizzaHutPizzaBuilder();
        PizzaHutPizzaBuilder pizzaHutSmallPizzaBuilder = new PizzaHutPizzaBuilder();
//        little caesars
        LittleCaesarsPizzaBuilder littleCaesarsMediumPizzaBuilder = new LittleCaesarsPizzaBuilder();
        LittleCaesarsPizzaBuilder littleCaesarsSmallPizzaBuilder = new LittleCaesarsPizzaBuilder();
//        dominos
        DominosPizzaBuilder dominosSmallPizzaBuilder = new DominosPizzaBuilder();
        DominosPizzaBuilder dominosLargePizzaBuilder = new DominosPizzaBuilder();

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


        smallPizza.eat();
        mediumPizza.eat();
        largePizza.eat();
        ph1.eat();
        ph2.eat();
        lc1.eat();
        lc2.eat();
        d1.eat();
        d2.eat();

    }
}