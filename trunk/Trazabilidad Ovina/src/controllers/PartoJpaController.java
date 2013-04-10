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
import model.Parto;
import model.Preniez;
import model.Estadopartoxpartoxoveja;
import java.util.ArrayList;
import java.util.Collection;
import model.Oveja;

/**
 *
 * @author laura
 */
public class PartoJpaController {

    public PartoJpaController() {
        emf = Persistence.createEntityManagerFactory("Trazabilidad_OvinaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Parto parto) {
        if (parto.getEstadopartoxpartoxovejaCollection() == null) {
            parto.setEstadopartoxpartoxovejaCollection(new ArrayList<Estadopartoxpartoxoveja>());
        }
        if (parto.getOvejaCollection() == null) {
            parto.setOvejaCollection(new ArrayList<Oveja>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Preniez preniez = parto.getPreniez();
            if (preniez != null) {
                preniez = em.getReference(preniez.getClass(), preniez.getPreniezid());
                parto.setPreniez(preniez);
            }
            Collection<Estadopartoxpartoxoveja> attachedEstadopartoxpartoxovejaCollection = new ArrayList<Estadopartoxpartoxoveja>();
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach : parto.getEstadopartoxpartoxovejaCollection()) {
                estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach = em.getReference(estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach.getClass(), estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach.getEstadopartoxpartoxovejaid());
                attachedEstadopartoxpartoxovejaCollection.add(estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach);
            }
            parto.setEstadopartoxpartoxovejaCollection(attachedEstadopartoxpartoxovejaCollection);
            Collection<Oveja> attachedOvejaCollection = new ArrayList<Oveja>();
            for (Oveja ovejaCollectionOvejaToAttach : parto.getOvejaCollection()) {
                ovejaCollectionOvejaToAttach = em.getReference(ovejaCollectionOvejaToAttach.getClass(), ovejaCollectionOvejaToAttach.getOvejaid());
                attachedOvejaCollection.add(ovejaCollectionOvejaToAttach);
            }
            parto.setOvejaCollection(attachedOvejaCollection);
            em.persist(parto);
            if (preniez != null) {
                preniez.getPartoCollection().add(parto);
                preniez = em.merge(preniez);
            }
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja : parto.getEstadopartoxpartoxovejaCollection()) {
                Parto oldPartoOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja = estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja.getParto();
                estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja.setParto(parto);
                estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja = em.merge(estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja);
                if (oldPartoOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja != null) {
                    oldPartoOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja);
                    oldPartoOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja = em.merge(oldPartoOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja);
                }
            }
            for (Oveja ovejaCollectionOveja : parto.getOvejaCollection()) {
                Parto oldPartoOfOvejaCollectionOveja = ovejaCollectionOveja.getParto();
                ovejaCollectionOveja.setParto(parto);
                ovejaCollectionOveja = em.merge(ovejaCollectionOveja);
                if (oldPartoOfOvejaCollectionOveja != null) {
                    oldPartoOfOvejaCollectionOveja.getOvejaCollection().remove(ovejaCollectionOveja);
                    oldPartoOfOvejaCollectionOveja = em.merge(oldPartoOfOvejaCollectionOveja);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Parto parto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Parto persistentParto = em.find(Parto.class, parto.getPartoid());
            Preniez preniezOld = persistentParto.getPreniez();
            Preniez preniezNew = parto.getPreniez();
            Collection<Estadopartoxpartoxoveja> estadopartoxpartoxovejaCollectionOld = persistentParto.getEstadopartoxpartoxovejaCollection();
            Collection<Estadopartoxpartoxoveja> estadopartoxpartoxovejaCollectionNew = parto.getEstadopartoxpartoxovejaCollection();
            Collection<Oveja> ovejaCollectionOld = persistentParto.getOvejaCollection();
            Collection<Oveja> ovejaCollectionNew = parto.getOvejaCollection();
            List<String> illegalOrphanMessages = null;
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionOldEstadopartoxpartoxoveja : estadopartoxpartoxovejaCollectionOld) {
                if (!estadopartoxpartoxovejaCollectionNew.contains(estadopartoxpartoxovejaCollectionOldEstadopartoxpartoxoveja)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Estadopartoxpartoxoveja " + estadopartoxpartoxovejaCollectionOldEstadopartoxpartoxoveja + " since its parto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (preniezNew != null) {
                preniezNew = em.getReference(preniezNew.getClass(), preniezNew.getPreniezid());
                parto.setPreniez(preniezNew);
            }
            Collection<Estadopartoxpartoxoveja> attachedEstadopartoxpartoxovejaCollectionNew = new ArrayList<Estadopartoxpartoxoveja>();
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach : estadopartoxpartoxovejaCollectionNew) {
                estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach = em.getReference(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach.getClass(), estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach.getEstadopartoxpartoxovejaid());
                attachedEstadopartoxpartoxovejaCollectionNew.add(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach);
            }
            estadopartoxpartoxovejaCollectionNew = attachedEstadopartoxpartoxovejaCollectionNew;
            parto.setEstadopartoxpartoxovejaCollection(estadopartoxpartoxovejaCollectionNew);
            Collection<Oveja> attachedOvejaCollectionNew = new ArrayList<Oveja>();
            for (Oveja ovejaCollectionNewOvejaToAttach : ovejaCollectionNew) {
                ovejaCollectionNewOvejaToAttach = em.getReference(ovejaCollectionNewOvejaToAttach.getClass(), ovejaCollectionNewOvejaToAttach.getOvejaid());
                attachedOvejaCollectionNew.add(ovejaCollectionNewOvejaToAttach);
            }
            ovejaCollectionNew = attachedOvejaCollectionNew;
            parto.setOvejaCollection(ovejaCollectionNew);
            parto = em.merge(parto);
            if (preniezOld != null && !preniezOld.equals(preniezNew)) {
                preniezOld.getPartoCollection().remove(parto);
                preniezOld = em.merge(preniezOld);
            }
            if (preniezNew != null && !preniezNew.equals(preniezOld)) {
                preniezNew.getPartoCollection().add(parto);
                preniezNew = em.merge(preniezNew);
            }
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja : estadopartoxpartoxovejaCollectionNew) {
                if (!estadopartoxpartoxovejaCollectionOld.contains(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja)) {
                    Parto oldPartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja = estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.getParto();
                    estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.setParto(parto);
                    estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja = em.merge(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja);
                    if (oldPartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja != null && !oldPartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.equals(parto)) {
                        oldPartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja);
                        oldPartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja = em.merge(oldPartoOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja);
                    }
                }
            }
            for (Oveja ovejaCollectionOldOveja : ovejaCollectionOld) {
                if (!ovejaCollectionNew.contains(ovejaCollectionOldOveja)) {
                    ovejaCollectionOldOveja.setParto(null);
                    ovejaCollectionOldOveja = em.merge(ovejaCollectionOldOveja);
                }
            }
            for (Oveja ovejaCollectionNewOveja : ovejaCollectionNew) {
                if (!ovejaCollectionOld.contains(ovejaCollectionNewOveja)) {
                    Parto oldPartoOfOvejaCollectionNewOveja = ovejaCollectionNewOveja.getParto();
                    ovejaCollectionNewOveja.setParto(parto);
                    ovejaCollectionNewOveja = em.merge(ovejaCollectionNewOveja);
                    if (oldPartoOfOvejaCollectionNewOveja != null && !oldPartoOfOvejaCollectionNewOveja.equals(parto)) {
                        oldPartoOfOvejaCollectionNewOveja.getOvejaCollection().remove(ovejaCollectionNewOveja);
                        oldPartoOfOvejaCollectionNewOveja = em.merge(oldPartoOfOvejaCollectionNewOveja);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = parto.getPartoid();
                if (findParto(id) == null) {
                    throw new NonexistentEntityException("The parto with id " + id + " no longer exists.");
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
            Parto parto;
            try {
                parto = em.getReference(Parto.class, id);
                parto.getPartoid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The parto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Estadopartoxpartoxoveja> estadopartoxpartoxovejaCollectionOrphanCheck = parto.getEstadopartoxpartoxovejaCollection();
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionOrphanCheckEstadopartoxpartoxoveja : estadopartoxpartoxovejaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Parto (" + parto + ") cannot be destroyed since the Estadopartoxpartoxoveja " + estadopartoxpartoxovejaCollectionOrphanCheckEstadopartoxpartoxoveja + " in its estadopartoxpartoxovejaCollection field has a non-nullable parto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Preniez preniez = parto.getPreniez();
            if (preniez != null) {
                preniez.getPartoCollection().remove(parto);
                preniez = em.merge(preniez);
            }
            Collection<Oveja> ovejaCollection = parto.getOvejaCollection();
            for (Oveja ovejaCollectionOveja : ovejaCollection) {
                ovejaCollectionOveja.setParto(null);
                ovejaCollectionOveja = em.merge(ovejaCollectionOveja);
            }
            em.remove(parto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Parto> findPartoEntities() {
        return findPartoEntities(true, -1, -1);
    }

    public List<Parto> findPartoEntities(int maxResults, int firstResult) {
        return findPartoEntities(false, maxResults, firstResult);
    }

    private List<Parto> findPartoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Parto as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Parto findParto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Parto.class, id);
        } finally {
            em.close();
        }
    }

    public int getPartoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Parto as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
