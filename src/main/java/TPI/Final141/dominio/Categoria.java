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
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategoria;
    
    @Column
    private String descripcionCategoria;

    public Categoria() {
    }

    public Categoria(long idCategoria, String descripcionCategoria) {
        this.idCategoria = idCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public Categoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

}
