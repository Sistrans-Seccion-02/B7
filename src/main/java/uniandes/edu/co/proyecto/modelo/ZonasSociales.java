package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ZonasSociales extends Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int capacidad;
    private String descripcion;
    private String rangoHorario;
    
    public ZonasSociales() {;}

    public ZonasSociales(int capacidad, String descripcion, String rangoHorario) {
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.rangoHorario = rangoHorario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRangohorario() {
        return rangoHorario;
    }

    public void setRangohorario(String rangoHorario) {
        this.rangoHorario = rangoHorario;
    }
}
