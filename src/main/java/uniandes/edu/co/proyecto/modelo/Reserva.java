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

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id_habitacion;

    private String titular;
    private String plan;
    private int numero;
    private double tarifatotal;
    private Date fechallegada;
    private Date fechasalida;
    private int cantidadpersonas;
    
    public Reserva() {;}

    public Reserva(String id_habitacion, String titular, String plan, double tarifatotal, Date fechallegada,
            Date fechasalida, int cantidadpersonas) {
        this.id_habitacion = id_habitacion;
        this.titular = titular;
        this.plan = plan;
        this.tarifatotal = tarifatotal;
        this.fechallegada = fechallegada;
        this.fechasalida = fechasalida;
        this.cantidadpersonas = cantidadpersonas;
    }

    public String getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(String id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
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
