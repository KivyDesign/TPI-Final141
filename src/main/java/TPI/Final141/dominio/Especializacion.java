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
public class Especializacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEpecializacion;
    
    @Column
    private Tecnico tecnico;
    
    @Column
    private String especialidad;

    public Especializacion() {
    }

    public Especializacion(int idEpecializacion, Tecnico tecnico, String especialidad) {
        this.idEpecializacion = idEpecializacion;
        this.tecnico = tecnico;
        this.especialidad = especialidad;
    }

    public Especializacion(Tecnico tecnico, String especialidad) {
        this.tecnico = tecnico;
        this.especialidad = especialidad;
    }
}
