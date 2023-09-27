package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;




@Entity
@Table(name="usuario")
public class Usuario {

    @ManyToOne
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String numeroDocumento;

    private String TipoDocumento;
    private String Rol;
    private String Correo;
    
    public Usuario() {;}

    public Usuario(String numeroDocumento, String TipoDocumento, String Rol, String Correo) {
        this.numeroDocumento = numeroDocumento;
        this.TipoDocumento = TipoDocumento;
        this.Rol = Rol;
        this.Correo = Correo;
    }

    public String getNumerodocumento() {
        return numeroDocumento;
    }

    public void setNumerodocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipodocumento() {
        return TipoDocumento;
    }

    public void setTipodocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
}
