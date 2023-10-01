package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;




@Entity
@Table(name="HABITACIONES")
public class Habitacion {

 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "tipo_habitacion", referencedColumnName = "id")
    private TipoHabitacion tipoHabitacion;

    
    public Habitacion() {;}


    public Habitacion(Integer numero, TipoHabitacion tipoHabitacion) {
        this.numero = numero;
        this.tipoHabitacion = tipoHabitacion;
    }


    public Integer getNumero() {
        return numero;
    }


    public void setNumero(Integer numero) {
        this.numero = numero;
    }


    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }


    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    
}
