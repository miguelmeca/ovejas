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
import model.Historialxovejaxcorral;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author laura
 */
public class CorralJpaController {

    public CorralJpaController() {
        emf = Persistence.createEntityManagerFactory("REEMPLAZARPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Corral corral) {
        if (corral.getHistorialxovejaxcorralCollection() == null) {
            corral.setHistorialxovejaxcorralCollection(new ArrayList<Historialxovejaxcorral>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Historialxovejaxcorral> attachedHistorialxovejaxcorralCollection = new ArrayList<Historialxovejaxcorral>();
            for (Historialxovejaxcorral historialxovejaxcorralCollectionHistorialxovejaxcorralToAttach : corral.getHistorialxovejaxcorralCollection()) {
                historialxovejaxcorralCollectionHistorialxovejaxcorralToAttach = em.getReference(historialxovejaxcorralCollectionHistorialxovejaxcorralToAttach.getClass(), historialxovejaxcorralCollectionHistorialxovejaxcorralToAttach.getHistorialxovejaxcorralid());
                attachedHistorialxovejaxcorralCollection.add(historialxovejaxcorralCollectionHistorialxovejaxcorralToAttach);
            }
            corral.setHistorialxovejaxcorralCollection(attachedHistorialxovejaxcorralCollection);
            em.persist(corral);
            for (Historialxovejaxcorral historialxovejaxcorralCollectionHistorialxovejaxcorral : corral.getHistorialxovejaxcorralCollection()) {
                Corral oldCorralOfHistorialxovejaxcorralCollectionHistorialxovejaxcorral = historialxovejaxcorralCollectionHistorialxovejaxcorral.getCorral();
                historialxovejaxcorralCollectionHistorialxovejaxcorral.setCorral(corral);
                historialxovejaxcorralCollectionHistorialxovejaxcorral = em.merge(historialxovejaxcorralCollectionHistorialxovejaxcorral);
                if (oldCorralOfHistorialxovejaxcorralCollectionHistorialxovejaxcorral != null) {
                    oldCorralOfHistorialxovejaxcorralCollectionHistorialxovejaxcorral.getHistorialxovejaxcorralCollection().remove(historialxovejaxcorralCollectionHistorialxovejaxcorral);
                    oldCorralOfHistorialxovejaxcorralCollectionHistorialxovejaxcorral = em.merge(oldCorralOfHistorialxovejaxcorralCollectionHistorialxovejaxcorral);
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
            Collection<Historialxovejaxcorral> historialxovejaxcorralCollectionOld = persistentCorral.getHistorialxovejaxcorralCollection();
            Collection<Historialxovejaxcorral> historialxovejaxcorralCollectionNew = corral.getHistorialxovejaxcorralCollection();
            List<String> illegalOrphanMessages = null;
            for (Historialxovejaxcorral historialxovejaxcorralCollectionOldHistorialxovejaxcorral : historialxovejaxcorralCollectionOld) {
                if (!historialxovejaxcorralCollectionNew.contains(historialxovejaxcorralCollectionOldHistorialxovejaxcorral)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Historialxovejaxcorral " + historialxovejaxcorralCollectionOldHistorialxovejaxcorral + " since its corral field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Historialxovejaxcorral> attachedHistorialxovejaxcorralCollectionNew = new ArrayList<Historialxovejaxcorral>();
            for (Historialxovejaxcorral historialxovejaxcorralCollectionNewHistorialxovejaxcorralToAttach : historialxovejaxcorralCollectionNew) {
                historialxovejaxcorralCollectionNewHistorialxovejaxcorralToAttach = em.getReference(historialxovejaxcorralCollectionNewHistorialxovejaxcorralToAttach.getClass(), historialxovejaxcorralCollectionNewHistorialxovejaxcorralToAttach.getHistorialxovejaxcorralid());
                attachedHistorialxovejaxcorralCollectionNew.add(historialxovejaxcorralCollectionNewHistorialxovejaxcorralToAttach);
            }
            historialxovejaxcorralCollectionNew = attachedHistorialxovejaxcorralCollectionNew;
            corral.setHistorialxovejaxcorralCollection(historialxovejaxcorralCollectionNew);
            corral = em.merge(corral);
            for (Historialxovejaxcorral historialxovejaxcorralCollectionNewHistorialxovejaxcorral : historialxovejaxcorralCollectionNew) {
                if (!historialxovejaxcorralCollectionOld.contains(historialxovejaxcorralCollectionNewHistorialxovejaxcorral)) {
                    Corral oldCorralOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral = historialxovejaxcorralCollectionNewHistorialxovejaxcorral.getCorral();
                    historialxovejaxcorralCollectionNewHistorialxovejaxcorral.setCorral(corral);
                    historialxovejaxcorralCollectionNewHistorialxovejaxcorral = em.merge(historialxovejaxcorralCollectionNewHistorialxovejaxcorral);
                    if (oldCorralOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral != null && !oldCorralOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral.equals(corral)) {
                        oldCorralOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral.getHistorialxovejaxcorralCollection().remove(historialxovejaxcorralCollectionNewHistorialxovejaxcorral);
                        oldCorralOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral = em.merge(oldCorralOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral);
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
            Collection<Historialxovejaxcorral> historialxovejaxcorralCollectionOrphanCheck = corral.getHistorialxovejaxcorralCollection();
            for (Historialxovejaxcorral historialxovejaxcorralCollectionOrphanCheckHistorialxovejaxcorral : historialxovejaxcorralCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Corral (" + corral + ") cannot be destroyed since the Historialxovejaxcorral " + historialxovejaxcorralCollectionOrphanCheckHistorialxovejaxcorral + " in its historialxovejaxcorralCollection field has a non-nullable corral field.");
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

    public List<Corral> findTodosCorralesMenosUno(int corralid) {
        EntityManager em = getEntityManager();
        try{
            Query q  = em.createQuery("select object(o) from Corral as o where corralid <> " + corralid);

            return q.getResultList();
        } finally {
            em.close();
        }
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

    public List<Corral> findCorral(String nombre) {
        EntityManager em = getEntityManager();
        try{
            Query q  = em.createQuery("select object(o) from Corral as o where corralnombre like ('" + nombre + "')");
            return q.getResultList();
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
