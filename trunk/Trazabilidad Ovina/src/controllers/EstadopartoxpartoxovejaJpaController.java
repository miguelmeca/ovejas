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
import model.Estadopartoxpartoxoveja;
import model.Parto;
import model.Oveja;
import model.Estadoparto;

/**
 *
 * @author laura
 */
public class EstadopartoxpartoxovejaJpaController {

    public EstadopartoxpartoxovejaJpaController() {
        emf = Persistence.createEntityManagerFactory("Trazabilidad_OvinaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estadopartoxpartoxoveja estadopartoxpartoxoveja) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Parto parto = estadopartoxpartoxoveja.getParto();
            if (parto != null) {
                parto = em.getReference(parto.getClass(), parto.getPartoid());
                estadopartoxpartoxoveja.setParto(parto);
            }
            Oveja oveja = estadopartoxpartoxoveja.getOveja();
            if (oveja != null) {
                oveja = em.getReference(oveja.getClass(), oveja.getOvejaid());
                estadopartoxpartoxoveja.setOveja(oveja);
            }
            Estadoparto estadoparto = estadopartoxpartoxoveja.getEstadoparto();
            if (estadoparto != null) {
                estadoparto = em.getReference(estadoparto.getClass(), estadoparto.getEstadopartoid());
                estadopartoxpartoxoveja.setEstadoparto(estadoparto);
            }
            em.persist(estadopartoxpartoxoveja);
            if (parto != null) {
                parto.getEstadopartoxpartoxovejaCollection().add(estadopartoxpartoxoveja);
                parto = em.merge(parto);
            }
            if (oveja != null) {
                oveja.getEstadopartoxpartoxovejaCollection().add(estadopartoxpartoxoveja);
                oveja = em.merge(oveja);
            }
            if (estadoparto != null) {
                estadoparto.getEstadopartoxpartoxovejaCollection().add(estadopartoxpartoxoveja);
                estadoparto = em.merge(estadoparto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estadopartoxpartoxoveja estadopartoxpartoxoveja) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estadopartoxpartoxoveja persistentEstadopartoxpartoxoveja = em.find(Estadopartoxpartoxoveja.class, estadopartoxpartoxoveja.getEstadopartoxpartoxovejaid());
            Parto partoOld = persistentEstadopartoxpartoxoveja.getParto();
            Parto partoNew = estadopartoxpartoxoveja.getParto();
            Oveja ovejaOld = persistentEstadopartoxpartoxoveja.getOveja();
            Oveja ovejaNew = estadopartoxpartoxoveja.getOveja();
            Estadoparto estadopartoOld = persistentEstadopartoxpartoxoveja.getEstadoparto();
            Estadoparto estadopartoNew = estadopartoxpartoxoveja.getEstadoparto();
            if (partoNew != null) {
                partoNew = em.getReference(partoNew.getClass(), partoNew.getPartoid());
                estadopartoxpartoxoveja.setParto(partoNew);
            }
            if (ovejaNew != null) {
                ovejaNew = em.getReference(ovejaNew.getClass(), ovejaNew.getOvejaid());
                estadopartoxpartoxoveja.setOveja(ovejaNew);
            }
            if (estadopartoNew != null) {
                estadopartoNew = em.getReference(estadopartoNew.getClass(), estadopartoNew.getEstadopartoid());
                estadopartoxpartoxoveja.setEstadoparto(estadopartoNew);
            }
            estadopartoxpartoxoveja = em.merge(estadopartoxpartoxoveja);
            if (partoOld != null && !partoOld.equals(partoNew)) {
                partoOld.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxoveja);
                partoOld = em.merge(partoOld);
            }
            if (partoNew != null && !partoNew.equals(partoOld)) {
                partoNew.getEstadopartoxpartoxovejaCollection().add(estadopartoxpartoxoveja);
                partoNew = em.merge(partoNew);
            }
            if (ovejaOld != null && !ovejaOld.equals(ovejaNew)) {
                ovejaOld.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxoveja);
                ovejaOld = em.merge(ovejaOld);
            }
            if (ovejaNew != null && !ovejaNew.equals(ovejaOld)) {
                ovejaNew.getEstadopartoxpartoxovejaCollection().add(estadopartoxpartoxoveja);
                ovejaNew = em.merge(ovejaNew);
            }
            if (estadopartoOld != null && !estadopartoOld.equals(estadopartoNew)) {
                estadopartoOld.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxoveja);
                estadopartoOld = em.merge(estadopartoOld);
            }
            if (estadopartoNew != null && !estadopartoNew.equals(estadopartoOld)) {
                estadopartoNew.getEstadopartoxpartoxovejaCollection().add(estadopartoxpartoxoveja);
                estadopartoNew = em.merge(estadopartoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estadopartoxpartoxoveja.getEstadopartoxpartoxovejaid();
                if (findEstadopartoxpartoxoveja(id) == null) {
                    throw new NonexistentEntityException("The estadopartoxpartoxoveja with id " + id + " no longer exists.");
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
            Estadopartoxpartoxoveja estadopartoxpartoxoveja;
            try {
                estadopartoxpartoxoveja = em.getReference(Estadopartoxpartoxoveja.class, id);
                estadopartoxpartoxoveja.getEstadopartoxpartoxovejaid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadopartoxpartoxoveja with id " + id + " no longer exists.", enfe);
            }
            Parto parto = estadopartoxpartoxoveja.getParto();
            if (parto != null) {
                parto.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxoveja);
                parto = em.merge(parto);
            }
            Oveja oveja = estadopartoxpartoxoveja.getOveja();
            if (oveja != null) {
                oveja.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxoveja);
                oveja = em.merge(oveja);
            }
            Estadoparto estadoparto = estadopartoxpartoxoveja.getEstadoparto();
            if (estadoparto != null) {
                estadoparto.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxoveja);
                estadoparto = em.merge(estadoparto);
            }
            em.remove(estadopartoxpartoxoveja);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estadopartoxpartoxoveja> findEstadopartoxpartoxovejaEntities() {
        return findEstadopartoxpartoxovejaEntities(true, -1, -1);
    }

    public List<Estadopartoxpartoxoveja> findEstadopartoxpartoxovejaEntities(int maxResults, int firstResult) {
        return findEstadopartoxpartoxovejaEntities(false, maxResults, firstResult);
    }

    private List<Estadopartoxpartoxoveja> findEstadopartoxpartoxovejaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estadopartoxpartoxoveja.class));
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

    public Estadopartoxpartoxoveja findEstadopartoxpartoxoveja(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estadopartoxpartoxoveja.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadopartoxpartoxovejaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estadopartoxpartoxoveja> rt = cq.from(Estadopartoxpartoxoveja.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
