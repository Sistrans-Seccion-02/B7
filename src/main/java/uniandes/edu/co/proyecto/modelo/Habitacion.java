package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;




@Entity
@Table(name="habitacion")
public class Habitacion {

    @ManyToOne
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int numero;

    @ManyToOne
    private TipoHabitacion tipoHabitacion;

    
    public Habitacion() {;}

    public Habitacion(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
