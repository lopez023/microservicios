package CarService.Car.service;

import CarService.Car.entity.Car;
import CarService.Car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImp implements CarService{
    @Autowired
    private CarRepository repository;

    public List<Car> getAll(){
        return repository.findAll();
    }

    public Car getCarById(int id){
        return repository.findById(id).orElse(null);
    }

    public Car saveCar(Car car){
        return repository.save(car);
    }

    @Override
    public List<Car> FindByUserId(int userId) {
        return repository.finCardByUser(userId);
    }
}
