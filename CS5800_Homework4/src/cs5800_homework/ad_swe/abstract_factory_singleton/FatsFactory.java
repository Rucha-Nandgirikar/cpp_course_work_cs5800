package cs5800_homework.ad_swe.abstract_factory_singleton;

import cs5800_homework.ad_swe.abstract_factory_singleton.macronutrient.Fats;
import cs5800_homework.ad_swe.abstract_factory_singleton.macronutrient.Macronutrient;

public class FatsFactory extends MacronutrientFactory {
    @Override
    Macronutrient createMacronutrient() {
        return new Fats();
    }
}
