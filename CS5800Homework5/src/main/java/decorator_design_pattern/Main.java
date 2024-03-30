package decorator_design_pattern;

import decorator_design_pattern.base_food_items.Burger;
import decorator_design_pattern.base_food_items.FoodItems;
import decorator_design_pattern.base_food_items.Fries;
import decorator_design_pattern.base_food_items.HotDog;
import decorator_design_pattern.toppings_decorator.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List <FoodItems> foodItemsList1 = new ArrayList<>();
        FoodItems foodItem1 = new BarbecueSauce(new ExtraCheese(new Burger()));
        foodItemsList1.add(foodItem1);
        Order order1 = new Order();
        order1.setCustomerFoodItems(foodItemsList1);
        Customer customer1 = new Customer("Amy", 5,order1);

        List <FoodItems> foodItemsList5 = new ArrayList<>();
        FoodItems foodItem5 = new BarbecueSauce(new ExtraCheese(new Burger()));
        foodItemsList5.add(foodItem5);
        Order order5 = new Order();
        order5.setCustomerFoodItems(foodItemsList5);
        Customer customer5 = new Customer("Alexa", 4,order5);

        List <FoodItems> foodItemsList2 = new ArrayList<>();
        FoodItems foodItem2_1 =  new Jalapeños(new Aioli(new Guacamole(new HotDog())));
        FoodItems foodItem2_2 =  new BarbecueSauce(new ExtraCheese(new Guacamole(new Fries())));
        foodItemsList2.add(foodItem2_1);
        foodItemsList2.add(foodItem2_2);
        Order order2 = new Order();
        order2.setCustomerFoodItems(foodItemsList2);
        Customer customer2 = new Customer("Barbara", 3,order2);

        List <FoodItems> foodItemsList3 = new ArrayList<>();
        FoodItems foodItem3_1 = new BarbecueSauce(new ExtraCheese(new Burger()));
        FoodItems foodItem3_2 =  new Jalapeños(new Aioli(new Guacamole(new HotDog())));
        foodItemsList3.add(foodItem3_1);
        foodItemsList3.add(foodItem3_2);

        Order order3 = new Order();
        order3.setCustomerFoodItems(foodItemsList3);
        Customer customer3 = new Customer("Chirs", 2,order3);

        List <FoodItems> foodItemsList4 = new ArrayList<>();
        FoodItems foodItem4_1 = new Jalapeños(new ExtraCheese(new Burger()));
        FoodItems foodItem4_2 =  new Jalapeños(new Aioli(new Guacamole(new HotDog())));
        FoodItems foodItem4_3=  (new Guacamole(new Fries()));
        foodItemsList4.add(foodItem4_1);
        foodItemsList4.add(foodItem4_2);
        foodItemsList4.add(foodItem4_3);

        Order order4 = new Order();
        order4.setCustomerFoodItems(foodItemsList4);
        Customer customer4 = new Customer("Diana", 1,order4);


        displayTotalOrderCostWithDiscount(customer1);
        displayTotalOrderCostWithDiscount(customer2);
        displayTotalOrderCostWithDiscount(customer3);
        displayTotalOrderCostWithDiscount(customer4);
        displayTotalOrderCostWithDiscount(customer5);

    }

    public static void displayTotalOrderCostWithDiscount(Customer customer) {
        System.out.println("Customer "+customer.getCustomerName() + "'s Loyalty Status:"+ customer.getCustomerLoyaltyStatus());
        double cost = customer.getOrder().calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(customer.getOrder().getCustomerFoodItems(),customer.getCustomerLoyaltyStatus());
        System.out.println("Total cost of the order along with discount based on customer Loyalty status is $" +cost);
        System.out.println("-------------------------------------------------------------------");
    }


}
