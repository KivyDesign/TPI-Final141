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
public class Incidencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idIncidencia;
    
    @Column
    private String descripcionIncidencia;
    
//    @Column
//    private TipoDeProblema tipoDeProblema;
    
    @Column
    private double costoIncidencia;
    
    @Column
    private Date fechaIncidencia;
    
    @Column
    private String estadoIncidencia;
    
    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente idCliente;
    
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Categoria idCategoria;
    
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Tecnico idTecnico;
        
    public Incidencia() {
    }

    public Incidencia(long idIncidencia, String descripcionIncidencia, double costoIncidencia, Date fechaIncidencia, String estadoIncidencia, Cliente idCliente, Categoria idCategoria, Tecnico idTecnico) {
        this.idIncidencia = idIncidencia;
        this.descripcionIncidencia = descripcionIncidencia;
        this.costoIncidencia = costoIncidencia;
        this.fechaIncidencia = fechaIncidencia;
        this.estadoIncidencia = estadoIncidencia;
        this.idCliente = idCliente;
        this.idCategoria = idCategoria;
        this.idTecnico = idTecnico;
    }
}
