package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

     @Query(value = "SELECT * FROM USUARIOS", nativeQuery = true)
    Collection<Usuario> darUsuarios();    
    
    @Query(value = "SELECT * FROM USUARIOS WHERE id= :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USUARIOS (NUM_DOCUMENTO,TIPO_DOCUMENTO,NOMBRE, CORREO,TIPO_USUARIO) VALUES (:num_documento, :tipo_documento,:nombre,:correo,:tipo_usuario)", nativeQuery = true)
    void insertarTipoUsuario(@Param("num_documento") int num_documento,@Param("tipo_documento") String tipo_documento,@Param("nombre") String nombre,@Param("correo") String correo,@Param("tipo_usuario") int tipo_usuario);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE USUARIOS SET num_documento= :num_documento,tipo_documento= :tipo_documento,nombre= :nombre,correo= :correo,tipo_usuario= :tipo_usuario WHERE num_documento= :num_documento", nativeQuery = true)
    void actualizarTipoUsuario(@Param("num_documento") int num_documento,@Param("tipo_documento") String tipo_documento,@Param("nombre") String nombre,@Param("correo") String correo,@Param("tipo_usuario") int tipo_usuario);
    
    
    @Modifying
    @Transactional
    @Query(value = "DELETE * FROM USUARIOS WHERE id= :id", nativeQuery = true)
    Usuario eliminarUsuario(@Param("id") int id);
    
}
