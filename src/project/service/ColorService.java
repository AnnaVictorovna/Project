package project.service;

import project.factory.car.Car;

public class ColorService {
    public void changeColor(Car car, Car.Color color) {
        if (color != null && car != null) {
            car.setColor(color);
        }
    }
}