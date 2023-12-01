package org.tpi_arg_prog.entities.repository;

//import java.time.LocalDate;
//import java.time.ZoneId;
import java.sql.Date;
import java.time.LocalDate;
import org.tpi_arg_prog.entities.Incidencias;
import org.tpi_arg_prog.entities.repository.dao.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import javax.persistence.TemporalType;

import org.tpi_arg_prog.entities.Tecnico;
import java.util.Map;
import java.util.Optional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JpaIncidenciasRepositorio implements IncidenciasRepositorio {

    private DAO dao;

    public JpaIncidenciasRepositorio(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void agregarIncidencias(Incidencias incidencias) {
        System.out.println("\nSalvando el Incidencias en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(incidencias);
            entityManager.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void actualizarIncidencias(Incidencias incidencias) {
        System.out.println("\nActualizando el Incidencias en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(incidencias);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManager.flush();
        }
    }

    @Override
    public Incidencias traerPorId(Long id) {
        System.out.println("\nTrayendo el Incidencias desde la DB");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(Incidencias.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarIncidencias(Incidencias incidencias) {
        System.out.println("\nEliminando el Incidencias en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(incidencias);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Incidencias> traerTodosIncidencias() {

        System.out.println("\nTrayendo el Incidencias desde la DB");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createQuery("SELECT e FROM Incidencias e").getResultList();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Incidencias> traerTodoIncidenciasEntreFechas(LocalDate fecha1, LocalDate fecha2) {
        //2023-11-25 	2023-11-28
        //2023-11-17 	2023-11-20
        System.out.println("\nTrayendo el Incidencias desde la DB entre fechas " + fecha1 + " y " + fecha2);
        EntityManager entityManager = dao.getEntityManager();
        try {
            String jpasql = "SELECT e FROM Incidencias e WHERE e.fechaDeApertura >= :fecha1 AND e.fechaDeCierre <= :fecha2 AND e.resuelto = 1";
            List<Incidencias> incidentes = entityManager.createQuery(jpasql, Incidencias.class)
                    .setParameter("fecha1", fecha1)
                    .setParameter("fecha2", fecha2)
                    .getResultList();
            return incidentes;
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public List<Incidencias> traerTodoIncidenciasEntreNDias(int ndias) {
        //2023-11-25 	2023-11-28
        //2023-11-17 	2023-11-20
        
        LocalDate fecha2 = LocalDate.now();
        LocalDate fecha1 = fecha2.minusDays(ndias);
        
        System.out.println("\nTrayendo las Incidencias desde la DB entre N días " + ndias);
        EntityManager entityManager = dao.getEntityManager();
        try {
            //String jpasql = "SELECT MAX(e.resuelto) e FROM Incidencias e COUNT(e.resuelto) WHERE e.fechaDeApertura >= :fecha1 "
            String jpasql = "SELECT e FROM Incidencias e WHERE e.fechaDeApertura >= :fecha1 "
                    + "AND e.fechaDeCierre <= :fecha2 "
                    + "AND e.resuelto = 1";
            List<Incidencias> incidentes = entityManager.createQuery(jpasql, Incidencias.class)
                    .setParameter("fecha1", fecha1)
                    .setParameter("fecha2", fecha2)
                    .getResultList();
            return incidentes;
        } finally {
            entityManager.close();
        }
    }

//        public Tecnico resueltosporFecha(EEstado estado, LocalDate fecha1, LocalDate fecha2) {
//            List<Incidente> incidentes = repository.obtenerResueltosPorFecha(estado, fecha1, fecha2);
//            Map<Tecnico, Long> resueltos = incidentes.stream().collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));
//            Tecnico tecnicoConMasIncidentes = resueltos.entrySet().stream()
//                    .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
//            return tecnicoConMasIncidentes;
//        }
//
/*
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {
    @Query("SELECT i.tecnico FROM Incidente i WHERE i.estado = 'FINALIZADO' AND i.fechaEstimadaResolucion > :fechaIngreso GROUP BY i.tecnico ORDER BY COUNT(i) DESC")
    List<Tecnico> findTecnicosConMasIncidentesResueltosUltimosNDias(@Param("fechaIngreso") Date fechaIngreso, Pageable pageable);
}

public List<Tecnico> obtenerTecnicosConMasIncidentesResueltosUltimosNDias(int dias) {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -dias);
    Date fecha = cal.getTime();
    return tecnicoRepository.findTecnicosConMasIncidentesResueltosUltimosNDias(fecha, PageRequest.of(0,1));
}

public Tecnico obtenerTecnicoConResolucionMasRapida() {
    Date fechaMasTemprana = null;
    Tecnico tecnicoMasRapido = null;

    List<Incidente> incidentes = incidenteService.obtenerIncidentes();

    for (Incidente incidente : incidentes) {
        Date fechaEstimada = incidente.getFechaEstimadaResolucion();
        if (fechaEstimada != null && (fechaMasTemprana == null || fechaEstimada.before(fechaMasTemprana))) {
            fechaMasTemprana = fechaEstimada; // Actualizar la fecha más temprana
            tecnicoMasRapido = incidente.getTecnico(); // Obtener el técnico asociado al incidente más rápido
        }
    }
    return tecnicoMasRapido; // Devolver el técnico con la resolución más rápida
}

public List<Tecnico> obtenerTecnicosConMasIncidentesEspecialidadResueltosUltimosNDias(int especialidadId, int ultimosNDias) {
    Optional<Especialidad> especialidadOptional = especialidadService.obtenerEspecialidadPorId(especialidadId);
    if (especialidadOptional.isEmpty()) {
        return Collections.emptyList(); // O cualquier otro manejo de error que necesites
    }
    Especialidad especialidad = especialidadOptional.get();
    List<Incidente> incidentesResueltos = incidenteService.obtenerIncidentesResueltosPorEspecialidadYDias(Optional.of(especialidad), ultimosNDias);
    Map<Tecnico, Long> mapaIncidentesPorTecnico = incidentesResueltos.stream()
            .collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));

    if (mapaIncidentesPorTecnico.isEmpty()) {
        return Collections.emptyList();
    }
    long maxIncidentes = Collections.max(mapaIncidentesPorTecnico.values());
    List<Tecnico> tecnicosConMasIncidentes = mapaIncidentesPorTecnico.entrySet().stream()
            .filter(entry -> entry.getValue() == maxIncidentes)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    return tecnicosConMasIncidentes;
}
*/
}
