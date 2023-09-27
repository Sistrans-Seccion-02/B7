
package uniandes.edu.co.hotel.modelo;

public class Tienda extends Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private List<Producto> productos;
    
    public Tienda() {;}

    public Tienda(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
