package org.tpi_arg_prog.entities.repository;

import org.tpi_arg_prog.entities.HelpDesk;
import org.tpi_arg_prog.entities.repository.dao.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaHelpDeskRepositorio implements HelpDeskRepositorio {

    private DAO dao;

    public JpaHelpDeskRepositorio(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void agregarHelpDesk(HelpDesk helpDesk) {
        System.out.println("\nSalvando el HelpDesk en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(helpDesk);
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
    public void actualizarHelpDesk(HelpDesk helpDesk) {
        System.out.println("\nActualizando el HelpDesk en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(helpDesk);
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
    public HelpDesk traerPorId(Long id) {
        System.out.println("\nTrayendo el HelpDesk desde la DB");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(HelpDesk.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarHelpDesk(HelpDesk helpDesk) {
        System.out.println("\nEliminando el HelpDesk en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(helpDesk);
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
    public List<HelpDesk> traerTodosHelpDesk() {

        System.out.println("\nTrayendo el HelpDesk desde la DB");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createQuery("SELECT e FROM HelpDesk e").getResultList();
        } finally {
            entityManager.close();
        }
    }
}
