package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;




@Entity
@Table(name="titular")
public class Titular {

    @ManyToOne
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Reserva reserva;

    @ManyToOne
    private Plan plan;

    private String dni;
    private String nombre;
    private String correo;
    private int numeroAcompañantes;
    
    public Titular() {;}

    public Titular(String dni, String nombre, String correo, int numeroAcompañantes) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.numeroAcompañantes = numeroAcompañantes;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumeroacompañantes() {
        return numeroAcompañantes;
    }

    public void setNumeroacompañantes(int numeroAcompañantes) {
        this.numeroAcompañantes = numeroAcompañantes;
    }
}
