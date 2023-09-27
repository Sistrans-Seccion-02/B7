package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;


import java.sql.Date;




@Entity
@Table(name="reservaservicios")
public class ReservaServicios {

    @ManyToOne
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Factura factura;

    @ManyToOne
    private Servicio servicio;

    private int id;
    private double precio;
    private String nombre;
    private Date fechareserva;
    
    public ReservaServicios() {;}

    public ReservaServicios(int id, double precio, String nombre, Date fechareserva) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.fechareserva = fechareserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(Date fechareserva) {
        this.fechareserva = fechareserva;
    }
}
