package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIOS")

public class Usuario {

    @Id
    private Integer num_documento;

    private String tipo_documento;
    private String nombre;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario", referencedColumnName = "id")
     private TipoUsuario tipo_usuario;


    public Usuario(Integer num_documento, String tipo_documento, String nombre, String correo,
            TipoUsuario tipo_usuario) {
        this.num_documento = num_documento;
        this.tipo_documento = tipo_documento;
        this.nombre = nombre;
        this.correo = correo;
        this.tipo_usuario = tipo_usuario;
    }
    
    public Usuario() {;}
    
    public Integer getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(Integer num_documento) {
        this.num_documento = num_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
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

    public TipoUsuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(TipoUsuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    
     
}
