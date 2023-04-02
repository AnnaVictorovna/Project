package project.service;

import project.factory.car.Car;

public class WheelSizeService {
    public void changeWheelSize(Car car, Car.WheelSize wheelSize) {
        if (car != null && wheelSize != null) {
            car.setWheelSize(wheelSize);
        }
    }
}
