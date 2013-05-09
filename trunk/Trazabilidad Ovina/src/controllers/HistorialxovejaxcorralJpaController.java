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
import model.Historialxovejaxcorral;
import model.Oveja;
import model.Corral;

/**
 *
 * @author laura
 */
public class HistorialxovejaxcorralJpaController {

    public HistorialxovejaxcorralJpaController() {
        emf = Persistence.createEntityManagerFactory("REEMPLAZARPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Historialxovejaxcorral historialxovejaxcorral) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Oveja oveja = historialxovejaxcorral.getOveja();
            if (oveja != null) {
                oveja = em.getReference(oveja.getClass(), oveja.getOvejaid());
                historialxovejaxcorral.setOveja(oveja);
            }
            Corral corral = historialxovejaxcorral.getCorral();
            if (corral != null) {
                corral = em.getReference(corral.getClass(), corral.getCorralid());
                historialxovejaxcorral.setCorral(corral);
            }
            em.persist(historialxovejaxcorral);
            if (oveja != null) {
                oveja.getHistorialxovejaxcorralCollection().add(historialxovejaxcorral);
                oveja = em.merge(oveja);
            }
            if (corral != null) {
                corral.getHistorialxovejaxcorralCollection().add(historialxovejaxcorral);
                corral = em.merge(corral);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Historialxovejaxcorral historialxovejaxcorral) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Historialxovejaxcorral persistentHistorialxovejaxcorral = em.find(Historialxovejaxcorral.class, historialxovejaxcorral.getHistorialxovejaxcorralid());
            Oveja ovejaOld = persistentHistorialxovejaxcorral.getOveja();
            Oveja ovejaNew = historialxovejaxcorral.getOveja();
            Corral corralOld = persistentHistorialxovejaxcorral.getCorral();
            Corral corralNew = historialxovejaxcorral.getCorral();
            if (ovejaNew != null) {
                ovejaNew = em.getReference(ovejaNew.getClass(), ovejaNew.getOvejaid());
                historialxovejaxcorral.setOveja(ovejaNew);
            }
            if (corralNew != null) {
                corralNew = em.getReference(corralNew.getClass(), corralNew.getCorralid());
                historialxovejaxcorral.setCorral(corralNew);
            }
            historialxovejaxcorral = em.merge(historialxovejaxcorral);
            if (ovejaOld != null && !ovejaOld.equals(ovejaNew)) {
                ovejaOld.getHistorialxovejaxcorralCollection().remove(historialxovejaxcorral);
                ovejaOld = em.merge(ovejaOld);
            }
            if (ovejaNew != null && !ovejaNew.equals(ovejaOld)) {
                ovejaNew.getHistorialxovejaxcorralCollection().add(historialxovejaxcorral);
                ovejaNew = em.merge(ovejaNew);
            }
            if (corralOld != null && !corralOld.equals(corralNew)) {
                corralOld.getHistorialxovejaxcorralCollection().remove(historialxovejaxcorral);
                corralOld = em.merge(corralOld);
            }
            if (corralNew != null && !corralNew.equals(corralOld)) {
                corralNew.getHistorialxovejaxcorralCollection().add(historialxovejaxcorral);
                corralNew = em.merge(corralNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historialxovejaxcorral.getHistorialxovejaxcorralid();
                if (findHistorialxovejaxcorral(id) == null) {
                    throw new NonexistentEntityException("The historialxovejaxcorral with id " + id + " no longer exists.");
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
            Historialxovejaxcorral historialxovejaxcorral;
            try {
                historialxovejaxcorral = em.getReference(Historialxovejaxcorral.class, id);
                historialxovejaxcorral.getHistorialxovejaxcorralid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historialxovejaxcorral with id " + id + " no longer exists.", enfe);
            }
            Oveja oveja = historialxovejaxcorral.getOveja();
            if (oveja != null) {
                oveja.getHistorialxovejaxcorralCollection().remove(historialxovejaxcorral);
                oveja = em.merge(oveja);
            }
            Corral corral = historialxovejaxcorral.getCorral();
            if (corral != null) {
                corral.getHistorialxovejaxcorralCollection().remove(historialxovejaxcorral);
                corral = em.merge(corral);
            }
            em.remove(historialxovejaxcorral);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Historialxovejaxcorral> findHistorialxovejaxcorralEntities() {
        return findHistorialxovejaxcorralEntities(true, -1, -1);
    }

    public List<Historialxovejaxcorral> findHistorialxovejaxcorralEntities(int maxResults, int firstResult) {
        return findHistorialxovejaxcorralEntities(false, maxResults, firstResult);
    }

    private List<Historialxovejaxcorral> findHistorialxovejaxcorralEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Historialxovejaxcorral as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Historialxovejaxcorral findHistorialxovejaxcorral(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Historialxovejaxcorral.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistorialxovejaxcorralCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Historialxovejaxcorral as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
