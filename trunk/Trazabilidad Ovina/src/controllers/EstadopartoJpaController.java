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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Estadoparto;
import model.Estadopartoxpartoxoveja;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author laura
 */
public class EstadopartoJpaController {

    public EstadopartoJpaController() {
        emf = Persistence.createEntityManagerFactory("Trazabilidad_OvinaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estadoparto estadoparto) {
        if (estadoparto.getEstadopartoxpartoxovejaCollection() == null) {
            estadoparto.setEstadopartoxpartoxovejaCollection(new ArrayList<Estadopartoxpartoxoveja>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Estadopartoxpartoxoveja> attachedEstadopartoxpartoxovejaCollection = new ArrayList<Estadopartoxpartoxoveja>();
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach : estadoparto.getEstadopartoxpartoxovejaCollection()) {
                estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach = em.getReference(estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach.getClass(), estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach.getEstadopartoxpartoxovejaid());
                attachedEstadopartoxpartoxovejaCollection.add(estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach);
            }
            estadoparto.setEstadopartoxpartoxovejaCollection(attachedEstadopartoxpartoxovejaCollection);
            em.persist(estadoparto);
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja : estadoparto.getEstadopartoxpartoxovejaCollection()) {
                Estadoparto oldEstadopartoOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja = estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja.getEstadoparto();
                estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja.setEstadoparto(estadoparto);
                estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja = em.merge(estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja);
                if (oldEstadopartoOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja != null) {
                    oldEstadopartoOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja);
                    oldEstadopartoOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja = em.merge(oldEstadopartoOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estadoparto estadoparto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estadoparto persistentEstadoparto = em.find(Estadoparto.class, estadoparto.getEstadopartoid());
            Collection<Estadopartoxpartoxoveja> estadopartoxpartoxovejaCollectionOld = persistentEstadoparto.getEstadopartoxpartoxovejaCollection();
            Collection<Estadopartoxpartoxoveja> estadopartoxpartoxovejaCollectionNew = estadoparto.getEstadopartoxpartoxovejaCollection();
            List<String> illegalOrphanMessages = null;
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionOldEstadopartoxpartoxoveja : estadopartoxpartoxovejaCollectionOld) {
                if (!estadopartoxpartoxovejaCollectionNew.contains(estadopartoxpartoxovejaCollectionOldEstadopartoxpartoxoveja)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Estadopartoxpartoxoveja " + estadopartoxpartoxovejaCollectionOldEstadopartoxpartoxoveja + " since its estadoparto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Estadopartoxpartoxoveja> attachedEstadopartoxpartoxovejaCollectionNew = new ArrayList<Estadopartoxpartoxoveja>();
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach : estadopartoxpartoxovejaCollectionNew) {
                estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach = em.getReference(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach.getClass(), estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach.getEstadopartoxpartoxovejaid());
                attachedEstadopartoxpartoxovejaCollectionNew.add(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach);
            }
            estadopartoxpartoxovejaCollectionNew = attachedEstadopartoxpartoxovejaCollectionNew;
            estadoparto.setEstadopartoxpartoxovejaCollection(estadopartoxpartoxovejaCollectionNew);
            estadoparto = em.merge(estadoparto);
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja : estadopartoxpartoxovejaCollectionNew) {
                if (!estadopartoxpartoxovejaCollectionOld.contains(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja)) {
                    Estadoparto oldEstadopartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja = estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.getEstadoparto();
                    estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.setEstadoparto(estadoparto);
                    estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja = em.merge(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja);
                    if (oldEstadopartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja != null && !oldEstadopartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.equals(estadoparto)) {
                        oldEstadopartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja);
                        oldEstadopartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja = em.merge(oldEstadopartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estadoparto.getEstadopartoid();
                if (findEstadoparto(id) == null) {
                    throw new NonexistentEntityException("The estadoparto with id " + id + " no longer exists.");
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
            Estadoparto estadoparto;
            try {
                estadoparto = em.getReference(Estadoparto.class, id);
                estadoparto.getEstadopartoid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadoparto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Estadopartoxpartoxoveja> estadopartoxpartoxovejaCollectionOrphanCheck = estadoparto.getEstadopartoxpartoxovejaCollection();
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionOrphanCheckEstadopartoxpartoxoveja : estadopartoxpartoxovejaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estadoparto (" + estadoparto + ") cannot be destroyed since the Estadopartoxpartoxoveja " + estadopartoxpartoxovejaCollectionOrphanCheckEstadopartoxpartoxoveja + " in its estadopartoxpartoxovejaCollection field has a non-nullable estadoparto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(estadoparto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estadoparto> findEstadopartoEntities() {
        return findEstadopartoEntities(true, -1, -1);
    }

    public List<Estadoparto> findEstadopartoEntities(int maxResults, int firstResult) {
        return findEstadopartoEntities(false, maxResults, firstResult);
    }

    private List<Estadoparto> findEstadopartoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estadoparto.class));
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

    public Estadoparto findEstadoparto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estadoparto.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadopartoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estadoparto> rt = cq.from(Estadoparto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
