package project.factory.car.truck;

import project.factory.car.Car;

public class Truck extends Car {
    public Truck(int year, EngineCapacity engineCapacity, String model) {
        super(year, engineCapacity, model);
    }
     private Trailer trailer;

    public enum Trailer {
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }
}
