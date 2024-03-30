package decorator_design_pattern;

import decorator_design_pattern.base_food_items.FoodItems;

import java.util.List;

public class Order {

    List<FoodItems> customerFoodItems;

    public List<FoodItems> getCustomerFoodItems() {
        return customerFoodItems;
    }

    public void setCustomerFoodItems(List<FoodItems> customerFoodItems) {
        this.customerFoodItems = customerFoodItems;
    }

    public double getDiscount(int customerLoyaltyStatus)
    {
        switch(customerLoyaltyStatus) {
            case 5:
                return (0.15);

            case 4:
                return (0.10);

            case 3:
                return (0.075);

            case 2:
                return (0.050);

            case 1:
                return (0.030);
        }
        return 0;
    }

    public double calculateOrderCostWithDiscountBasedOnCustomerLoyaltyStatus(List<FoodItems> customerFoodItems,int customerLoyaltyStatus)
    {
        double totalCost = 0;
        double discountAmount = 0;
        for (FoodItems foodItems : customerFoodItems)
        {
            totalCost += foodItems.cost();
        }

        switch(customerLoyaltyStatus) {
            case 5:
                discountAmount = totalCost * (0.15);
                totalCost -= discountAmount;
                return totalCost;

            case 4:
                discountAmount = totalCost * (0.10);
                totalCost -= discountAmount;
                return totalCost;

            case 3:
                discountAmount = totalCost * (0.075);
                totalCost -= discountAmount;
                return totalCost;

            case 2:
                discountAmount = totalCost * (0.050);
                totalCost -= discountAmount;
                return totalCost;

            case 1:
                discountAmount = totalCost * (0.030);
                totalCost -= discountAmount;
                return totalCost;
        }

        return totalCost;
    }


}
