package org.tpi_arg_prog.services;

import org.tpi_arg_prog.entities.RRHH;
import org.tpi_arg_prog.entities.repository.RRHHRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RRHHServicio {

    private RRHHRepositorio rrhhRepositorio;

    public RRHHServicio(RRHHRepositorio rrhhRepositorio) {
        this.rrhhRepositorio = rrhhRepositorio;
    }

    public void agregarRRHH(RRHH rrhh) {
        rrhhRepositorio.agregarRRHH(rrhh);
    }

    public void actualizarRRHH(RRHH rrhh) {
        rrhhRepositorio.actualizarRRHH(rrhh);
    }

    public RRHH traerPorId(Long id) {
        return rrhhRepositorio.traerPorId(id);
    }

    public void eliminarRRHH(RRHH rrhh) {
        rrhhRepositorio.eliminarRRHH(rrhh);
    }

    public List<RRHH> traerTodosRRHH() {
        return rrhhRepositorio.traerTodosRRHH();
    }

}
