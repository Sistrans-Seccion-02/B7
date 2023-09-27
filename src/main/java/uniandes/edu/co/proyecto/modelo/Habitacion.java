
package uniandes.edu.co.hotel.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;


package uniandes.edu.co.hotel.modelo;


@Entity
@Table(name="habitacion")
public class Habitacion {

    @ManyToOne
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Hotel hotel;

    @ManyToOne
    private TipoHabitacion tipoHabitacion;

    private int numero;
    
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
