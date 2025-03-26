package UserService.User.service;

import UserService.User.entity.User;
import UserService.User.models.Car;
import UserService.User.models.Moto;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User saveUser(User user);
//    public List<Car> getCars(int userId);

    public Car saveCar(int id,Car car);
//    public List<Moto> getMotos(int userId);
    public List<User> getAll();

    public User getUserById(int id);


    Map<String, Object> getMotoAndCar(int userId);

    public Moto saveMoto(int userId, Moto moto);
}
