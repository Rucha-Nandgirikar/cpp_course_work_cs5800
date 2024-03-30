package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.base_food_items.FoodItems;

public class Guacamole extends ToppingsDecorator{

    FoodItems foodItems;

    public Guacamole(FoodItems foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public float cost() {
        return foodItems.cost() + 7;
    }

    @Override
    public String foodItemName() {
        return foodItems.foodItemName()+ "\n  Guacamole (toppings)";
    }
}
