package org.tpi_arg_prog.entities.repository;

import org.tpi_arg_prog.entities.Tecnico;
import org.tpi_arg_prog.entities.repository.dao.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaTecnicoRespositorio implements TecnicoRepositorio {

    private DAO dao;

    public JpaTecnicoRespositorio(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void agregarTecnico(Tecnico tecnico) {
        System.out.println(
                "\nSalvando el técnico en la DB"
                + "\n================="
        );
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(tecnico);
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
    public void actualizarTecnico(Tecnico tecnico) {
        System.out.println("\nActualizando el tecnico en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(tecnico);
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
    public Tecnico traerPorId(Long id) {
        System.out.println("\nTrayendo el técnico desde la DB");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(Tecnico.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarTecnico(Tecnico tecnico) {
        System.out.println("\nEliminando el tecnico en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(tecnico);
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
    public List<Tecnico> traerTodosTecnicos() {

        System.out.println("\nTrayendo el tecnico desde la DB");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createQuery("SELECT e FROM Tecnico e").getResultList();
        } finally {
            entityManager.close();
        }
    }
}
