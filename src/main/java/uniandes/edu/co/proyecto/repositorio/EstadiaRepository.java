package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Estadia;

import java.util.List;

public interface EstadiaRepository extends JpaRepository<Estadia, Long> {


    @Query("SELECT e FROM Estadia e")
    List<Estadia> findAllEstadias();

    @Query("SELECT e FROM Estadia e WHERE e.id = :id")
    Estadia findEstadiaById(@Param("id") Long id);
    
}
