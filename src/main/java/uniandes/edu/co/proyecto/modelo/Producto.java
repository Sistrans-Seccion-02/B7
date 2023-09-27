package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;



@Entity
@Table(name="producto")
public class Producto {

    @ManyToOne
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Factura factura;

    private int id;
    private double precio;
    private String nombre;
    
    public Producto() {;}

    public Producto(int id, double precio, String nombre) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
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
}
