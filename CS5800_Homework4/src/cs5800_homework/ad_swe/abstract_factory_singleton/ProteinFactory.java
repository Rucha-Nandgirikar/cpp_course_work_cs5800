package cs5800_homework.ad_swe.abstract_factory_singleton;

import cs5800_homework.ad_swe.abstract_factory_singleton.macronutrient.Macronutrient;
import cs5800_homework.ad_swe.abstract_factory_singleton.macronutrient.Protein;

public class ProteinFactory extends MacronutrientFactory {
    @Override
    Macronutrient createMacronutrient() {
        return new Protein();
    }
}
