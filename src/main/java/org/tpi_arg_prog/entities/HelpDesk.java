package org.tpi_arg_prog.entities;

import java.time.LocalDate;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "tbHelpDesk")
public class HelpDesk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idIncidente;
    private Long idCliente;
    private Long idTecnico;
    private LocalDate tiempoEstipuladoParaResolucion;
    private LocalDate tiempoExtraParaResolucion;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Especialidad> especialidades = new ArrayList<>();

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "otherEntity")
}
