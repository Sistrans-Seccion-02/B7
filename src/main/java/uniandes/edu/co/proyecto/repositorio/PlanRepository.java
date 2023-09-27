package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Plan;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    

    @Query("SELECT e FROM Plan e")
    List<Plan> findAllPlans();

    @Query("SELECT e FROM Plan e WHERE e.id = :id")
    Plan findPlanById(@Param("id") Long id);
    
    
}
