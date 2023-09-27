package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uniandes.edu.co.proyecto.modelo.Usuario;

import java.util.List;

public interface TipoUsuarioRepository extends JpaRepository<Usuario, Long> {

    

    @Query("SELECT e FROM TipoUsuario e")
    List<Usuario> findAllTipoUsuarios();

    @Query("SELECT e FROM TipoUsuario e WHERE e.id = :id")
    Usuario findTipoUsuarioById(@Param("id") Long id);
    
    
}
