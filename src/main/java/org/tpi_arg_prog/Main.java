package org.tpi_arg_prog;

import java.time.LocalDate;
import java.util.List;
import org.tpi_arg_prog.entities.repository.dao.DAO;
import org.tpi_arg_prog.entities.repository.dao.JpaDAO;

import org.tpi_arg_prog.entities.Especialidad;
import org.tpi_arg_prog.entities.Tecnico;
import org.tpi_arg_prog.entities.repository.JpaTecnicoRespositorio;
import org.tpi_arg_prog.entities.repository.TecnicoRepositorio;
import org.tpi_arg_prog.services.TecnicoService;

import org.tpi_arg_prog.entities.RRHH;
import org.tpi_arg_prog.entities.repository.JpaRRHHRepositorio;
import org.tpi_arg_prog.entities.repository.RRHHRepositorio;
import org.tpi_arg_prog.services.RRHHServicio;
import org.tpi_arg_prog.entities.Cliente;
import org.tpi_arg_prog.entities.HelpDesk;
import org.tpi_arg_prog.entities.Incidencias;
import org.tpi_arg_prog.entities.repository.ClienteRepositorio;
import org.tpi_arg_prog.entities.repository.HelpDeskRepositorio;
import org.tpi_arg_prog.entities.repository.IncidenciasRepositorio;
import org.tpi_arg_prog.entities.repository.JpaClienteRepositorio;
import org.tpi_arg_prog.entities.repository.JpaHelpDeskRepositorio;
import org.tpi_arg_prog.entities.repository.JpaIncidenciasRepositorio;
import org.tpi_arg_prog.services.ClienteService;
import org.tpi_arg_prog.services.HelpDeskServicio;
import org.tpi_arg_prog.services.IncidenciasServicio;

public class Main {

    static TecnicoService tecnicoService;
    static RRHHServicio rrhhServicio;
    static IncidenciasServicio incidenciasServicio;
    static ClienteService clienteService;
    static HelpDeskServicio helpDeskServicio;

    public static void main(String[] args) {
        /*
         * Entrega 2
         * 
         * En esta segunda iteración nos encargaremos de mapear, mediante
         * anotaciones JPA, nuestras clases implementadas para poder persistir
         * el modelo en una Base de Datos Relacional.
         * Además, comenzaremos con la generación de los repositorios/servicios
         * para que brinden solución a algunos requerimientos planteados.
         * 
         * En particular, en esta entrega se solicita:
         * 
         * 1. Modelado de clases con Mapeo (anotaciones JPA) de entidades para
         *    que las mismas sean persistidas mediante el ORM Hibernate.
         * 2. Repositorios/Servicios que den solución a los requerimientos
         *    planteados:
         *    a. Quién fue el técnico con más incidentes resueltos en los
         *       últimos N días
         *    b. Quién fue el técnico con más incidentes resueltos de una
         *       determinada especialidad en los últimos N días
         *    c. Quién fue el técnico que más rápido resolvió los incidentes
         */

        DAO dao = new JpaDAO();
        IncidenciasRepositorio incidenciasRepositorio = new JpaIncidenciasRepositorio(dao);
        incidenciasServicio = new IncidenciasServicio(incidenciasRepositorio);
        List<Incidencias> incidentesResueltos = incidenciasServicio.traerTodoIncidenciasEntreFechas(LocalDate.parse("2023-10-04"), LocalDate.parse("2023-11-03"));
        if (incidentesResueltos != null) {
            for (Incidencias nuevoIncidencias : incidentesResueltos) {
                System.out.println(
                        "\nResueltos: "
                        + "\n==========================="
                        + "\nid: " + nuevoIncidencias.getId()
                        + "\nTécnico: " + nuevoIncidencias.getTecnico()
                        + "\nCliente: " + nuevoIncidencias.getCliente()
                        + "\nTipo: " + nuevoIncidencias.getTipo()
                        + "\nDescripcion: " + nuevoIncidencias.getDescripcion()
                        + "\nApertura: " + nuevoIncidencias.getFechaDeApertura()
                        + "\nCierre: " + nuevoIncidencias.getFechaDeCierre()
                );
            }

        }
        
//        public List<ReporteIncidencia> listarPorRangoFecha(LocalDate fechaDesde, LocalDate fechaHasta) {

//        EstadoProblema estadoProblema = EstadoProblema.Resuelto;

//        return em.createQuery("from ReporteIncidencia r where r.estadoProblema = :estadoProblema and r.fechaAlta between :fechaDesde and :fechaHasta", ReporteIncidencia.class).setParameter("estadoProblema", estadoProblema).setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).getResultList();

    }
    }
}
