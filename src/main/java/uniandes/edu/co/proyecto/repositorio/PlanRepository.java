package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    
    //Ver todos los planes

    @Query("SELECT * FROM plan e")
    List<Plan> findAllPlans();

    //Ver el plan con id dada

    @Query("SELECT * FROM plan WHERE id = :id")
    Plan findPlanById(@Param("id") Long id);

    //Eliminar plan con un id dado
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM plan WHERE id = :id", nativeQuery = true)
    void eliminarPlan(@Param("id") long id);

    //Actualizar plan con un id dado

    @Modifying
    @Transactional
    @Query(value = "UPDATE bebedores SET nombre = :nombre, descripcion = :descripcion WHERE id = :id", nativeQuery = true)
    void actualizarPlan(@Param("id") long id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    //Insertar un nuevo plan

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO plan (id, nombre, descripcion) VALUES ( parranderos_sequence.nextval , :nombre,:descripcion)", nativeQuery = true)
    void insertarPlan(@Param("nombre") String nombre, @Param("descripcion") String descripcion);    
}
