package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Alquiler extends Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private boolean retorno;
    
    public Alquiler() {;}

    public Alquiler(boolean retorno) {
        this.retorno = retorno;
    }

    public boolean getRetorno() {
        return retorno;
    }

    public void setRetorno(boolean retorno) {
        this.retorno = retorno;
    }
}
