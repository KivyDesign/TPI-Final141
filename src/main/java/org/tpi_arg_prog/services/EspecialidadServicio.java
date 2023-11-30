package org.tpi_arg_prog.services;

import java.util.List;
import org.tpi_arg_prog.entities.Especialidad;
import org.tpi_arg_prog.entities.repository.EspecialidadRepositorio;

public class EspecialidadServicio {
    
private EspecialidadRepositorio especialidadRepositorio;

    public EspecialidadServicio(EspecialidadRepositorio especialidadRepositorio) {
        this.especialidadRepositorio = especialidadRepositorio;
    }

    public void agregarEspecialidad(Especialidad especialidad) {
        especialidadRepositorio.agregarEspecialidad(especialidad);
    }

    public void actualizarEspecialidad(Especialidad especialidad) {
        especialidadRepositorio.actualizarEspecialidad(especialidad);
    }

    public Especialidad traerPorId(Long id) {
        return especialidadRepositorio.traerPorId(id);
    }

    public void eliminarEspecialidad(Especialidad especialidad) {
        especialidadRepositorio.eliminarTecnica(especialidad);
    }

    public List<Especialidad> traerTodosEspecialidads() {
        return especialidadRepositorio.traerTodosEspecialidads();
    }
 
}

