package decorator_design_pattern.base_food_items;

public class Fries implements FoodItems{

    @Override
    public float cost() {
        return 8;
    }

    @Override
    public String foodItemName() {
        return "Fries";
    }

}
