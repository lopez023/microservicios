package MotoService.Moto.service;


import MotoService.Moto.entity.Moto;

import java.util.List;

public interface MotoService {


     List<Moto> getAll();

     Moto getMotoById(int id);

     Moto saveUser(Moto moto);


     List<Moto> byuserId(int userId);

}
