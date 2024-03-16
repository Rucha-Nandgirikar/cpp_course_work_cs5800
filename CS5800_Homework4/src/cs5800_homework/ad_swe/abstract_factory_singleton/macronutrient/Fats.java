package cs5800_homework.ad_swe.abstract_factory_singleton.macronutrient;

import cs5800_homework.ad_swe.abstract_factory_singleton.DietPlan;

import java.util.Random;

public class Fats implements Macronutrient{

    private final String[] all_fatsOptions = {"Avocado", "Sour cream", "Tuna", "Peanuts"};
    private final String[] paleo_fatsOptions = {"Avocado", "Tuna", "Peanuts"};
    private final String[] vegan_fatsOptions = {"Avocado", "Peanuts"};
    private final String[] nuts_allergy_fatsOptions = {"Avocado", "Sour cream", "Tuna"};

    private final String[] Options = {""};

    @Override
    public String getComponent(DietPlan dietType) {
        Random rand = new Random();
        switch (dietType)
        {
            case PALEO -> {
                return paleo_fatsOptions[rand.nextInt(paleo_fatsOptions.length)];
            }
            case VEGAN -> {
                return vegan_fatsOptions[rand.nextInt(vegan_fatsOptions.length)];
            }
            case NUT_ALLERGY -> {
                return nuts_allergy_fatsOptions[rand.nextInt(vegan_fatsOptions.length)];
            }
            default -> {
                return all_fatsOptions[rand.nextInt(all_fatsOptions.length)];
            }
        }



    }
}
