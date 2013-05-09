/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import controllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import model.Majada;

/**
 *
 * @author laura
 */
public class MajadaJpaController {

    public MajadaJpaController() {
        emf = Persistence.createEntityManagerFactory("REEMPLAZARPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Majada majada) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(majada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Majada majada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            majada = em.merge(majada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = majada.getMajadaid();
                if (findMajada(id) == null) {
                    throw new NonexistentEntityException("The majada with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Majada majada;
            try {
                majada = em.getReference(Majada.class, id);
                majada.getMajadaid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The majada with id " + id + " no longer exists.", enfe);
            }
            em.remove(majada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Majada> findMajadaEntities() {
        return findMajadaEntities(true, -1, -1);
    }

    public List<Majada> findMajadaEntities(int maxResults, int firstResult) {
        return findMajadaEntities(false, maxResults, firstResult);
    }

    private List<Majada> findMajadaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Majada as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Majada findMajada(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Majada.class, id);
        } finally {
            em.close();
        }
    }

    public int getMajadaCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Majada as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
