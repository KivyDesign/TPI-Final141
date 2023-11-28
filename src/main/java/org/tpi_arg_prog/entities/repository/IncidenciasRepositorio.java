package org.tpi_arg_prog.entities.repository;

import org.tpi_arg_prog.entities.Incidencias;

import java.util.List;
import java.util.Map;

public interface IncidenciasRepositorio {

    void agregarIncidencias(Incidencias incidencias);

    void actualizarIncidencias(Incidencias incidencias);

    Incidencias traerPorId(Long id);

    void eliminarIncidencias(Incidencias incidencias);

    List<Incidencias> traerTodosIncidencias();

}
