package org.tpi_arg_prog.entities.repository;

import java.time.LocalDate;
import org.tpi_arg_prog.entities.Incidencias;
import org.tpi_arg_prog.entities.repository.dao.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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

        System.out.println("\nTrayendo el Incidencias desde la DB entre fechas");
        EntityManager entityManager = dao.getEntityManager();
        try {
            String jpasql = "FROM tbincidencias i WHERE i.FECHADEAPERTURA >= :fecha1 AND i.FECHADECIERRE <= :fecha2"
                    +" AND i.resuelto = :estado";
            List<Incidencias> incidentes = entityManager.createQuery(jpasql, Incidencias.class)
                    .setParameter("estado", true)
                    .setParameter("fecha1", fecha1)
                    .setParameter("fecha2", fecha2).getResultList();
            
            return incidentes;
        } finally {
            entityManager.close();
        }
    }
    
//        public List<Incidente> obtenerResueltosPorFecha(EEstado estado, LocalDate fecha1, LocalDate fecha2) {
//            String jpql = "SELECT i FROM Incidente i WHERE i.fechaCreacion>= :fecha1 AND i.fechaCierre <= :fecha2"
//                    + " AND i.estado = :estado";
//            List<Incidente> incidentes = em.createQuery(jpql, Incidente.class)
//                    .setParameter("estado", EEstado.RESUELTO)
//                    .setParameter("fecha1", fecha1).setParameter("fecha2", fecha2).getResultList();
//            return incidentes;
//        }
//        public Tecnico resueltosporFecha(EEstado estado, LocalDate fecha1, LocalDate fecha2) {
//            List<Incidente> incidentes = repository.obtenerResueltosPorFecha(estado, fecha1, fecha2);
//            Map<Tecnico, Long> resueltos = incidentes.stream().collect(Collectors.groupingBy(Incidente::getTecnico, Collectors.counting()));
//            Tecnico tecnicoConMasIncidentes = resueltos.entrySet().stream()
//                    .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
//            return tecnicoConMasIncidentes;
//        }
//        public List<ReporteIncidencia> listarPorRangoFecha(LocalDate fechaDesde, LocalDate fechaHasta) {
//        EstadoProblema estadoProblema = EstadoProblema.Resuelto;
//        return em.createQuery("from ReporteIncidencia r where r.estadoProblema = :estadoProblema and r.fechaAlta between :fechaDesde and :fechaHasta", ReporteIncidencia.class).setParameter("estadoProblema", estadoProblema).setParameter("fechaDesde", fechaDesde).setParameter("fechaHasta", fechaHasta).getResultList();
}
