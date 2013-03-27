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
import model.Preniez;
import model.Servicio;
import model.Parto;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author laura
 */
public class PreniezJpaController {

    public PreniezJpaController() {
        emf = Persistence.createEntityManagerFactory("Trazabilidad_OvinaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Preniez preniez) {
        if (preniez.getPartoCollection() == null) {
            preniez.setPartoCollection(new ArrayList<Parto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio servicio = preniez.getServicio();
            if (servicio != null) {
                servicio = em.getReference(servicio.getClass(), servicio.getServicioid());
                preniez.setServicio(servicio);
            }
            Collection<Parto> attachedPartoCollection = new ArrayList<Parto>();
            for (Parto partoCollectionPartoToAttach : preniez.getPartoCollection()) {
                partoCollectionPartoToAttach = em.getReference(partoCollectionPartoToAttach.getClass(), partoCollectionPartoToAttach.getPartoid());
                attachedPartoCollection.add(partoCollectionPartoToAttach);
            }
            preniez.setPartoCollection(attachedPartoCollection);
            em.persist(preniez);
            if (servicio != null) {
                servicio.getPreniezCollection().add(preniez);
                servicio = em.merge(servicio);
            }
            for (Parto partoCollectionParto : preniez.getPartoCollection()) {
                Preniez oldPreniezOfPartoCollectionParto = partoCollectionParto.getPreniez();
                partoCollectionParto.setPreniez(preniez);
                partoCollectionParto = em.merge(partoCollectionParto);
                if (oldPreniezOfPartoCollectionParto != null) {
                    oldPreniezOfPartoCollectionParto.getPartoCollection().remove(partoCollectionParto);
                    oldPreniezOfPartoCollectionParto = em.merge(oldPreniezOfPartoCollectionParto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Preniez preniez) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Preniez persistentPreniez = em.find(Preniez.class, preniez.getPreniezid());
            Servicio servicioOld = persistentPreniez.getServicio();
            Servicio servicioNew = preniez.getServicio();
            Collection<Parto> partoCollectionOld = persistentPreniez.getPartoCollection();
            Collection<Parto> partoCollectionNew = preniez.getPartoCollection();
            List<String> illegalOrphanMessages = null;
            for (Parto partoCollectionOldParto : partoCollectionOld) {
                if (!partoCollectionNew.contains(partoCollectionOldParto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Parto " + partoCollectionOldParto + " since its preniez field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (servicioNew != null) {
                servicioNew = em.getReference(servicioNew.getClass(), servicioNew.getServicioid());
                preniez.setServicio(servicioNew);
            }
            Collection<Parto> attachedPartoCollectionNew = new ArrayList<Parto>();
            for (Parto partoCollectionNewPartoToAttach : partoCollectionNew) {
                partoCollectionNewPartoToAttach = em.getReference(partoCollectionNewPartoToAttach.getClass(), partoCollectionNewPartoToAttach.getPartoid());
                attachedPartoCollectionNew.add(partoCollectionNewPartoToAttach);
            }
            partoCollectionNew = attachedPartoCollectionNew;
            preniez.setPartoCollection(partoCollectionNew);
            preniez = em.merge(preniez);
            if (servicioOld != null && !servicioOld.equals(servicioNew)) {
                servicioOld.getPreniezCollection().remove(preniez);
                servicioOld = em.merge(servicioOld);
            }
            if (servicioNew != null && !servicioNew.equals(servicioOld)) {
                servicioNew.getPreniezCollection().add(preniez);
                servicioNew = em.merge(servicioNew);
            }
            for (Parto partoCollectionNewParto : partoCollectionNew) {
                if (!partoCollectionOld.contains(partoCollectionNewParto)) {
                    Preniez oldPreniezOfPartoCollectionNewParto = partoCollectionNewParto.getPreniez();
                    partoCollectionNewParto.setPreniez(preniez);
                    partoCollectionNewParto = em.merge(partoCollectionNewParto);
                    if (oldPreniezOfPartoCollectionNewParto != null && !oldPreniezOfPartoCollectionNewParto.equals(preniez)) {
                        oldPreniezOfPartoCollectionNewParto.getPartoCollection().remove(partoCollectionNewParto);
                        oldPreniezOfPartoCollectionNewParto = em.merge(oldPreniezOfPartoCollectionNewParto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = preniez.getPreniezid();
                if (findPreniez(id) == null) {
                    throw new NonexistentEntityException("The preniez with id " + id + " no longer exists.");
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
            Preniez preniez;
            try {
                preniez = em.getReference(Preniez.class, id);
                preniez.getPreniezid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The preniez with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Parto> partoCollectionOrphanCheck = preniez.getPartoCollection();
            for (Parto partoCollectionOrphanCheckParto : partoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Preniez (" + preniez + ") cannot be destroyed since the Parto " + partoCollectionOrphanCheckParto + " in its partoCollection field has a non-nullable preniez field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Servicio servicio = preniez.getServicio();
            if (servicio != null) {
                servicio.getPreniezCollection().remove(preniez);
                servicio = em.merge(servicio);
            }
            em.remove(preniez);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Preniez> findPreniezEntities() {
        return findPreniezEntities(true, -1, -1);
    }

    public List<Preniez> findPreniezEntities(int maxResults, int firstResult) {
        return findPreniezEntities(false, maxResults, firstResult);
    }

    private List<Preniez> findPreniezEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Preniez.class));
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

    public Preniez findPreniez(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Preniez.class, id);
        } finally {
            em.close();
        }
    }

    public int getPreniezCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Preniez> rt = cq.from(Preniez.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
