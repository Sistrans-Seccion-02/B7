package uniandes.edu.co.proyecto.modelo;
import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReservadaParaPK implements Serializable {
 
    @ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id")
    private Reserva id_reserva;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", referencedColumnName = "id")
    private Habitacion id_Habitacion;

    public ReservadaParaPK()
    {
        super();
    }

    public ReservadaParaPK(Reserva id_reserva, Habitacion id_habitacion)
    {
        super();
        this.id_reserva= id_reserva;
        this.id_Habitacion = id_habitacion;
    }

    public Reserva getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Reserva id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Habitacion getId_Habitacion() {
        return id_Habitacion;
    }

    public void setId_Habitacion(Habitacion id_Habitacion) {
        this.id_Habitacion = id_Habitacion;
    }

    
}
