package uniandes.edu.co.proyecto.repositorio;




import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Integer>{

    @Query(value = "SELECT * FROM TIPOS_USUARIO", nativeQuery = true)
    Collection<TipoUsuario> darTiposUsuario();    
    
    @Query(value = "SELECT * FROM TIPOS_USUARIO WHERE id= :id", nativeQuery = true)
    TipoUsuario darTipoUsuario(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TIPOS_USUARIO (ID,NOMBRE,DESCRIPCION) VALUES (hotel_sequence.nextval, :nombre, :descripcion)", nativeQuery = true)
    void insertarTipoUsuario(@Param("nombre") String nombre, @Param("descripcion") String descripcion);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE TIPOS_USUARIO SET nombre= :nombre, descripcion= :descripcion WHERE id= :id", nativeQuery = true)
    void actualizarTipoUsuario(@Param("id") int id,@Param("nombre") String nombre, @Param("descripcion") String descripcion);
    
    
    @Modifying
    @Transactional
    @Query(value = "DELETE * FROM TIPOS_USUARIO WHERE id= :id", nativeQuery = true)
    TipoUsuario eliminarTipoUsuario(@Param("id") int id);
    
}
