
package uniandes.edu.co.hotel.modelo;

public class GastroBar extends Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int capacidad;
    private String estilo;
    private String carta;
    
    public GastroBar() {;}

    public GastroBar(int capacidad, String estilo, String carta) {
        this.capacidad = capacidad;
        this.estilo = estilo;
        this.carta = carta;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getCarta() {
        return carta;
    }

    public void setCarta(String carta) {
        this.carta = carta;
    }
}
