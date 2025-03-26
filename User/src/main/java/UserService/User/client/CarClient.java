package UserService.User.client;


import UserService.User.models.Car;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="Car",url="http://localhost:8002/car")
public interface CarClient {

    @PostMapping("/save")
    Car saveCar(@RequestBody Car car);

    @GetMapping("/user/{userId}")
    List<Car> getCar(@PathVariable int userId);
}
