package decorator_design_pattern.base_food_items;

public class HotDog implements FoodItems{

    @Override
    public float cost() {
        return 15;
    }

    @Override
    public String foodItemName() {
        return "HotDog";
    }

}
