package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="LlegadaCliente")
public class LlegadaCliente {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long LlegadaCliente_id;
    
    private Long reserva_id;
    private String fecha_llegada;

    public LlegadaCliente() {;}

    public LlegadaCliente(Long LlegadaCliente_id, Long reserva_id, String fecha_llegada) {
        this.LlegadaCliente_id = LlegadaCliente_id;
        this.reserva_id = reserva_id;
        this.fecha_llegada = fecha_llegada;
    }

    public Long getLlegadaCliente_Id() {
        return LlegadaCliente_id;
    }

    public Long getReserva_id() {
        return reserva_id;
    }

    public String getFecha_llegada() {
        return fecha_llegada;
    }

    public void setLlegadaCliente_id(Long LlegadaCliente_id) {
        this.LlegadaCliente_id = LlegadaCliente_id;
    }

    public void setReserva_id(Long reserva_id) {
        this.reserva_id = reserva_id;
    }

    public void setFecha_llegada(String fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }


    }