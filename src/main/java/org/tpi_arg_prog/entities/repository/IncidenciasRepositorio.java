package org.tpi_arg_prog.entities.repository;

import java.time.LocalDate;
import org.tpi_arg_prog.entities.Incidencias;

import java.util.List;
import java.util.Map;

public interface IncidenciasRepositorio {

    void agregarIncidencias(Incidencias incidencias);

    void actualizarIncidencias(Incidencias incidencias);

    Incidencias traerPorId(Long id);

    void eliminarIncidencias(Incidencias incidencias);

    List<Incidencias> traerTodosIncidencias();

    List<Incidencias> traerTodoIncidenciasEntreFechas(LocalDate fecha1, LocalDate fecha2);

    List<Incidencias> traerTodoIncidenciasEntreNDias(int ndias);

}
