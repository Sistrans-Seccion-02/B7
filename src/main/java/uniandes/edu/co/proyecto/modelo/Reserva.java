package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.sql.Date;




@Entity
@Table(name="reserva")
public class Reserva {

    @ManyToOne
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Habitacion habitacion;

    @ManyToOne
    private Titular titular;

    @ManyToOne
    private Plan plan;

    @OneToOne
    private Estadia estadia;

    private int numero;
    private double tarifatotal;
    private Date fechallegada;
    private Date fechasalida;
    private int cantidadpersonas;
    
    public Reserva() {;}

    public Reserva(int numero, double tarifatotal, Date fechallegada, Date fechasalida, int cantidadpersonas) {
        this.numero = numero;
        this.tarifatotal = tarifatotal;
        this.fechallegada = fechallegada;
        this.fechasalida = fechasalida;
        this.cantidadpersonas = cantidadpersonas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getTarifatotal() {
        return tarifatotal;
    }

    public void setTarifatotal(double tarifatotal) {
        this.tarifatotal = tarifatotal;
    }

    public Date getFechallegada() {
        return fechallegada;
    }

    public void setFechallegada(Date fechallegada) {
        this.fechallegada = fechallegada;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public int getCantidadpersonas() {
        return cantidadpersonas;
    }

    public void setCantidadpersonas(int cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }
}
