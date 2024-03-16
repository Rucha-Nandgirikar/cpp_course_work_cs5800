package cs5800_homework.ad_swe.builderpattern;

import java.util.List;
public class Pizza {
    private String pizzaChainName;
    private String pizzaSize;
    private List<String> pizzaToppingsList;

    public Pizza(String pizzaChainName, String pizzaSize, List<String> pizzaToppingsList) {
        this.pizzaChainName = pizzaChainName;
        this.pizzaSize = pizzaSize;
        this.pizzaToppingsList = pizzaToppingsList;
    }

    public String getPizzaChainName() {
        return pizzaChainName;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public List<String> getPizzaToppingsList() {
        return pizzaToppingsList;
    }

    public void eat() {
        System.out.println(pizzaChainName + " - Enjoy your " + pizzaSize + " pizza with following topics:");
        for (String topping : pizzaToppingsList) {
            System.out.println("- " + topping);
        }
    }
}
