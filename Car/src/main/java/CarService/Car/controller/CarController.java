package CarService.Car.controller;


import CarService.Car.entity.Car;
import CarService.Car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> UserList(){
        List<Car> car = carService.getAll();
        if(car.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(car);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getUserById(@PathVariable int id){
        Car car = carService.getCarById(id);
        if(car==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }

    @PostMapping("/save")
    public ResponseEntity<Car> saveUser(@RequestBody Car car){
        Car newCar = carService.saveCar(car);
        return ResponseEntity.ok(newCar);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> listCarByUserId(@PathVariable int userId){
        List<Car> car = carService.FindByUserId(userId);
        if(car.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(car);
    }

}
