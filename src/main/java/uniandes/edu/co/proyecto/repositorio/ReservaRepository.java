package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Plan;
import uniandes.edu.co.proyecto.modelo.Reserva;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {


    //Ver la reserva con id dada

    @Query("SELECT * FROM reserva WHERE id = :id")
    Plan findReservaById(@Param("id") Long id);

    //Eliminar reserva con un id dado
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reserva WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id") long id);

    //Actualizar reserva con un id dado

    @Modifying
    @Transactional
    @Query(value = "UPDATE bebedores SET nombre = :nombre, descripcion = :descripcion WHERE id = :id", nativeQuery = true)
    void actualizarPlan(@Param("id") long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    //Insertar una nueva reserva
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reserva (id, numero, tarifatotal, fechallegada, fechasalida, cantidadpersonas) VALUES ( parranderos_sequence.nextval , :numero, :tarifatotal, :fechallegada, :fechasalida,:cantidadpersonas)", nativeQuery = true)
    void insertarPlan(@Param("numero") int numero, @Param("tarifatotal") Double tarifatotal, @Param("fechallegada") Date fechallegada, @Param("fechasalida") Date fechasalida, @Param("cantidadpersonas") int cantidadpersonas); 
    
    
}
