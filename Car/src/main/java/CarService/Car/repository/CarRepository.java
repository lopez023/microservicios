package CarService.Car.repository;

import CarService.Car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {


    @Query("select c from Car c where c.usuarioId = :userId")
    List<Car> finCardByUser(@Param("userId") int userId);

}
