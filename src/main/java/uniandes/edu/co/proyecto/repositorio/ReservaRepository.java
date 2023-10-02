package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Plan;
import uniandes.edu.co.proyecto.modelo.Reserva;

import java.sql.Date;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    
    //Ver todas las reservas

    @Query(value="SELECT * FROM reserva", nativeQuery = true)
    List<Reserva> findAllReservas();

    //Ver la reserva con id dada

    @Query(value="SELECT * FROM reserva WHERE id = :ID_HABITACION", nativeQuery = true)
    Plan findReservaById(@Param("id_habitacion") Long id);

    //Eliminar reserva
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reserva WHERE id = :ID_HABITACION", nativeQuery = true)
    void eliminarReserva(@Param("id_habitacion") long id);

    //Actualizar reserva con un id dado FALTA

    @Modifying
    @Transactional
    @Query(value = "UPDATE reserva SET nombre = :nombre, descripcion = :descripcion WHERE id = :ID_HABITACION", nativeQuery = true)
    void actualizarReserva(@Param("id") long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    //Insertar un nuevo plan 

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reserva (id, titular, plan, tarifatotal, fecha_llegada, fecha_salida) VALUES ( parranderos_sequence.nextval , :titular, :plan, :tarifatotal, :fecha_llegada, :fecha_salida)", nativeQuery = true)
    void insertarReserva(@Param("titular") String titular, @Param("plan") String plan, @Param("tarifatotal") Long tarifatotal, @Param("fecha_llegada") Date fecha_llegada, @Param("fecha_salida") Date fecha_salida);    
}
