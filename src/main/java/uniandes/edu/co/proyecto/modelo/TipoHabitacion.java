package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;





@Entity
@Table(name="TIPOS_HABITACION")
public class TipoHabitacion {

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;

    private String nombre;
    private int capacidad;
    private String dotacion;
    
    public TipoHabitacion() {;}

    public TipoHabitacion(String nombre, int capacidad, String dotacion) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.dotacion = dotacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDotacion() {
        return dotacion;
    }

    public void setDotacion(String dotacion) {
        this.dotacion = dotacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
