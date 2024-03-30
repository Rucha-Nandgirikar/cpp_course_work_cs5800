package decorator_design_pattern.toppings_decorator;

import decorator_design_pattern.base_food_items.FoodItems;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BarbecueSauceTest {

    @Test
    public void testCost() {

        FoodItems mockFoodItems = mock(FoodItems.class);

        when(mockFoodItems.cost()).thenReturn(10.0f);

        BarbecueSauce barbecueSauce = new BarbecueSauce(mockFoodItems);

        float expectedCost = 10.0f + 5;

        float actualCost = barbecueSauce.cost();
        assertEquals(expectedCost, actualCost, 0.01f); // Tolerance of 0.01 for floating point calculations
    }

}