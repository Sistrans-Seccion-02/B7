
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
@Table(name="factura")
public class Factura {

    @ManyToOne
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Estadia estadia;

    @OneToMany
    private List<ReservaServicios> reservaServicios;

    @OneToMany
    private List<Producto> productos;

    private double precioTotal;
    private boolean pago;
    
    public Factura() {;}

    public Factura(double precioTotal, boolean pago) {
        this.precioTotal = precioTotal;
        this.pago = pago;
    }

    public double getPreciototal() {
        return precioTotal;
    }

    public void setPreciototal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean getPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
