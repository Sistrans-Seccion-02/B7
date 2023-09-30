package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.ReservadaPara;

import java.util.Collection;


public interface ReservadaParaRepository  extends JpaRepository<ReservadaPara, Integer>{

    // Verificar reservas de habitaciones 

    @Query(value = "SELECT * FROM reservadaPara", nativeQuery = true)
    Collection<ReservadaPara> darReservadas();

    // Verificar reservas específicas de habitaciones y reservas

    @Query(value = "SELECT * FROM reservadaPara WHERE id_reserva = :id_reserva AND id_habitacion = :id_habitacion", nativeQuery = true)
    ReservadaPara darReservadaPorId(@Param("id_reserva") Integer id_reserva, @Param("id_habitacion") Integer id_habitacion);

}
