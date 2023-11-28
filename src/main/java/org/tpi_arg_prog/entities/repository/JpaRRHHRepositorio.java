package org.tpi_arg_prog.entities.repository;

import org.tpi_arg_prog.entities.RRHH;
import org.tpi_arg_prog.entities.repository.dao.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaRRHHRepositorio implements RRHHRepositorio {

    private DAO dao;

    public JpaRRHHRepositorio(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void agregarRRHH(RRHH rrhh) {
        System.out.println("\nSalvando el RRHH en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(rrhh);
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
    public void actualizarRRHH(RRHH rrhh) {
        System.out.println("\nActualizando el RRHH en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(rrhh);
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
    public RRHH traerPorId(Long id) {
        System.out.println("\nTrayendo el RRHH desde la DB");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(RRHH.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarRRHH(RRHH rrhh) {
        System.out.println("\nEliminando el RRHH en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(rrhh);
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
    public List<RRHH> traerTodosRRHH() {

        System.out.println("\nTrayendo el RRHH desde la DB");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createQuery("SELECT e FROM RRHH e").getResultList();
        } finally {
            entityManager.close();
        }
    }
}
