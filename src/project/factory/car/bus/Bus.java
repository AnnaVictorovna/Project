package project.factory.car.bus;

import project.factory.car.Car;

public class Bus extends Car {
    public Bus(int year, EngineCapacity engineCapacity, String model) {
        super(year, engineCapacity, model);
    }
    Bus (int year){
        super(1,null,null);
    }

    public enum HandRail {

    }

    private HandRail handRail;

    public HandRail getHandRail() {
        return handRail;
    }

    public void setHandRail(HandRail handRail) {
        this.handRail = handRail;
    }
}
