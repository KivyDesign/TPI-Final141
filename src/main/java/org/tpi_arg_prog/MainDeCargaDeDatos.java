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

public class MainDeCargaDeDatos {

    static TecnicoService tecnicoService;
    static RRHHServicio rrhhServicio;
    static IncidenciasServicio incidenciasServicio;
    static ClienteService clienteService;
    static HelpDeskServicio helpDeskServicio;

    public static void main(String[] args) {
        iniciarTecnico();
        iniciarRRHH();
        iniciarClientes();
        iniciarHelpDesk();
        iniciarIncidencias();
    }

    private static void iniciarHelpDesk() {
        DAO dao = new JpaDAO();

        LocalDate hoy = LocalDate.now();

        HelpDeskRepositorio helpDeskRepositorio = new JpaHelpDeskRepositorio(dao);
        helpDeskServicio = new HelpDeskServicio(helpDeskRepositorio);

        // Long id, Long idIncidente, Long idCliente, Long idTecnico,
        // LocalDate tiempoEstipuladoParaResolucion, LocalDate tiempoExtraParaResolucion
        HelpDesk helpDesk1 = crearHelpDesk(1L, 2L, 3L, 2L, hoy, hoy);
        helpDeskServicio.agregarHelpDesk(helpDesk1);
        HelpDesk helpDesk2 = crearHelpDesk(2L, 3L, 2L, 1L, hoy, hoy);
        helpDeskServicio.agregarHelpDesk(helpDesk2);

        // Probando metodo traerPorId(id)
        HelpDesk nuevoHelpDesk = helpDeskServicio.traerPorId(1L);
        System.out.println(
                "\nHelpDesks: "
                + "\n---------------------------"
                + "\nid: " + nuevoHelpDesk.getId()
                + "\nidIncidente: " + nuevoHelpDesk.getIdIncidente()
                + "\nidCliente: " + nuevoHelpDesk.getIdCliente()
                + "\nidTécnico: " + nuevoHelpDesk.getIdTecnico()
                + "\nTiempo estipulado para resolución: " + nuevoHelpDesk.getTiempoEstipuladoParaResolucion()
                + "\nTiempo extra para resolución: " + nuevoHelpDesk.getTiempoExtraParaResolucion()
        );

        // Probando metodo traerTodosHelpDesk()
        List<HelpDesk> lista = helpDeskServicio.traerTodosHelpDesk();
        // Primero verifico que NO este vacia la lista
        if (lista != null) {
            for (HelpDesk helpdesk : lista) {
                System.out.println(
                        "\nHelpDesks: "
                        + "\n---------------------------"
                        + "\nid: " + helpdesk.getId()
                        + "\nidIncidente: " + helpdesk.getIdIncidente()
                        + "\nidCliente: " + helpdesk.getIdCliente()
                        + "\nidTécnico: " + helpdesk.getIdTecnico()
                        + "\nTiempo estipulado para resolución: " + helpdesk.getTiempoEstipuladoParaResolucion()
                        + "\nTiempo extra para resolución: " + helpdesk.getTiempoExtraParaResolucion()
                );
            }
        }
    }

    private static void iniciarClientes() {
        DAO dao = new JpaDAO();

        // Clientes
        ClienteRepositorio clientesRepositorio = new JpaClienteRepositorio(dao);
        clienteService = new ClienteService(clientesRepositorio);

        // Long id, int dni, String nombre, String apellido, String direccion, String email
        Cliente cliente1 = crearCliente(1L, 11000001, "Lucia", "Alborada", "Alborada S.A.", "albarada@gmail.com");
        clienteService.agregarCliente(cliente1);
        Cliente cliente2 = crearCliente(2L, 22000002, "Jose", "Martines", "Martines S.R.L.", "martinez@gmail.com");
        clienteService.agregarCliente(cliente2);
        Cliente cliente3 = crearCliente(3L, 33000003, "John", "Smith", "Smith Co. Unlimited", "smith@gmail.com");
        clienteService.agregarCliente(cliente3);

        // Probando metodo traerPorId(id)
        Cliente nuevoClientes = clienteService.traerPorId(3L);
        System.out.println(
                "\nClientes: "
                + "\n==========================="
                + "\nid: " + nuevoClientes.getId()
                + "\nDNI: " + nuevoClientes.getDni()
                + "\nNombre: " + nuevoClientes.getNombre()
                + "\nApellido: " + nuevoClientes.getApellido()
                + "\nDirección: " + nuevoClientes.getDireccion()
                + "\nEmail: " + nuevoClientes.getEmail()
        );

        // Probando metodo traerTodosClientes()
        List<Cliente> lista = clienteService.traerTodosClientes();
        // Primero verifico que NO este vacia la lista
        if (lista != null) {
            for (Cliente cliente : lista) {
                System.out.println(
                        "\nCliente: "
                        + "\n----------------------------"
                        + "\nid: " + cliente.getId()
                        + "\nDNI: " + cliente.getDni()
                        + "\nNombre: " + cliente.getNombre()
                        + "\nApellido: " + cliente.getApellido()
                        + "\nDirección: " + cliente.getDireccion()
                        + "\nEmail: " + cliente.getEmail()
                );
            }
            System.out.println("================================================");
        }
    }

    private static void iniciarIncidencias() {
        DAO dao = new JpaDAO();

        // Incidencias
        IncidenciasRepositorio incidenciasRepositorio = new JpaIncidenciasRepositorio(dao);
        incidenciasServicio = new IncidenciasServicio(incidenciasRepositorio);

        // incidenciasServicio
        Incidencias incidencias = crearIncidencias();
        incidenciasServicio.agregarIncidencias(incidencias);

        // Probando metodo traerPorId(id)
        Incidencias nuevoIncidencias = incidenciasServicio.traerPorId(1L);
        System.out.println(
                "\nIncidencias: "
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

    private static void iniciarRRHH() {
        DAO dao = new JpaDAO();

        // RRHH
        RRHHRepositorio rrhhRepositorio = new JpaRRHHRepositorio(dao);
        rrhhServicio = new RRHHServicio(rrhhRepositorio);

        // Long id, String operador, Long idTecnico, int resueltas, int pendientes
        RRHH rrhh1 = crearRRHH(1L, "Marilin", 1L, 28, 7);
        rrhhServicio.agregarRRHH(rrhh1);
        RRHH rrhh2 = crearRRHH(2L, "Josefina", 2L, 15, 3);
        rrhhServicio.agregarRRHH(rrhh2);
        RRHH rrhh3 = crearRRHH(3L, "Luciana", 3L, 999, 0);
        rrhhServicio.agregarRRHH(rrhh3);

        // Probando metodo traerPorId(id)
        RRHH nuevoRRHH = rrhhServicio.traerPorId(3L);
        System.out.println(
                "\nRRHH: "
                + "\n==========================="
                + "\nid: " + nuevoRRHH.getId()
                + "\nOperador: " + nuevoRRHH.getOperador()
                + "\nTécnico: " + nuevoRRHH.getTecnico()
                + "\nIncidencias Resueltas: " + nuevoRRHH.getIncidenciasResueltas()
                + "\nIncidencias Pendientes: " + nuevoRRHH.getIncidenciasPendientes()
        );
    }

    private static void iniciarTecnico() {
        DAO dao = new JpaDAO();

        // Técnico
        TecnicoRepositorio tecnicoRepositorio = new JpaTecnicoRespositorio(dao);
        tecnicoService = new TecnicoService(tecnicoRepositorio);

        // Long id, String nombre, String apellido, int resolucion, especialidades
        Tecnico tecnico1 = crearTecnico(1L, "Gustavo", "Torres", 19);
        tecnicoService.agregarTecnico(tecnico1);
        Tecnico tecnico2 = crearTecnico(2L, "German", "Salvatierra", 22);
        tecnicoService.agregarTecnico(tecnico2);
        Tecnico tecnico3 = crearTecnico(3L, "Guido", "Sosa", 20);
        tecnicoService.agregarTecnico(tecnico3);

        // Probando metodo traerPorId(id)
        Tecnico nuevoTecnico = tecnicoService.traerPorId(1L);
        System.out.println(
                "\nTécnico: "
                + "\n==========================="
                + "\nid: " + nuevoTecnico.getId()
                + "\nNombre: " + nuevoTecnico.getNombre()
                + "\nApellido: " + nuevoTecnico.getApellido()
                + "\nTiempo de Resolución: " + nuevoTecnico.getTiempoResolucion() + " hs\n"
                + "\nEspecialidades: " + nuevoTecnico.getEspecialidades().subList(0, 2)
        );

        // Probando metodo traerTodosTecnicos()
        List<Tecnico> lista = tecnicoService.traerTodosTecnicos();
        // Primero verifico que NO este vacia la lista
        if (lista != null) {
            for (Tecnico tecnico : lista) {
                System.out.println(
                        "\nCliente: "
                        + "\n----------------------------"
                        + "\nid: " + tecnico.getId()
                        + "\nNombre: " + tecnico.getNombre()
                        + "\nApellido: " + tecnico.getApellido()
                        + "\nTiempo de Resolución: " + tecnico.getTiempoResolucion() + " hs\n"
                        + "\nEspecialidades: " + tecnico.getEspecialidades().subList(0, 2)
                );
            }
            System.out.println("================================================");
        }
    }

    private static HelpDesk crearHelpDesk(Long id, Long idIncidente, Long idCliente, Long idTecnico, LocalDate tiempoEstipuladoParaResolucion, LocalDate tiempoExtraParaResolucion) {
        // Long id, Long idIncidente, Long idCliente, Long idTecnico, 
        // LocalDate tiempoEstipuladoParaResolucion, LocalDate tiempoExtraParaResolucion
        HelpDesk helpDesk = new HelpDesk();
        helpDesk.setId(id);
        helpDesk.setIdIncidente(idIncidente);
        helpDesk.setIdCliente(idCliente);
        helpDesk.setIdTecnico(idTecnico);
        helpDesk.setTiempoEstipuladoParaResolucion(tiempoEstipuladoParaResolucion);
        helpDesk.setTiempoExtraParaResolucion(tiempoExtraParaResolucion);
        return helpDesk;
    }

    private static Cliente crearCliente(Long id, int dni, String nombre, String apellido, String direccion, String email) {
        // Long id, int dni, String nombre, String apellido, String direccion, String email
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setDni(dni);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccion(direccion);
        cliente.setEmail(email);
        return cliente;
    }

    private static Incidencias crearIncidencias() {
        Tecnico nuevoTecnico = tecnicoService.traerPorId(1L);
        Cliente nuevoCliente = clienteService.traerPorId(1L);
        Incidencias incidencias = new Incidencias();
        incidencias.setId(1L);
        incidencias.setTecnico(nuevoTecnico);
        incidencias.setCliente(nuevoCliente);
        incidencias.setTipo("Yerba Mate");
        incidencias.setDescripcion("¡Se acabo la Yerba pal mate!. ¿Alguien que baje y compre?");
        incidencias.setFechaDeApertura(LocalDate.EPOCH);
        incidencias.setFechaDeCierre(LocalDate.EPOCH);
        return incidencias;
    }

    private static RRHH crearRRHH(Long id, String operador, Long idTecnico, int resueltas, int pendientes) {
        // Long id, String operador, Long idTecnico, int resueltas, int pendientes
        RRHH rrhh = new RRHH();
        rrhh.setId(id);
        rrhh.setOperador(operador);
        rrhh.setTecnico(idTecnico);
        rrhh.setIncidenciasResueltas(resueltas);
        rrhh.setIncidenciasPendientes(pendientes);
        return rrhh;
    }

    private static Tecnico crearTecnico(Long id, String nombre, String apellido, int resolucion) {
        Tecnico tecnico = new Tecnico();
        tecnico.setId(id);
        tecnico.setNombre(nombre);
        tecnico.setApellido(apellido);
        tecnico.setTiempoResolucion(resolucion);
        tecnico.getEspecialidades().add(crearEspecialidad(1L, "Informatico"));
        tecnico.getEspecialidades().add(crearEspecialidad(2L, "Fisico"));
        return tecnico;
    }

    private static Especialidad crearEspecialidad(Long id, String nombre) {
        Especialidad especialidad = new Especialidad();
        especialidad.setId(id);
        especialidad.setNombre(nombre);
        return especialidad;
    }
}
