package org.tpi_arg_prog.entities.repository;

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
}
