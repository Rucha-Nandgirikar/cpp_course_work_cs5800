package decorator_design_pattern;

import decorator_design_pattern.base_food_items.Burger;
import decorator_design_pattern.base_food_items.FoodItems;
import decorator_design_pattern.base_food_items.Fries;
import decorator_design_pattern.base_food_items.HotDog;
import decorator_design_pattern.toppings_decorator.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void testSetAndGetCustomerFoodItems() {
        Order orderCalculator = new Order();
        List <FoodItems> foodItemsList1 = new ArrayList<>();
        FoodItems foodItem2_1 =  new Jalapeños(new Aioli(new Guacamole(new HotDog())));
        FoodItems foodItem2_2 =  new BarbecueSauce(new ExtraCheese(new Guacamole(new Fries())));
        foodItemsList1.add(foodItem2_1);
        foodItemsList1.add(foodItem2_2);

        orderCalculator.setCustomerFoodItems(foodItemsList1);

        List<FoodItems> actualItems = orderCalculator.getCustomerFoodItems();

        assertSame(foodItemsList1, actualItems);
    }

    @Test
    public void testSetCustomerFoodItemsWithNull() {
        Order orderCalculator = new Order();

        orderCalculator.setCustomerFoodItems(null);

        assertNull(orderCalculator.getCustomerFoodItems());
    }

    @Test
    public void testCalculateOrderCostWithDiscountAndLoyaltyStatus5() {
        Order orderCalculator = new Order();
        List<FoodItems> items = new ArrayList<>();
        items.add(new BarbecueSauce(new ExtraCheese(new Burger())));

        // Test with loyalty status 5 (15% discount)
        double expectedCost = (30.0) * (1 - 0.15);
        double actualCost = orderCalculator.calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(items, 5);
        assertEquals(expectedCost, actualCost, 0.01);
    }

    @Test
    public void testCalculateOrderCostWithDiscountAndLoyaltyStatus4() {
        Order orderCalculator = new Order();


        List <FoodItems> foodItemsList5 = new ArrayList<>();
        FoodItems foodItem5 = new BarbecueSauce(new ExtraCheese(new Burger()));
        foodItemsList5.add(foodItem5);

        double expectedCost = (30.0) * (1 - 0.10);
        double actualCost = orderCalculator.calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(foodItemsList5, 4);
        assertEquals(expectedCost, actualCost, 0.01);
    }

    @Test
    public void testCalculateOrderCostWithDiscountAndLoyaltyStatus3() {

        Order orderCalculator = new Order();
        List <FoodItems> foodItemsList2 = new ArrayList<>();
        FoodItems foodItem2_1 =  new Jalapeños(new Aioli(new Guacamole(new HotDog())));
        FoodItems foodItem2_2 =  new BarbecueSauce(new ExtraCheese(new Guacamole(new Fries())));
        foodItemsList2.add(foodItem2_1);
        foodItemsList2.add(foodItem2_2);

        // Test with loyalty status 5 (15% discount)
        double expectedCost = (57.0) * (1 - 0.075);
        double actualCost = orderCalculator.calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(foodItemsList2, 3);
        assertEquals(expectedCost, actualCost, 0.1);
        // Similarly, you can add tests for other loyalty statuses
    }

    @Test
    public void testCalculateOrderCostWithDiscountAndLoyaltyStatus2() {

        Order orderCalculator = new Order();
        List <FoodItems> foodItemsList3 = new ArrayList<>();
        FoodItems foodItem3_1 = new BarbecueSauce(new ExtraCheese(new Burger()));
        FoodItems foodItem3_2 =  new Jalapeños(new Aioli(new Guacamole(new HotDog())));
        foodItemsList3.add(foodItem3_1);
        foodItemsList3.add(foodItem3_2);

        // Test with loyalty status 5 (15% discount)
        double expectedCost = (62.0) * (1 - 0.050);
        double actualCost = orderCalculator.calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(foodItemsList3, 2);
        assertEquals(expectedCost, actualCost, 0.01);
        // Similarly, you can add tests for other loyalty statuses
    }

    @Test
    public void testCalculateOrderCostWithDiscountAndLoyaltyStatus1() {

        Order orderCalculator = new Order();
        List <FoodItems> foodItemsList4 = new ArrayList<>();
        FoodItems foodItem4_1 = new Jalapeños(new ExtraCheese(new Burger()));
        FoodItems foodItem4_2 =  new Jalapeños(new Aioli(new Guacamole(new HotDog())));
        FoodItems foodItem4_3=  (new Guacamole(new Fries()));
        foodItemsList4.add(foodItem4_1);
        foodItemsList4.add(foodItem4_2);
        foodItemsList4.add(foodItem4_3);

        // Test with loyalty status 5 (15% discount)
        double expectedCost = (77.0) * (1 - 0.030);
        double actualCost = orderCalculator.calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(foodItemsList4, 1);
        assertEquals(expectedCost, actualCost, 0.01);
        // Similarly, you can add tests for other loyalty statuses
    }


    @Test
    public void testGetDiscountForFiveStars() {
        Order order = new Order();
        double expectedDiscount = 0.15;
        double actualDiscount = order.getDiscount(5);
        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    public void testGetDiscountForFourStars() {
        Order order = new Order();
        double expectedDiscount = 0.10;
        double actualDiscount = order.getDiscount(4);
        assertEquals(expectedDiscount, actualDiscount);
    }

    // Add similar tests for other loyalty statuses (Three, Two, and One star)

    @Test
    public void testGetDiscountForThreeStars() {
        Order order = new Order();
        double expectedDiscount = 0.075;
        double actualDiscount = order.getDiscount(3);
        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    public void testGetDiscountForTwoStars() {
        Order order = new Order();
        double expectedDiscount = 0.05;
        double actualDiscount = order.getDiscount(2);
        assertEquals(expectedDiscount, actualDiscount);
    }

    @Test
    public void testGetDiscountForOneStar() {
        Order order = new Order();
        double expectedDiscount = 0.030;
        double actualDiscount = order.getDiscount(1);
        assertEquals(expectedDiscount, actualDiscount);
    }
}