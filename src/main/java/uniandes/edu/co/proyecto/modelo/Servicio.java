
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
@Table(name="servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String tipo;
    
    public Servicio() {;}

    public Servicio(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
