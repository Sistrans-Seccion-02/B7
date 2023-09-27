package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Lavanderia extends Servicio {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int numPrendas;
    private String Descripcion;
    
    public Lavanderia() {;}

    public Lavanderia(int numPrendas, String Descripcion) {
        this.numPrendas = numPrendas;
        this.Descripcion = Descripcion;
    }

    public int getNumprendas() {
        return numPrendas;
    }

    public void setNumprendas(int numPrendas) {
        this.numPrendas = numPrendas;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
}
