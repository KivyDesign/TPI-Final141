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
public class HelpDesk {
    private int idMesaDeAyuda;
    private Cliente cliente;
    private TipoDeProblema tipoDeProblema;

    public HelpDesk() {
    }

    public HelpDesk(int idMesaDeAyuda, Cliente cliente, TipoDeProblema tipoDeProblema) {
        this.idMesaDeAyuda = idMesaDeAyuda;
        this.cliente = cliente;
        this.tipoDeProblema = tipoDeProblema;
    }

    public HelpDesk(Cliente cliente, TipoDeProblema tipoDeProblema) {
        this.cliente = cliente;
        this.tipoDeProblema = tipoDeProblema;
    }
}
