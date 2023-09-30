package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservadaPara")
public class ReservadaPara {

    @EmbeddedId
    private ReservadaParaPK pk;

    public ReservadaPara() {
        ;
    }

    public ReservadaPara(Reserva id_reserva, Habitacion id_habitacion) {
        super();
        this.pk = new ReservadaParaPK(id_reserva, id_habitacion);
    }

    public ReservadaParaPK getPk() {
        return pk;
    }

    public void setPk(ReservadaParaPK pk) {
        this.pk = pk;
    }
}