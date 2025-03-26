package UserService.User.service;

import UserService.User.client.CarClient;
import UserService.User.client.MotoClient;
import UserService.User.entity.User;
import UserService.User.models.Car;
import UserService.User.models.Moto;
import UserService.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository repository;

    @Autowired
    private CarClient carClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private MotoClient motoClient;
/*
    public List<Car> getCars(int userId){
        List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/user/" + userId, List.class);
        return cars;

    }

    public List<Moto> getMotos(int userId){
        List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/user/" + userId, List.class);
        return motos;
    }*/


    public Car saveCar(int id,Car car){
        car.setUsuarioId(id);
        return carClient.saveCar(car);


    }


    public List<User> getAll(){
        return repository.findAll();
    }

    public User getUserById(int id){
        return repository.findById(id).orElse(null);
    }

    public User saveUser(User user){
        return repository.save(user);
    }

    public Moto saveMoto(int userId, Moto moto){
        moto.setUserId(userId);
        return motoClient.saveMoto(moto);

    }

    public Map<String, Object> getMotoAndCar(int userId){
        Map<String,Object> result = new HashMap<>();
        User user = repository.findById(userId).orElse(null);

        if(user==null){
            result.put("Mensaje","user Not found");
        }else{
            result.put("Usuario",user);
        }

        List<Car> car=carClient.getCar(userId);
        if(car.isEmpty()){
            result.put("Car","user does not have car");
        }else{
            result.put("carros", car);
        }

        List<Moto> moto=motoClient.getMoto(userId);

        if(moto.isEmpty()){
            result.put("motos","user does not have moto");
        }else{
            result.put("Motos",moto);
        }
        return result;
    }

}
