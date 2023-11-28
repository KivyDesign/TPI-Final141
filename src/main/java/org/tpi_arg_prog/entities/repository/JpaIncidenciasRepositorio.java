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
            String jpasql = "SELECT i FROM tbincidencias i WHERE i.FECHADEAPERTURA >= fecha1 AND i.FECHADECIERRE <= fecha2";
            List<Incidencias> incidentes = entityManager.createQuery(jpasql, Incidencias.class)
                    .setParameter("fecha1", fecha1)
                    .setParameter("fecha2", fecha2).getResultList();
            return incidentes;
        } finally {
            entityManager.close();
        }
    }
}
