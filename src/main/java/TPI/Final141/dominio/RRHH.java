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
public class RRHH {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrrhh;
    
    @Column
    private Tecnico tecnico;
    
    @Column
    private Incidencia incidentes;
    
    @Column
    private String reporte;

    public RRHH() {
    }

    public RRHH(int idrrhh, Tecnico tecnico, Incidencia incidentes, String reporte) {
        this.idrrhh = idrrhh;
        this.tecnico = tecnico;
        this.incidentes = incidentes;
        this.reporte = reporte;
    }

    public RRHH(Tecnico tecnico, Incidencia incidentes, String reporte) {
        this.tecnico = tecnico;
        this.incidentes = incidentes;
        this.reporte = reporte;
    }
}
