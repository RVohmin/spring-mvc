package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {

    List<Car> cars;

    {
        cars = new ArrayList<>();
        Car car1 = new Car("Kia", "111", "Black");
        Car car2 = new Car("BMW", "222", "White");
        Car car3 = new Car("Opel", "333", "Blue");
        Car car4 = new Car("Niccan", "444", "Red");
        Car car5 = new Car("Volvo", "555", "Green");
        Car car6 = new Car("Niccan", "567", "Yellow");
        Car car7 = new Car("Volvo", "777", "Orange");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> getCars(Integer count) {
        List<Car> tempList;
        if (count != null && count < 5) {
            tempList = cars.stream().limit(count).collect(Collectors.toList());
        } else {
            tempList = cars;
        }
        return tempList;
    }
}
