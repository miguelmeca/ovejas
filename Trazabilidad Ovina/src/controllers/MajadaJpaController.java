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
import model.Majada;
import model.Oveja;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author laura
 */
public class MajadaJpaController {

    public MajadaJpaController() {
        emf = Persistence.createEntityManagerFactory("Trazabilidad_OvinaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Majada majada) {
        if (majada.getOvejaCollection() == null) {
            majada.setOvejaCollection(new ArrayList<Oveja>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Oveja> attachedOvejaCollection = new ArrayList<Oveja>();
            for (Oveja ovejaCollectionOvejaToAttach : majada.getOvejaCollection()) {
                ovejaCollectionOvejaToAttach = em.getReference(ovejaCollectionOvejaToAttach.getClass(), ovejaCollectionOvejaToAttach.getOvejaid());
                attachedOvejaCollection.add(ovejaCollectionOvejaToAttach);
            }
            majada.setOvejaCollection(attachedOvejaCollection);
            em.persist(majada);
            for (Oveja ovejaCollectionOveja : majada.getOvejaCollection()) {
                Majada oldMajadaOfOvejaCollectionOveja = ovejaCollectionOveja.getMajada();
                ovejaCollectionOveja.setMajada(majada);
                ovejaCollectionOveja = em.merge(ovejaCollectionOveja);
                if (oldMajadaOfOvejaCollectionOveja != null) {
                    oldMajadaOfOvejaCollectionOveja.getOvejaCollection().remove(ovejaCollectionOveja);
                    oldMajadaOfOvejaCollectionOveja = em.merge(oldMajadaOfOvejaCollectionOveja);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Majada majada) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Majada persistentMajada = em.find(Majada.class, majada.getMajadaid());
            Collection<Oveja> ovejaCollectionOld = persistentMajada.getOvejaCollection();
            Collection<Oveja> ovejaCollectionNew = majada.getOvejaCollection();
            List<String> illegalOrphanMessages = null;
            for (Oveja ovejaCollectionOldOveja : ovejaCollectionOld) {
                if (!ovejaCollectionNew.contains(ovejaCollectionOldOveja)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Oveja " + ovejaCollectionOldOveja + " since its majada field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Oveja> attachedOvejaCollectionNew = new ArrayList<Oveja>();
            for (Oveja ovejaCollectionNewOvejaToAttach : ovejaCollectionNew) {
                ovejaCollectionNewOvejaToAttach = em.getReference(ovejaCollectionNewOvejaToAttach.getClass(), ovejaCollectionNewOvejaToAttach.getOvejaid());
                attachedOvejaCollectionNew.add(ovejaCollectionNewOvejaToAttach);
            }
            ovejaCollectionNew = attachedOvejaCollectionNew;
            majada.setOvejaCollection(ovejaCollectionNew);
            majada = em.merge(majada);
            for (Oveja ovejaCollectionNewOveja : ovejaCollectionNew) {
                if (!ovejaCollectionOld.contains(ovejaCollectionNewOveja)) {
                    Majada oldMajadaOfOvejaCollectionNewOveja = ovejaCollectionNewOveja.getMajada();
                    ovejaCollectionNewOveja.setMajada(majada);
                    ovejaCollectionNewOveja = em.merge(ovejaCollectionNewOveja);
                    if (oldMajadaOfOvejaCollectionNewOveja != null && !oldMajadaOfOvejaCollectionNewOveja.equals(majada)) {
                        oldMajadaOfOvejaCollectionNewOveja.getOvejaCollection().remove(ovejaCollectionNewOveja);
                        oldMajadaOfOvejaCollectionNewOveja = em.merge(oldMajadaOfOvejaCollectionNewOveja);
                    }
                }
            }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Collection<Oveja> ovejaCollectionOrphanCheck = majada.getOvejaCollection();
            for (Oveja ovejaCollectionOrphanCheckOveja : ovejaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Majada (" + majada + ") cannot be destroyed since the Oveja " + ovejaCollectionOrphanCheckOveja + " in its ovejaCollection field has a non-nullable majada field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
