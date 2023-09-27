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

    @ManyToOne
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Reserva reserva;

    @ManyToOne
    private Titular titular;

    private String nombre;
    private String descripcion;
    
    public Plan() {;}

    public Plan(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
