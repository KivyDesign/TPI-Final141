package org.tpi_arg_prog.entities.repository;

import org.tpi_arg_prog.entities.Especialidad;
import org.tpi_arg_prog.entities.repository.dao.DAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.List;

public class JpaEspecialidadRepositorio implements EspecialidadRepositorio {

    private DAO dao;

    public JpaEspecialidadRepositorio(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void agregarEspecialidad(Especialidad especialidad) {

    }

    @Override
    public void actualizarEspecialidad(Especialidad especialidad) {

    }

    @Override
    public Especialidad traerPorId(Long id) {
        return null;
    }

    @Override
    public void eliminarTecnica(Especialidad especialidad) {

    }

    @Override
    public List<Especialidad> traerTodosEspecialidads() {
        return null;
    }
}
