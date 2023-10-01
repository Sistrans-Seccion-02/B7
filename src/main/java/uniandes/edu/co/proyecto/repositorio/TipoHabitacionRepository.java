package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;


import java.util.Collection;


public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {

    

   @Query(value = "SELECT * FROM TIPOS_HABITACION", nativeQuery = true)
    Collection<TipoHabitacion> darTiposHabitacion();    
    
    @Query(value = "SELECT * FROM TIPOS_HABITACION WHERE id= :id", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TIPOS_HABITACION (ID,NOMBRE,CAPACIDAD,DOTACION) VALUES (hotel_sequence.nextval, :nombre, :capacidad,:dotacion)", nativeQuery = true)
    void insertarTipoHabitacion(@Param("nombre") String nombre, @Param("capacidad") int capacidad,@Param("dotacion") String dotacion);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE TIPOS_HABITACION SET nombre= :nombre, capacidad= :capacidad, dotacion= :dotacion WHERE id= :id", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("id") int id,@Param("nombre") String nombre, @Param("capacidad") int capacidad,@Param("dotacion") String dotacion);
    
    
    @Modifying
    @Transactional
    @Query(value = "DELETE * FROM TIPOS_HABITACION WHERE id= :id", nativeQuery = true)
    TipoHabitacion eliminarTipoHabitacion(@Param("id") int id);
    
}
