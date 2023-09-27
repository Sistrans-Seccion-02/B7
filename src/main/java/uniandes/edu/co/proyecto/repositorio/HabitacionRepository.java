package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Habitacion;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

    

    @Query("SELECT e FROM Habitacion e")
    List<Habitacion> findAllHabitacions();

    @Query("SELECT e FROM Habitacion e WHERE e.id = :id")
    Habitacion findHabitacionById(@Param("id") Long id);
    
    
}
