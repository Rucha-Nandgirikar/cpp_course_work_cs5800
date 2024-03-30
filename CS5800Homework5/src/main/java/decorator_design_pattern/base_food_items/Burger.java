package decorator_design_pattern.base_food_items;

public class Burger implements FoodItems {


    @Override
    public float cost() {
        return 20;
    }

    @Override
    public String foodItemName() {
        return "Burger (main course)";
    }


}
