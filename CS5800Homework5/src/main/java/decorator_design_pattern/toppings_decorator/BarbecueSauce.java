package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.base_food_items.FoodItems;

public class BarbecueSauce extends ToppingsDecorator{

    FoodItems foodItems;

    public BarbecueSauce(FoodItems foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public float cost() {
        return foodItems.cost() + 5;
    }

    @Override
    public String foodItemName() {
        return foodItems.foodItemName()+ "\n  Barbecue Sauce (toppings)";
    }
}
