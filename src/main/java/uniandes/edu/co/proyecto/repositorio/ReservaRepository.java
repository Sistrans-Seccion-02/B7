package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Reserva;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    

    @Query("SELECT e FROM Reserva e")
    List<Reserva> findAllReservas();

    @Query("SELECT e FROM Reserva e WHERE e.id = :id")
    Reserva findReservaById(@Param("id") Long id);
    
    
}
