package decorator_design_pattern.base_food_items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriesTest {
    @Test
    public void testCost() {
        Fries fries = new Fries();

        float expectedCost = 8.0f;
        float actualCost = fries.cost();

        assertEquals(expectedCost, actualCost, 0.01f); // tolerance of 0.01 for floating point calculations
    }

}