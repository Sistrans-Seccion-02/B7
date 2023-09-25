package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.ServicioSpa;

@Repository
public interface ServicioSpaRepository extends JpaRepository<ServicioSpa, Long> {
    
}