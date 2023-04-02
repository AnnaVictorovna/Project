package project.factory.car;

import project.factory.Option;

import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

public abstract class Car {

    private static final String TO_STRING_TEMPLATE = "%s{year: %s, wheelSize: %s, engineCapacity: %s,  model: %s, color: %s, options: %s}";

    private Color color;
    private final int year;
    private final EngineCapacity engineCapacity;
    private final String model;
    private final Set<Option> options = new HashSet<>();
    private WheelSize wheelSize;

    public Car(int year, EngineCapacity engineCapacity, String model) {
        this.year = year;
        this.engineCapacity = engineCapacity;
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public EngineCapacity getEngineCapacity() {
        return engineCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWheelSize(WheelSize wheelSize) {
        this.wheelSize = wheelSize;
    }

    public WheelSize getWheelSize() {
        return wheelSize;
    }

    public Set<Option> getOptions() {
        return new HashSet<>(options);
    }


    public void addOption(Option option) {
        options.add(option);
    }

    public void removeOption(Option option) {
        options.remove(option);
    }

    public enum Color {
        BLUE, RED
    }

    public enum WheelSize {
        SMALL, BIG
    }

    public enum EngineCapacity {
        SMALL, BIG
    }
    @Override
    public String toString() {
        return format(
                TO_STRING_TEMPLATE,
                this.getClass().getSimpleName(),
                year,
                wheelSize,
                engineCapacity,
                model,
                color,
                options
        );
    }
}
