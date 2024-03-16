package cs5800_homework.ad_swe.abstract_factory_singleton;

public class MacronutrientFactorySingleton {
    private static MacronutrientFactorySingleton instance;
    private final MacronutrientFactory carbsFactory;
    private final MacronutrientFactory proteinFactory;
    private final MacronutrientFactory fatsFactory;

    private MacronutrientFactorySingleton() {
        carbsFactory = new CarbsFactory();
        proteinFactory = new ProteinFactory();
        fatsFactory = new FatsFactory();
    }

    public static MacronutrientFactorySingleton getInstance() {
        if (instance == null) {
            instance = new MacronutrientFactorySingleton();
        }
        return instance;
    }

    public MacronutrientFactory getCarbsFactory() {
        return carbsFactory;
    }

    public MacronutrientFactory getProteinFactory() {
        return proteinFactory;
    }

    public MacronutrientFactory getFatsFactory() {
        return fatsFactory;
    }
}
