package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;

import java.util.Collection;


public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

    

    @Query(value = "SELECT * FROM HABITACIONES", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();    
    
    @Query(value = "SELECT * FROM HABITACIONES WHERE numero= :numero", nativeQuery = true)
    Habitacion darHabitacion(@Param("numero") int numero);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO HABITACIONES (NUMERO,TIPO_HABITACION) VALUES (hotel_sequence.nextval, :tipo_habitacion)", nativeQuery = true)
    void insertarHabitacion(@Param("tipo_habitacion") int tipo_habitacion);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE HABITACIONES SET numero= :numero,tipo_habitacion= :tipo_habitacion WHERE numero= :numero", nativeQuery = true)
    void actualizarHabitacion(@Param("numero") int numero,@Param("tipo_habitacion") int tipo_habitacion);
    
    
    @Modifying
    @Transactional
    @Query(value = "DELETE * FROM HABITACIONES WHERE numero= :numero", nativeQuery = true)
    Habitacion eliminarHabitacion(@Param("numero") int numero);
    
}
