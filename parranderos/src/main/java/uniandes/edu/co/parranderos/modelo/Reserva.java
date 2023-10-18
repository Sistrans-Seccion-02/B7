package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="reservaciones")
@Getter
@Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date fechaLlegada;
    private Date fechaSalida;
    private Boolean pazYsalvo;
    private Integer cantidadPersonas;

    @ManyToOne
    @JoinColumn(name="hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name="planconsumo_id", referencedColumnName = "id")
    private PlanConsumo planConsumo;

    @OneToMany(mappedBy="reserva")
    private List<Cliente> titulares;

    @OneToMany(mappedBy="reserva")
    private List<Cliente> acompañantes;

    @ManyToMany
    private List<Habitacion> habitaciones;

    @ManyToOne
    @JoinColumn(name="cuentaconsumo_id", referencedColumnName = "id")
    private CuentaConsumo cuentaConsumo;

    public Reserva(){;}
}

