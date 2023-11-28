package org.tpi_arg_prog.services;

import org.tpi_arg_prog.entities.Tecnico;
import org.tpi_arg_prog.entities.repository.TecnicoRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TecnicoService {

    private TecnicoRepositorio tecnicoRepositorio;

    public TecnicoService(TecnicoRepositorio tecnicoRepositorio) {
        this.tecnicoRepositorio = tecnicoRepositorio;
    }

    public void agregarTecnico(Tecnico tecnico) {
        tecnicoRepositorio.agregarTecnico(tecnico);
    }

    public void actualizarTecnico(Tecnico tecnico) {
        tecnicoRepositorio.actualizarTecnico(tecnico);
    }

    public Tecnico traerPorId(Long id) {
        return tecnicoRepositorio.traerPorId(id);
    }

    public void eliminarTecnico(Tecnico tecnico) {
        tecnicoRepositorio.eliminarTecnico(tecnico);
    }

    public List<Tecnico> traerTodosTecnicos() {
        return tecnicoRepositorio.traerTodosTecnicos();
    }

}
