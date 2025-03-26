package CarService.Car.service;

import CarService.Car.entity.Car;

import java.util.List;

public interface CarService  {



    public List<Car> getAll();
    public Car getCarById(int id);
    public Car saveCar(Car car);

    List<Car> FindByUserId(int userId);
}
