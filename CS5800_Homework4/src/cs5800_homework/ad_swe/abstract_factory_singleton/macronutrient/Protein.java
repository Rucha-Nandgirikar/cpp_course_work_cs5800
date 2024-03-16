package cs5800_homework.ad_swe.abstract_factory_singleton.macronutrient;

import cs5800_homework.ad_swe.abstract_factory_singleton.DietPlan;

import java.util.Random;

public class Protein implements Macronutrient{
    private final String[] proteinOptions = {"Fish", "Chicken", "Beef", "Tofu"};
    private final String[] paleo_proteinOptions = {"Fish", "Chicken", "Beef"};

    @Override
    public String getComponent(DietPlan dietType) {
            Random rand = new Random();

        switch (dietType)
        {
            case PALEO -> {
                return paleo_proteinOptions[rand.nextInt(paleo_proteinOptions.length)];
            }

            default -> {
                return proteinOptions[rand.nextInt(proteinOptions.length)];
            }
        }

    }
}
