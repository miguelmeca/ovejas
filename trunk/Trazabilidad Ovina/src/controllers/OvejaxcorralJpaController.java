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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Oveja;
import model.Corral;
import model.Ovejaxcorral;

/**
 *
 * @author laura
 */
public class OvejaxcorralJpaController {

    public OvejaxcorralJpaController() {
        emf = Persistence.createEntityManagerFactory("Trazabilidad_OvinaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ovejaxcorral ovejaxcorral) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Oveja oveja = ovejaxcorral.getOveja();
            if (oveja != null) {
                oveja = em.getReference(oveja.getClass(), oveja.getOvejaid());
                ovejaxcorral.setOveja(oveja);
            }
            Corral corral = ovejaxcorral.getCorral();
            if (corral != null) {
                corral = em.getReference(corral.getClass(), corral.getCorralid());
                ovejaxcorral.setCorral(corral);
            }
            em.persist(ovejaxcorral);
            if (oveja != null) {
                oveja.getOvejaxcorralCollection().add(ovejaxcorral);
                oveja = em.merge(oveja);
            }
            if (corral != null) {
                corral.getOvejaxcorralCollection().add(ovejaxcorral);
                corral = em.merge(corral);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ovejaxcorral ovejaxcorral) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ovejaxcorral persistentOvejaxcorral = em.find(Ovejaxcorral.class, ovejaxcorral.getOvejaxcorralid());
            Oveja ovejaOld = persistentOvejaxcorral.getOveja();
            Oveja ovejaNew = ovejaxcorral.getOveja();
            Corral corralOld = persistentOvejaxcorral.getCorral();
            Corral corralNew = ovejaxcorral.getCorral();
            if (ovejaNew != null) {
                ovejaNew = em.getReference(ovejaNew.getClass(), ovejaNew.getOvejaid());
                ovejaxcorral.setOveja(ovejaNew);
            }
            if (corralNew != null) {
                corralNew = em.getReference(corralNew.getClass(), corralNew.getCorralid());
                ovejaxcorral.setCorral(corralNew);
            }
            ovejaxcorral = em.merge(ovejaxcorral);
            if (ovejaOld != null && !ovejaOld.equals(ovejaNew)) {
                ovejaOld.getOvejaxcorralCollection().remove(ovejaxcorral);
                ovejaOld = em.merge(ovejaOld);
            }
            if (ovejaNew != null && !ovejaNew.equals(ovejaOld)) {
                ovejaNew.getOvejaxcorralCollection().add(ovejaxcorral);
                ovejaNew = em.merge(ovejaNew);
            }
            if (corralOld != null && !corralOld.equals(corralNew)) {
                corralOld.getOvejaxcorralCollection().remove(ovejaxcorral);
                corralOld = em.merge(corralOld);
            }
            if (corralNew != null && !corralNew.equals(corralOld)) {
                corralNew.getOvejaxcorralCollection().add(ovejaxcorral);
                corralNew = em.merge(corralNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ovejaxcorral.getOvejaxcorralid();
                if (findOvejaxcorral(id) == null) {
                    throw new NonexistentEntityException("The ovejaxcorral with id " + id + " no longer exists.");
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
            Ovejaxcorral ovejaxcorral;
            try {
                ovejaxcorral = em.getReference(Ovejaxcorral.class, id);
                ovejaxcorral.getOvejaxcorralid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ovejaxcorral with id " + id + " no longer exists.", enfe);
            }
            Oveja oveja = ovejaxcorral.getOveja();
            if (oveja != null) {
                oveja.getOvejaxcorralCollection().remove(ovejaxcorral);
                oveja = em.merge(oveja);
            }
            Corral corral = ovejaxcorral.getCorral();
            if (corral != null) {
                corral.getOvejaxcorralCollection().remove(ovejaxcorral);
                corral = em.merge(corral);
            }
            em.remove(ovejaxcorral);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ovejaxcorral> findOvejaxcorralEntities() {
        return findOvejaxcorralEntities(true, -1, -1);
    }

    public List<Ovejaxcorral> findOvejaxcorralEntities(int maxResults, int firstResult) {
        return findOvejaxcorralEntities(false, maxResults, firstResult);
    }

    private List<Ovejaxcorral> findOvejaxcorralEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ovejaxcorral.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ovejaxcorral findOvejaxcorral(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ovejaxcorral.class, id);
        } finally {
            em.close();
        }
    }

    public int getOvejaxcorralCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ovejaxcorral> rt = cq.from(Ovejaxcorral.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
