package cs5800_homework.ad_swe.abstract_factory_singleton;

import cs5800_homework.ad_swe.abstract_factory_singleton.macronutrient.Carbs;
import cs5800_homework.ad_swe.abstract_factory_singleton.macronutrient.Macronutrient;

public class CarbsFactory extends MacronutrientFactory{
    @Override
    Macronutrient createMacronutrient() {
        return new Carbs();
    }
}
