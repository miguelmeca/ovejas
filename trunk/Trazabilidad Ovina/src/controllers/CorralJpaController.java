/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import controllers.exceptions.IllegalOrphanException;
import controllers.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import model.Corral;
import model.Ovejaxcorral;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author laura
 */
public class CorralJpaController {

    public CorralJpaController() {
        emf = Persistence.createEntityManagerFactory("Trazabilidad_OvinaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Corral corral) {
        if (corral.getOvejaxcorralCollection() == null) {
            corral.setOvejaxcorralCollection(new ArrayList<Ovejaxcorral>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Ovejaxcorral> attachedOvejaxcorralCollection = new ArrayList<Ovejaxcorral>();
            for (Ovejaxcorral ovejaxcorralCollectionOvejaxcorralToAttach : corral.getOvejaxcorralCollection()) {
                ovejaxcorralCollectionOvejaxcorralToAttach = em.getReference(ovejaxcorralCollectionOvejaxcorralToAttach.getClass(), ovejaxcorralCollectionOvejaxcorralToAttach.getOvejaxcorralid());
                attachedOvejaxcorralCollection.add(ovejaxcorralCollectionOvejaxcorralToAttach);
            }
            corral.setOvejaxcorralCollection(attachedOvejaxcorralCollection);
            em.persist(corral);
            for (Ovejaxcorral ovejaxcorralCollectionOvejaxcorral : corral.getOvejaxcorralCollection()) {
                Corral oldCorralOfOvejaxcorralCollectionOvejaxcorral = ovejaxcorralCollectionOvejaxcorral.getCorral();
                ovejaxcorralCollectionOvejaxcorral.setCorral(corral);
                ovejaxcorralCollectionOvejaxcorral = em.merge(ovejaxcorralCollectionOvejaxcorral);
                if (oldCorralOfOvejaxcorralCollectionOvejaxcorral != null) {
                    oldCorralOfOvejaxcorralCollectionOvejaxcorral.getOvejaxcorralCollection().remove(ovejaxcorralCollectionOvejaxcorral);
                    oldCorralOfOvejaxcorralCollectionOvejaxcorral = em.merge(oldCorralOfOvejaxcorralCollectionOvejaxcorral);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Corral corral) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Corral persistentCorral = em.find(Corral.class, corral.getCorralid());
            Collection<Ovejaxcorral> ovejaxcorralCollectionOld = persistentCorral.getOvejaxcorralCollection();
            Collection<Ovejaxcorral> ovejaxcorralCollectionNew = corral.getOvejaxcorralCollection();
            List<String> illegalOrphanMessages = null;
            for (Ovejaxcorral ovejaxcorralCollectionOldOvejaxcorral : ovejaxcorralCollectionOld) {
                if (!ovejaxcorralCollectionNew.contains(ovejaxcorralCollectionOldOvejaxcorral)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ovejaxcorral " + ovejaxcorralCollectionOldOvejaxcorral + " since its corral field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Ovejaxcorral> attachedOvejaxcorralCollectionNew = new ArrayList<Ovejaxcorral>();
            for (Ovejaxcorral ovejaxcorralCollectionNewOvejaxcorralToAttach : ovejaxcorralCollectionNew) {
                ovejaxcorralCollectionNewOvejaxcorralToAttach = em.getReference(ovejaxcorralCollectionNewOvejaxcorralToAttach.getClass(), ovejaxcorralCollectionNewOvejaxcorralToAttach.getOvejaxcorralid());
                attachedOvejaxcorralCollectionNew.add(ovejaxcorralCollectionNewOvejaxcorralToAttach);
            }
            ovejaxcorralCollectionNew = attachedOvejaxcorralCollectionNew;
            corral.setOvejaxcorralCollection(ovejaxcorralCollectionNew);
            corral = em.merge(corral);
            for (Ovejaxcorral ovejaxcorralCollectionNewOvejaxcorral : ovejaxcorralCollectionNew) {
                if (!ovejaxcorralCollectionOld.contains(ovejaxcorralCollectionNewOvejaxcorral)) {
                    Corral oldCorralOfOvejaxcorralCollectionNewOvejaxcorral = ovejaxcorralCollectionNewOvejaxcorral.getCorral();
                    ovejaxcorralCollectionNewOvejaxcorral.setCorral(corral);
                    ovejaxcorralCollectionNewOvejaxcorral = em.merge(ovejaxcorralCollectionNewOvejaxcorral);
                    if (oldCorralOfOvejaxcorralCollectionNewOvejaxcorral != null && !oldCorralOfOvejaxcorralCollectionNewOvejaxcorral.equals(corral)) {
                        oldCorralOfOvejaxcorralCollectionNewOvejaxcorral.getOvejaxcorralCollection().remove(ovejaxcorralCollectionNewOvejaxcorral);
                        oldCorralOfOvejaxcorralCollectionNewOvejaxcorral = em.merge(oldCorralOfOvejaxcorralCollectionNewOvejaxcorral);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = corral.getCorralid();
                if (findCorral(id) == null) {
                    throw new NonexistentEntityException("The corral with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Corral corral;
            try {
                corral = em.getReference(Corral.class, id);
                corral.getCorralid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The corral with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ovejaxcorral> ovejaxcorralCollectionOrphanCheck = corral.getOvejaxcorralCollection();
            for (Ovejaxcorral ovejaxcorralCollectionOrphanCheckOvejaxcorral : ovejaxcorralCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Corral (" + corral + ") cannot be destroyed since the Ovejaxcorral " + ovejaxcorralCollectionOrphanCheckOvejaxcorral + " in its ovejaxcorralCollection field has a non-nullable corral field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(corral);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Corral> findCorralEntities() {
        return findCorralEntities(true, -1, -1);
    }

    public List<Corral> findCorralEntities(int maxResults, int firstResult) {
        return findCorralEntities(false, maxResults, firstResult);
    }

    private List<Corral> findCorralEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Corral as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Corral findCorral(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Corral.class, id);
        } finally {
            em.close();
        }
    }

    public int getCorralCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Corral as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
