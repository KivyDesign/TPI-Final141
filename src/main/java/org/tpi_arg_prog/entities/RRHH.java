package org.tpi_arg_prog.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "tbRRHH")
public class RRHH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operador;
    private Long tecnico;
    private int incidenciasResueltas;
    private int incidenciasPendientes;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Especialidad> especialidades = new ArrayList<>();

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "otherEntity")
}
