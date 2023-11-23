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
public class TipoDeProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoDeProblema;
    
    @Column
    private Especializacion especialidad;
    
    @Column
    private int tiempoEstimado;

    public TipoDeProblema() {
    }

    public TipoDeProblema(int idTipoDeProblema, Especializacion especialidad, int tiempoEstimado) {
        this.idTipoDeProblema = idTipoDeProblema;
        this.especialidad = especialidad;
        this.tiempoEstimado = tiempoEstimado;
    }

    public TipoDeProblema(Especializacion especialidad, int tiempoEstimado) {
        this.especialidad = especialidad;
        this.tiempoEstimado = tiempoEstimado;
    }
}

