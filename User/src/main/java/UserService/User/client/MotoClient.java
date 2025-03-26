package UserService.User.client;


import UserService.User.models.Car;
import UserService.User.models.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name="Moto",url="localhost:8003/moto")
public interface MotoClient {

    @PostMapping("/save")
    Moto saveMoto(@RequestBody Moto moto);

    @GetMapping("/user/{userId}")
    List<Moto> getMoto(@PathVariable int userId);
}
