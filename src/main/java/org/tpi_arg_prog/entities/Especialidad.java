package org.tpi_arg_prog.entities;

import java.util.Set;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbEspecialidad")

public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
//    @ManyToOne(targetEntity = Tecnico.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set<Tecnico> especialidad;
}
