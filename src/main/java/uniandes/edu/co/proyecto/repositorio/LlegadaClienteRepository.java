package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.LlegadaCliente;
import uniandes.edu.co.proyecto.modelo.Plan;
import uniandes.edu.co.proyecto.modelo.Reserva;

import java.sql.Date;
import java.util.List;

import javax.xml.crypto.Data;

public interface LlegadaClienteRepository extends JpaRepository<Reserva, Long> {

    
    //Ver todas las llegadas

    @Query(value="SELECT * FROM LlegadaCliente", nativeQuery = true)
    List<LlegadaCliente> findAllLlegadas();

    //Ver la llegada con id dada

    @Query(value="SELECT * FROM LlegadaCliente WHERE id = :id", nativeQuery = true)
    Plan findLlegadaById(@Param("LlegadaCliente_id") Long LlegadaCliente_id);

    //Eliminar llegada
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM LlegadaCliente WHERE id = :LlegadaClienteid", nativeQuery = true)
    void eliminarLlegada(@Param("LlegadaCliente_id") long LlegadaaCliente_id);

    //Actualizar llegada con un id dado

    @Modifying
    @Transactional
    @Query(value = "UPDATE LlegadaCliente SET LlegadaCliente_Id = :LlegadaCliente_id, ReservaId = :ReservaId, FechaLlegada = :FechaLlegada WHERE id = :LlegadaCliente_Id", nativeQuery = true)
    void actualizarLlegada(@Param("LlegadaCliente_id") Long LlegadaCliente_id, @Param("ReservaId") Long ReservaId, @Param("FechaLlegada") Date fecha_llegada);

    //Insertar una nueva llegada

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO LlegadaCliente (LlegadaCliente_id, ReservaId, FechaLlegada) VALUES ( secuenciallegada.nextval , :ReservaId,:FechaLlegada)", nativeQuery = true)
    void insertarLlegada(@Param("ReservaId") String ReservaId, @Param("FechaLlegada") Data FechaLlegada);    
}