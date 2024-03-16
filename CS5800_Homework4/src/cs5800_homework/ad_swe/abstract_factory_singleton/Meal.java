package cs5800_homework.ad_swe.abstract_factory_singleton;

import java.util.List;

public class Meal {

    private final List<String> components;

    public Meal(List<String> components) {
        this.components = components;
    }

    public List<String> getComponents() {
        return components;
    }
}
