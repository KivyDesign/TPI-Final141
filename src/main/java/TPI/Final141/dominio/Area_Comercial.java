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
public class Area_Comercial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAreaComercial;
    
    @Column
    private Cliente cliente;
    
    @Column
    private String email;

    public Area_Comercial() {
    }

    public Area_Comercial(int idAreaComercial, Cliente cliente, String email) {
        this.idAreaComercial = idAreaComercial;
        this.cliente = cliente;
        this.email = email;
    }

    public Area_Comercial(Cliente cliente, String email) {
        this.cliente = cliente;
        this.email = email;
    }
}
