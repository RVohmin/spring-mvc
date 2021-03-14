package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cars")
public class CarController {
    List<Car> cars;
    {
        cars = new ArrayList<Car>();
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

    @GetMapping
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> collect;
        if (count != null && count < 5) {
            collect = cars.stream().limit(count).collect(Collectors.toList());
        } else {
            collect = cars;
        }
        model.addAttribute("cars", collect);
        return "car";
    }
}
