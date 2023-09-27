package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Factura;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

    

    @Query("SELECT e FROM Consumo e")
    List<Factura> findAllConsumos();

    @Query("SELECT e FROM Consumo e WHERE e.id = :id")
    Factura findConsumoById(@Param("id") Long id);
    
    
}
