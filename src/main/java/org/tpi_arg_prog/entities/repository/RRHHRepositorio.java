package org.tpi_arg_prog.entities.repository;

import org.tpi_arg_prog.entities.RRHH;

import java.util.List;
import java.util.Map;

public interface RRHHRepositorio {

    void agregarRRHH(RRHH rrhh);

    void actualizarRRHH(RRHH rrhh);

    RRHH traerPorId(Long id);

    void eliminarRRHH(RRHH rrhh);

    List<RRHH> traerTodosRRHH();

}
