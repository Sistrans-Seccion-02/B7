package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Servicio;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    

    @Query("SELECT e FROM Servicio e")
    List<Servicio> findAllServicios();

    @Query("SELECT e FROM Servicio e WHERE e.id = :id")
    Servicio findServicioById(@Param("id") Long id);
    
    
}
