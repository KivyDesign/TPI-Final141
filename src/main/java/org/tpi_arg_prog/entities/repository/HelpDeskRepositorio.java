package org.tpi_arg_prog.entities.repository;

import org.tpi_arg_prog.entities.HelpDesk;

import java.util.List;
import java.util.Map;

public interface HelpDeskRepositorio {

    void agregarHelpDesk(HelpDesk helpDesk);

    void actualizarHelpDesk(HelpDesk helpDesk);

    HelpDesk traerPorId(Long id);

    void eliminarHelpDesk(HelpDesk helpDesk);

    List<HelpDesk> traerTodosHelpDesk();

}
