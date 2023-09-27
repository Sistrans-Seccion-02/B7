package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.ReservaServicios;

import java.util.List;

public interface ReservaServicioRepository extends JpaRepository<ReservaServicios, Long> {

    

    @Query("SELECT e FROM ReservaServicio e")
    List<ReservaServicios> findAllReservaServicios();

    @Query("SELECT e FROM ReservaServicio e WHERE e.id = :id")
    ReservaServicios findReservaServicioById(@Param("id") Long id);
    
    
}
