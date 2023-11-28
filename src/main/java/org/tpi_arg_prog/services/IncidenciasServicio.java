package org.tpi_arg_prog.services;

import org.tpi_arg_prog.entities.Incidencias;
import org.tpi_arg_prog.entities.repository.IncidenciasRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IncidenciasServicio {

    private IncidenciasRepositorio incidenciasRepositorio;

    public IncidenciasServicio(IncidenciasRepositorio incidenciasRepositorio) {
        this.incidenciasRepositorio = incidenciasRepositorio;
    }

    public void agregarIncidencias(Incidencias incidencias) {
        incidenciasRepositorio.agregarIncidencias(incidencias);
    }

    public void actualizarIncidencias(Incidencias incidencias) {
        incidenciasRepositorio.actualizarIncidencias(incidencias);
    }

    public Incidencias traerPorId(Long id) {
        return incidenciasRepositorio.traerPorId(id);
    }

    public void eliminarIncidencias(Incidencias incidencias) {
        incidenciasRepositorio.eliminarIncidencias(incidencias);
    }

    public List<Incidencias> traerTodosIncidencias() {
        return incidenciasRepositorio.traerTodosIncidencias();
    }

}
