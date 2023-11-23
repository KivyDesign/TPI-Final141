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
public class Contrato {
   
    private int idContrato;
    private Cliente cliente;
    private Especializacion especializacion;
    private Double cuotaMensual;

    public Contrato() {
    }

    public Contrato(int idContrato, Cliente cliente, Especializacion especializacion, Double cuotaMensual) {
        this.idContrato = idContrato;
        this.cliente = cliente;
        this.especializacion = especializacion;
        this.cuotaMensual = cuotaMensual;
    }

    public Contrato(Cliente cliente, Especializacion especializacion, Double cuotaMensual) {
        this.cliente = cliente;
        this.especializacion = especializacion;
        this.cuotaMensual = cuotaMensual;
    }
}
