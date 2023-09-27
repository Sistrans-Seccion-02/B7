package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Salon extends Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int Capacidad;
    private double precioAdicional;
    
    public Salon() {;}

    public Salon(int Capacidad, double precioAdicional) {
        this.Capacidad = Capacidad;
        this.precioAdicional = precioAdicional;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public double getPrecioadicional() {
        return precioAdicional;
    }

    public void setPrecioadicional(double precioAdicional) {
        this.precioAdicional = precioAdicional;
    }
}
