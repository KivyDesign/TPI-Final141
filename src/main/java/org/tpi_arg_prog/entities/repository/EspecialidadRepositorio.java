package org.tpi_arg_prog.entities.repository;

import org.tpi_arg_prog.entities.Especialidad;

import java.util.List;

public interface EspecialidadRepositorio {

    void agregarEspecialidad(Especialidad especialidad);

    void actualizarEspecialidad(Especialidad especialidad);

    Especialidad traerPorId(Long id);

    void eliminarTecnica(Especialidad especialidad);

    List<Especialidad> traerTodosEspecialidads();

}
