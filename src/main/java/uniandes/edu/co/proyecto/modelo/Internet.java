
package uniandes.edu.co.hotel.modelo;

public class Internet extends Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int capacidad;
    
    public Internet() {;}

    public Internet(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
