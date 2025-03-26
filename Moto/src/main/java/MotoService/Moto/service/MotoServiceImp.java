package MotoService.Moto.service;

import MotoService.Moto.entity.Moto;
import MotoService.Moto.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoServiceImp implements MotoService{

    @Autowired
    private MotoRepository motorepository;

    public List<Moto> getAll(){
        return motorepository.findAll();
    }

    public Moto getMotoById(int id){
        return motorepository.findById(id).orElse(null);
    }

    public Moto saveUser(Moto moto){
        return motorepository.save(moto);
    }


    public List<Moto> byuserId(int userId){
        return motorepository.findByUserId(userId);
    }
}
