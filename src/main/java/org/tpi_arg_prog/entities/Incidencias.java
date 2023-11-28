package org.tpi_arg_prog.entities;

import java.time.LocalDate;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "tbIncidencias")
public class Incidencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String descripcion;
    private LocalDate fechaDeApertura;
    private LocalDate fechaDeCierre;

    @ManyToOne
    @JoinColumn(name = "idTecnico", referencedColumnName = "id")
    private Tecnico tecnico;
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    private Cliente cliente;
}
