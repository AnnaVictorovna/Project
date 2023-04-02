package project.factory;

import project.factory.car.Car;
import project.factory.car.bus.Bus;
import project.factory.car.passengerCar.PassengerCar;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Year;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static java.lang.String.format;

public class Factory<T extends Car> {
    private static final String TO_STRING_TEMPLATE = "{wheelSizes: %s, engineCapacities: %s,  models: %s, colors: %s}";


    private List<Model> models;
    private List<Car.Color> colors;
    private List<Car.WheelSize> wheelSizes;
    private List<Car.EngineCapacity> engineCapacities;
    private final Class<T> clazz;
    private final List<T> storage;

    public Factory(Class<T> clazz,
                   List<Model> models,
                   List<Car.Color> colors,
                   List<Car.WheelSize> wheelSizes,
                   List<Car.EngineCapacity> engineCapacities) {
        this.clazz = clazz;
        this.models = models;
        this.colors = colors;
        this.wheelSizes = wheelSizes;
        this.engineCapacities = engineCapacities;
        this.storage = new ArrayList<>();
        generateCars();
    }

    private void generateCars() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(25); i++) {
            storage.add(createCar(ZonedDateTime.now().minusYears(random.nextInt(5)).getYear(),
                    engineCapacities.get(random.nextInt(engineCapacities.size())),
                    models.get(random.nextInt(models.size())).name(),
                    wheelSizes.get(random.nextInt(wheelSizes.size())),
                    colors.get(random.nextInt(colors.size()))
            ));
        }
    }

    private T createCar(int year, Car.EngineCapacity engineCapacity, String model, Car.WheelSize wheelSize, Car.Color color) {
        try {
            Constructor<T> constructor = clazz.getConstructor(int.class, Car.EngineCapacity.class, String.class);
            T newCar = constructor.newInstance(year, engineCapacity, model);
            newCar.setWheelSize(wheelSize);
            newCar.setColor(color);
            return newCar;
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            System.err.println("error");
        }
        return null;
    }

    public T createCar(Order<T> order) {
        Car.Color orderColor = order.getCar().getColor();
        Car.WheelSize orderWheelSize = order.getCar().getWheelSize();
        T carFromStorage = getCarFromStorage(order.getCar().getModel(),
                order.getCar().getEngineCapacity(),
                orderColor,
                orderWheelSize);
        if (carFromStorage != null) {
            if (!orderColor.equals(carFromStorage.getColor())) {
                carFromStorage.setColor(orderColor);
            }
            if (!orderWheelSize.equals(carFromStorage.getWheelSize())) {
                carFromStorage.setWheelSize(orderWheelSize);
            }
        }
        return createCar(
                2023,
                order.getCar().getEngineCapacity(),
                order.getCar().getModel(),
                orderWheelSize,
                orderColor
        );
    }

    private T getCarFromStorage(String model, Car.EngineCapacity engineVolume, Car.Color color, Car.WheelSize wheelSize) {
        T car = null;
        int index = 0;
        for (int i = 0; i < storage.size(); i++) {
            T temp = storage.get(i);
            if (temp.getEngineCapacity() == engineVolume && temp.getModel().equals(model)) {
                if (car == null) {
                    car = temp;
                    index = i;
                    continue;
                }
                if (temp.getColor() == color && car.getColor() != color) {
                    car = temp;
                    index = i;
                    continue;
                }
                if (temp.getWheelSize() == wheelSize && car.getWheelSize() != wheelSize) {
                    car = temp;
                    index = i;
                }
            }
        }
        if (car != null) {
            storage.remove(index);
        }
        return car;
    }

    @Override
    public String toString() {
        return format(
                TO_STRING_TEMPLATE,
                wheelSizes,
                engineCapacities,
                models,
                colors
        );
    }
}
