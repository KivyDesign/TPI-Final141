package org.tpi_arg_prog.services;

import org.tpi_arg_prog.entities.HelpDesk;
import org.tpi_arg_prog.entities.repository.HelpDeskRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HelpDeskServicio {

    private HelpDeskRepositorio helpDeskRepositorio;

    public HelpDeskServicio(HelpDeskRepositorio helpDeskRepositorio) {
        this.helpDeskRepositorio = helpDeskRepositorio;
    }

    public void agregarHelpDesk(HelpDesk helpDesk) {
        helpDeskRepositorio.agregarHelpDesk(helpDesk);
    }

    public void actualizarHelpDesk(HelpDesk helpDesk) {
        helpDeskRepositorio.actualizarHelpDesk(helpDesk);
    }

    public HelpDesk traerPorId(Long id) {
        return helpDeskRepositorio.traerPorId(id);
    }

    public void eliminarHelpDesk(HelpDesk helpDesk) {
        helpDeskRepositorio.eliminarHelpDesk(helpDesk);
    }

    public List<HelpDesk> traerTodosHelpDesk() {
        return helpDeskRepositorio.traerTodosHelpDesk();
    }

}
