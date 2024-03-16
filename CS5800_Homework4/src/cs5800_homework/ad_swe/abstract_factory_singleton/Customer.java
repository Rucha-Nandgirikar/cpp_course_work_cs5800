package cs5800_homework.ad_swe.abstract_factory_singleton;

import java.util.ArrayList;
import java.util.List;
public class Customer {

    private final String customerName;
    private final DietPlan dietPlan;
    private final MacronutrientFactorySingleton macronutrientFactory;

    public Customer(String name, DietPlan dietPlan) {
        this.customerName = name;
        this.dietPlan = dietPlan;
        this.macronutrientFactory = MacronutrientFactorySingleton.getInstance();
    }

    public String getName() {
        return customerName;
    }

    public DietPlan getDietPlan() {
        return dietPlan;
    }

    // Method to generate a meal based on diet plan
    public Meal generateMealBasedOnDietPlan() {
        List<String> mealComponents = new ArrayList<>();

        switch (dietPlan) {
            case NO_RESTRICTION:
                mealComponents.add(macronutrientFactory.getCarbsFactory().createMacronutrient().getComponent(DietPlan.NO_RESTRICTION));
                mealComponents.add(macronutrientFactory.getProteinFactory().createMacronutrient().getComponent(DietPlan.NO_RESTRICTION));
                mealComponents.add(macronutrientFactory.getFatsFactory().createMacronutrient().getComponent(DietPlan.NO_RESTRICTION));
                break;
            case PALEO:
                mealComponents.add("Pistachio");
                mealComponents.add(macronutrientFactory.getProteinFactory().createMacronutrient().getComponent(DietPlan.PALEO));
                mealComponents.add(macronutrientFactory.getFatsFactory().createMacronutrient().getComponent(DietPlan.PALEO));
                break;
            case VEGAN:
                mealComponents.add(macronutrientFactory.getCarbsFactory().createMacronutrient().getComponent(DietPlan.VEGAN));
                mealComponents.add("Tofu");
                mealComponents.add(macronutrientFactory.getFatsFactory().createMacronutrient().getComponent(DietPlan.VEGAN));
                break;
            case NUT_ALLERGY:
                mealComponents.add(macronutrientFactory.getCarbsFactory().createMacronutrient().getComponent(DietPlan.NUT_ALLERGY));
                mealComponents.add(macronutrientFactory.getProteinFactory().createMacronutrient().getComponent(DietPlan.NUT_ALLERGY));
                mealComponents.add(macronutrientFactory.getFatsFactory().createMacronutrient().getComponent(DietPlan.NUT_ALLERGY));
                break;
        }

        return new Meal(mealComponents);
    }


}
