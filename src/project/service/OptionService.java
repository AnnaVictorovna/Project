package project.service;

import project.factory.Option;
import project.factory.car.Car;

public class OptionService {
    public void addOption(Car car, Option option) {
        if (car != null && option != null) {
            car.addOption(option);
        }
    }

    public void removeOption(Car car, Option option) {
        if (car != null && option != null) {
            car.removeOption(option);
        }
    }
}