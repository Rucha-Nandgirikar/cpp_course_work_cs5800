package decorator_design_pattern.base_food_items;

import decorator_design_pattern.toppings_decorator.ToppingsDecorator;

public class Burger extends ToppingsDecorator {


    @Override
    public float cost() {
        return 20;
    }
}
