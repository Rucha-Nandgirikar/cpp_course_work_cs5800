package decorator_design_pattern.base_food_items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {

    @Test
    public void testCost() {
        Burger burger = new Burger();

        float expectedCost = 20.0f;
        float actualCost = burger.cost();

        assertEquals(expectedCost, actualCost, 0.01f); // tolerance of 0.01 for floating point calculations
    }

}