package project.showroom;

import project.factory.Factory;
import project.factory.Model;
import project.factory.Option;
import project.factory.Order;
import project.factory.car.Car;
import project.factory.car.bus.Bus;
import project.factory.car.passengerCar.PassengerCar;
import project.factory.car.truck.Truck;
import project.service.ColorService;
import project.service.OptionService;
import project.service.WheelSizeService;

import java.util.Set;

public class Showroom {
    private final ColorService colorService;
    private final OptionService optionService;
    private final WheelSizeService wheelSizeService;
    private final Factory<Bus> factoryBus;
    private final Factory<Truck> factoryTruck;
    private final Factory<PassengerCar> factoryPassengerCar;

    public Showroom(ColorService colorService, OptionService optionService, WheelSizeService wheelSizeService, Factory<Bus> factoryBus, Factory<Truck> factoryTruck, Factory<PassengerCar> factoryPassengerCar) {
        this.colorService = colorService;
        this.optionService = optionService;
        this.wheelSizeService = wheelSizeService;
        this.factoryBus = factoryBus;
        this.factoryTruck = factoryTruck;
        this.factoryPassengerCar = factoryPassengerCar;
    }

    public Bus orderBus(Model model, Car.EngineCapacity engineVolume, Car.Color color, Car.WheelSize wheelSize, Set<Option> options) {
        Order<Bus> busOrder = new Order<>(new Bus(2023, engineVolume, model.name()));
        return factoryBus.createCar(busOrder);
    }

    public Truck orderTruck(Model model,
                            Car.EngineCapacity engineVolume,
                            Car.Color color,
                            Car.WheelSize wheelSize,
                            Set<Option> options) {
        Order<Truck> truckOrder = new Order<>(new Truck(2023, engineVolume, model.name()));
        return factoryTruck.createCar(truckOrder);

    }

    public PassengerCar orderPassenger(Model model,
                                       Car.EngineCapacity engineVolume,
                                       Car.Color color,
                                       Car.WheelSize wheelSize,
                                       Set<Option> options) {
        Order<PassengerCar> passengerCarOrder = new Order<>(new PassengerCar(2023, engineVolume, model.name()));
        return factoryPassengerCar.createCar(passengerCarOrder);
    }
    public void changeColor(Car car, Car.Color color) {
        colorService.changeColor(car, color);
    }

    public void changeWheels(Car car, Car.WheelSize wheelSize) {
        wheelSizeService.changeWheelSize(car, wheelSize);
    }

    public void addOption(Car car, Option option) {
        optionService.addOption(car, option);
    }

    public void deleteOption(Car car, Option option) {
        optionService.removeOption(car, option);
    }
}