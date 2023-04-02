import project.factory.Factory;
import project.factory.Model;
import project.factory.car.Car;
import project.factory.car.bus.Bus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Factory<Bus> audi = new Factory<> (Bus.class,
                List.of(Model.A,Model.B,Model.C),
                List.of(Car.Color.BLUE, Car.Color.RED),
                List.of(Car.WheelSize.SMALL, Car.WheelSize.BIG),
                List.of(Car.EngineCapacity.SMALL, Car.EngineCapacity.BIG)
                );
        Bus car = audi.createCar(1, null, null, null, null);
       Model[] n = Model.values();

// создать метод по созданию машины, возвращаемый тип которого зависит от переданного типа в конструктор
        //переданный тип в конструктор влияет на возвращаемый тип метода создающего машины
        // audi - объект типа Factory
        // maz - объект типа Bus
    }
}