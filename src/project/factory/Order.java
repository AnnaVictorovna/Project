package project.factory;

import project.factory.car.Car;
import project.factory.car.bus.Bus;
import project.factory.car.truck.Truck;

public class Order <T extends Car> {

    private T car;

    public Order(T car) {
        this.car = car;
    }

    public T getCar() {
        return car;
    }
}
