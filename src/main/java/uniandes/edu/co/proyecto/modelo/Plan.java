package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;




@Entity
@Table(name="plan")
public class Plan {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String descripcion;
    
    public Plan() {;}

    public Plan(Long id, String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id= id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
