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
//import org.tpi_arg_prog.services.EspecialidadServicio;

public class MainDeCargaDeDatos {

    static TecnicoService tecnicoService;
    static RRHHServicio rrhhServicio;
    static IncidenciasServicio incidenciasServicio;
    static ClienteService clienteService;
    static HelpDeskServicio helpDeskServicio;
//    static EspecialidadServicio especialidadServicio;

    public static void main(String[] args) {
        iniciarTecnico();
        iniciarRRHH();
        iniciarClientes();
        iniciarIncidencias();
        iniciarHelpDesk();
    }

    private static void iniciarHelpDesk() {
        DAO dao = new JpaDAO();

        LocalDate hoy = LocalDate.now();

        HelpDeskRepositorio helpDeskRepositorio = new JpaHelpDeskRepositorio(dao);
        helpDeskServicio = new HelpDeskServicio(helpDeskRepositorio);

        Incidencias incidencias1 = incidenciasServicio.traerPorId(1L);
        Incidencias incidencias2 = incidenciasServicio.traerPorId(2L);

        Cliente cliente1 = clienteService.traerPorId(3L);
        Cliente cliente2 = clienteService.traerPorId(2L);

        Tecnico tecnico1 = tecnicoService.traerPorId(2L);
        Tecnico tecnico2 = tecnicoService.traerPorId(1L);

        // Long id, Incidencias incidencias, Cliente cliente, Tecnico tecnico,
        // LocalDate tiempoEstipuladoParaResolucion, LocalDate tiempoExtraParaResolucion
        HelpDesk helpDesk1 = crearHelpDesk(1L, incidencias1, cliente1, tecnico1, LocalDate.parse("2023-11-01"), LocalDate.parse("2023-11-02"));
        helpDeskServicio.agregarHelpDesk(helpDesk1);
        HelpDesk helpDesk2 = crearHelpDesk(2L, incidencias2, cliente2, tecnico2, LocalDate.parse("2023-11-01"), LocalDate.parse("2023-11-02"));
        helpDeskServicio.agregarHelpDesk(helpDesk2);

        // Probando metodo traerPorId(id)
        HelpDesk nuevoHelpDesk = helpDeskServicio.traerPorId(1L);
        System.out.println(
                "\nHelpDesks: "
                + "\n---------------------------"
                + "\nid: " + nuevoHelpDesk.getId()
                + "\nidIncidente: " + nuevoHelpDesk.getIncidencias()
                + "\nidCliente: " + nuevoHelpDesk.getCliente()
                + "\nidTécnico: " + nuevoHelpDesk.getTecnico()
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
                        + "\nidIncidente: " + helpdesk.getIncidencias()
                        + "\nidCliente: " + helpdesk.getCliente()
                        + "\nidTécnico: " + helpdesk.getTecnico()
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

        // Long id, String tipo, String descripcion, LocalDate fechaDeApertura,
        // LocalDate fechaDeCierre,Long tecnico, long cliente
        //2023-11-25 	2023-11-28
        //2023-11-17 	2023-11-20
        LocalDate apertura = LocalDate.parse("2023-11-25");
        LocalDate cierre = LocalDate.parse("2023-11-28");
       
        Incidencias incidencias1 = crearIncidencias(
                1L, "Yerba Mate",
                "¡Se acabo la Yerba pal mate!. ¿Alguien que baje y compre?",
                apertura, cierre, 1L, 1L,true, 4L
        );
        incidenciasServicio.agregarIncidencias(incidencias1);

        apertura = LocalDate.parse("2023-11-17");
        cierre = LocalDate.parse("2023-11-20");
        
        Incidencias incidencias2 = crearIncidencias(
                2L, "Azucar pal Mate",
                "¡Se acabo el Azucar pal mate!. ¿Alguien que baje y compre?",
                apertura, cierre, 2L, 1L,true, 4L
        );
        incidenciasServicio.agregarIncidencias(incidencias2);
        
        apertura = LocalDate.parse("2023-11-19");
        cierre = LocalDate.parse("2023-11-21");
        
        Incidencias incidencias3 = crearIncidencias(
                3L, "Café para la tarde",
                "¡Se acabo el Café!. ¿Alguien que baje y compre?",
                apertura, cierre, 2L, 1L,true, 4L
        );
        incidenciasServicio.agregarIncidencias(incidencias3);

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

        Tecnico tecnico1 = tecnicoService.traerPorId(1L);
        Tecnico tecnico2 = tecnicoService.traerPorId(2L);
        Tecnico tecnico3 = tecnicoService.traerPorId(3L);

        // Long id, String operador,Tecnico tecnico, int resueltas, int pendientes
        RRHH rrhh1 = crearRRHH(1L, "Marilin", tecnico1);
        rrhhServicio.agregarRRHH(rrhh1);
        RRHH rrhh2 = crearRRHH(2L, "Josefina", tecnico2);
        rrhhServicio.agregarRRHH(rrhh2);
        RRHH rrhh3 = crearRRHH(3L, "Luciana", tecnico3);
        rrhhServicio.agregarRRHH(rrhh3);

        // Probando metodo traerPorId(id)
        RRHH nuevoRRHH = rrhhServicio.traerPorId(3L);
        System.out.println(
                "\nRRHH: "
                + "\n==========================="
                + "\nid: " + nuevoRRHH.getId()
                + "\nOperador: " + nuevoRRHH.getOperador()
                + "\nTécnico: " + nuevoRRHH.getTecnico()
        );
    }

    private static void iniciarTecnico() {
        DAO dao = new JpaDAO();

        // Técnico
        TecnicoRepositorio tecnicoRepositorio = new JpaTecnicoRespositorio(dao);
        tecnicoService = new TecnicoService(tecnicoRepositorio);

        // Long id, String nombre, String apellido, int resolucion, especialidades
        Tecnico tecnico1 = crearTecnico(1L, "Gustavo", "Torres", 2, 45, 1);
        tecnicoService.agregarTecnico(tecnico1);
        Tecnico tecnico2 = crearTecnico(2L, "German", "Salvatierra", 4, 34, 2);
        tecnicoService.agregarTecnico(tecnico2);
        Tecnico tecnico3 = crearTecnico(3L, "Guido", "Sosa", 45, 34, 0);
        tecnicoService.agregarTecnico(tecnico3);

        // Probando metodo traerPorId(id)
        Tecnico nuevoTecnico = tecnicoService.traerPorId(1L);
        System.out.println(
                "\nTécnico: "
                + "\n==========================="
                + "\nid: " + nuevoTecnico.getId()
                + "\nNombre: " + nuevoTecnico.getNombre()
                + "\nApellido: " + nuevoTecnico.getApellido()
                + "\nIncidencias Resueltas: " + nuevoTecnico.getIncidenciasResueltas()
                + "\nIncidencias Pendientes: " + nuevoTecnico.getIncidenciasPendientes()
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

    private static HelpDesk crearHelpDesk(Long id, Incidencias idIncidente, Cliente idCliente, Tecnico idTecnico, LocalDate tiempoEstipuladoParaResolucion, LocalDate tiempoExtraParaResolucion) {
        // Long id, Long idIncidente, Long idCliente, Long idTecnico, 
        // LocalDate tiempoEstipuladoParaResolucion, LocalDate tiempoExtraParaResolucion
        HelpDesk helpDesk = new HelpDesk();
        helpDesk.setId(id);
        helpDesk.setIncidencias(idIncidente);
        helpDesk.setCliente(idCliente);
        helpDesk.setTecnico(idTecnico);
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

    private static Incidencias crearIncidencias(Long id, String tipo, String descripcion, LocalDate fechaDeApertura, LocalDate fechaDeCierre, Long tecnico, Long cliente,boolean estado,Long special) {
        // Long id, String tipo, String descripcion, LocalDate fechaDeApertura,
        // LocalDate fechaDeCierre,Long tecnico, Long cliente
        Tecnico nuevoTecnico = tecnicoService.traerPorId(tecnico);
        Cliente nuevoCliente = clienteService.traerPorId(cliente);
//        Especialidad nuevaEspecialidad= especialidadServicio.traerPorId(especialidad);
        Incidencias incidencias = new Incidencias();
        incidencias.setId(id);
        incidencias.setTecnico(nuevoTecnico);
        incidencias.setCliente(nuevoCliente);
        incidencias.setTipo(tipo);
        incidencias.setDescripcion(descripcion);
        incidencias.setFechaDeApertura(fechaDeApertura);
        incidencias.setFechaDeCierre(fechaDeCierre);
        incidencias.setResuelto(estado);
        incidencias.setSpecial(special);
        
        return incidencias;
    }

    private static RRHH crearRRHH(Long id, String operador, Tecnico tecnico) {
        // Long id, String operador, Long idTecnico, int resueltas, int pendientes
        RRHH rrhh = new RRHH();
        rrhh.setId(id);
        rrhh.setOperador(operador);
        rrhh.setTecnico(tecnico);

        return rrhh;
    }

    private static Tecnico crearTecnico(Long id, String nombre, String apellido, int resueltas, int pendientes, int resolucion) {
        Tecnico tecnico = new Tecnico();
        tecnico.setId(id);
        tecnico.setNombre(nombre);
        tecnico.setApellido(apellido);
        tecnico.setIncidenciasResueltas(resueltas);
        tecnico.setIncidenciasPendientes(pendientes);
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
