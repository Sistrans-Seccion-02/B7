package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Titular;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Titular, Long> {

    

    @Query("SELECT e FROM Usuario e")
    List<Titular> findAllUsuarios();

    @Query("SELECT e FROM Usuario e WHERE e.id = :id")
    Titular findUsuarioById(@Param("id") Long id);
    
    
}
