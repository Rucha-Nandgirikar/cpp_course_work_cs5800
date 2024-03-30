package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.base_food_items.FoodItems;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GuacamoleTest {
    @Test
    public void testCost() {

        FoodItems mockFoodItems = mock(FoodItems.class);

        when(mockFoodItems.cost()).thenReturn(10.0f);

        Guacamole guacamole = new Guacamole(mockFoodItems);

        float expectedCost = 10.0f + 7;

        float actualCost = guacamole.cost();
        assertEquals(expectedCost, actualCost, 0.01f); // Tolerance of 0.01 for floating point calculations
    }

}