package cs5800_homework.ad_swe.abstract_factory_singleton;

public class Main {
    public static void main(String[] args) {
        // Create customers
        Customer customer1 = new Customer("Amy", DietPlan.NO_RESTRICTION);
        Customer customer2 = new Customer("Barbara", DietPlan.PALEO);
        Customer customer3 = new Customer("Claudia", DietPlan.VEGAN);
        Customer customer4 = new Customer("Daisy", DietPlan.NUT_ALLERGY);
        Customer customer5 = new Customer("Emma", DietPlan.VEGAN);
        Customer customer6 = new Customer("Fred", DietPlan.PALEO);

        // Generate meals for customers
        generateMealForCustomer(customer1);
        generateMealForCustomer(customer2);
        generateMealForCustomer(customer3);
        generateMealForCustomer(customer4);
        generateMealForCustomer(customer5);
        generateMealForCustomer(customer6);
    }

    // Method to generate and print meal for a customer
    private static void generateMealForCustomer(Customer customer) {
        Meal meal = customer.generateMealBasedOnDietPlan();
        System.out.println(customer.getName() + "'s Meal:"+ customer.getDietPlan());
        for (String component : meal.getComponents()) {
            System.out.println(component);
        }
        System.out.println();
    }
}
