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
public class Tecnico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTecnico;
    
    @Column
    private String nombreApellidoTecnico;
    
    @Column
    private Especializacion especialidad;
    
    @Column
    private String contacto;
    
    @Column
    private int tiempoResolucion;

    public Tecnico() {
    }

    public Tecnico(long idTecnico, String nombreApellidoTecnico, Especializacion especialidad, String contacto, int tiempoResolucion) {
        this.idTecnico = idTecnico;
        this.nombreApellidoTecnico = nombreApellidoTecnico;
        this.especialidad = especialidad;
        this.contacto = contacto;
        this.tiempoResolucion = tiempoResolucion;
    }
}
