package UserService.User.controller;

import UserService.User.entity.User;
import UserService.User.models.Car;
import UserService.User.models.Moto;
import UserService.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> UserList(){
        List<User> user = userService.getAll();
        if(user.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user = userService.getUserById(id);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }
/*

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable int userId){
        User user = userService.getUserById(userId);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        List<Car> cars = userService.getCars(userId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/motos/{userId}")
    public ResponseEntity<List<Moto>> getMotos(@PathVariable int userId){
        User user = userService.getUserById(userId);
        if(user==null){
            return ResponseEntity.notFound().build();
        }

        List<Moto> motos  = userService.getMotos(userId);
        return ResponseEntity.ok(motos);
    }
*/
    @PostMapping("save/car/{userId}")
    public ResponseEntity<?> saveCar(@PathVariable int userId, @RequestBody Car car){
        return ResponseEntity.ok(userService.saveCar(userId,car));
    }

    @PostMapping("save/moto/{userId}")
    public ResponseEntity<?> saveMoto(@PathVariable int userId, @RequestBody Moto moto){
        return ResponseEntity.ok(userService.saveMoto(userId,moto));
    }


    @GetMapping("/all/{userId}")
    public ResponseEntity<?> listCarAndMoto(@PathVariable int userId){
        return ResponseEntity.ok( userService.getMotoAndCar(userId));
    }


}
