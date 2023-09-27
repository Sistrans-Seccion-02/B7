package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Titular;

import java.util.List;

public interface TitularRepository extends JpaRepository<Titular, Long> {

    

    @Query("SELECT e FROM Titular e")
    List<TitularRepository> findAllUsuarios();

    @Query("SELECT e FROM Titular e WHERE e.id = :id")
    TitularRepository findUsuarioById(@Param("id") Long id);
    
    
}
