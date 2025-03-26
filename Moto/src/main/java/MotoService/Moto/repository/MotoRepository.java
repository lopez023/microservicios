package MotoService.Moto.repository;

import MotoService.Moto.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MotoRepository extends JpaRepository<Moto,Integer> {

    @Query("select m from Moto m Where m.userId = :userId")
    List<Moto> findByUserId(@Param("userId") int userId);

}
