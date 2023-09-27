package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

import java.util.List;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Long> {

    

    @Query("SELECT e FROM TipoHabitacion e")
    List<TipoHabitacion> findAllTipoHabitacions();

    @Query("SELECT e FROM TipoHabitacion e WHERE e.id = :id")
    TipoHabitacion findTipoHabitacionById(@Param("id") Long id);
    
    
}
