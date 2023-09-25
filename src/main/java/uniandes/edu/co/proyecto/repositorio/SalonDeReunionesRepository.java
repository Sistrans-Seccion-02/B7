package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniandes.edu.co.proyecto.modelo.SalonDeReuniones;

@Repository
public interface SalonDeReunionesRepository extends JpaRepository<SalonDeReuniones, Long> {
    
}