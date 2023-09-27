
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
@Table(name="estadia")
public class Estadia {

    @ManyToOne
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Reserva reserva;

    @OneToOne
    private Factura factura;

    private int id;
    private Date fechaLlegada;
    private Date fechaSalida;
    
    public Estadia() {;}

    public Estadia(int id, Date fechaLlegada, Date fechaSalida) {
        this.id = id;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechallegada() {
        return fechaLlegada;
    }

    public void setFechallegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechasalida() {
        return fechaSalida;
    }

    public void setFechasalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
