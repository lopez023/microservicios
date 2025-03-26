package MotoService.Moto.controller;

import MotoService.Moto.entity.Moto;
import MotoService.Moto.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> UserList(){
        List<Moto> moto = motoService.getAll();
        if(moto.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(moto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> getUserById(@PathVariable int id){
        Moto moto = motoService.getMotoById(id);
        if(moto==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @PostMapping("/save")
    public ResponseEntity<Moto> saveMoto(@RequestBody Moto moto){
        Moto newMoto = motoService.saveUser(moto);
        return ResponseEntity.ok(newMoto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Moto>> ListMotoByUseId(@PathVariable int userId){
        List<Moto> motos = motoService.byuserId(userId);
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

}
