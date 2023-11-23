package TPI.Final141.dominio;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import java.util.List;
import java.util.Date;
import org.hibernate.annotations.Type;
import lombok.Data;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCliente;

    @Column(unique = true)
    private int dniCliente;

    @Column
    private String nombreCliente;

    @Column
    private String direccionCliente;

    @Column
    private String emailCliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIncidencia")
    private List<Incidencia> incidencias;

    public Cliente() {
    }

    public Cliente(long idCliente, int dniCliente, String nombreCliente, String direccionCliente, String emailCliente, List<Incidencia> incidencias) {
        this.idCliente = idCliente;
        this.dniCliente = dniCliente;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.emailCliente = emailCliente;
        this.incidencias = incidencias;
    }

    @Override
    public String toString() {
        return "\nCliente: "
                + "\n==========================="
                + "\nid: " + idCliente
                + "\nDNI: " + dniCliente
                + "\nNombre: " + nombreCliente
                + "\nDirección: " + direccionCliente
                + "\nemail: " + emailCliente;
    }

}
