package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.base_food_items.FoodItems;

public class ExtraCheese extends ToppingsDecorator{

    FoodItems foodItems;

    public ExtraCheese(FoodItems foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public float cost() {
        return foodItems.cost() + 5;
    }
}
