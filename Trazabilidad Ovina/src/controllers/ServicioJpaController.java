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
import model.Preniez;
import java.util.ArrayList;
import java.util.Collection;
import model.Servicio;

/**
 *
 * @author laura
 */
public class ServicioJpaController {

    public ServicioJpaController() {
        emf = Persistence.createEntityManagerFactory("Trazabilidad_OvinaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicio servicio) {
        if (servicio.getPreniezCollection() == null) {
            servicio.setPreniezCollection(new ArrayList<Preniez>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Oveja oveja = servicio.getOveja();
            if (oveja != null) {
                oveja = em.getReference(oveja.getClass(), oveja.getOvejaid());
                servicio.setOveja(oveja);
            }
            Oveja oveja1 = servicio.getOveja1();
            if (oveja1 != null) {
                oveja1 = em.getReference(oveja1.getClass(), oveja1.getOvejaid());
                servicio.setOveja1(oveja1);
            }
            Collection<Preniez> attachedPreniezCollection = new ArrayList<Preniez>();
            for (Preniez preniezCollectionPreniezToAttach : servicio.getPreniezCollection()) {
                preniezCollectionPreniezToAttach = em.getReference(preniezCollectionPreniezToAttach.getClass(), preniezCollectionPreniezToAttach.getPreniezid());
                attachedPreniezCollection.add(preniezCollectionPreniezToAttach);
            }
            servicio.setPreniezCollection(attachedPreniezCollection);
            em.persist(servicio);
            if (oveja != null) {
                oveja.getServicioCollection().add(servicio);
                oveja = em.merge(oveja);
            }
            if (oveja1 != null) {
                oveja1.getServicioCollection().add(servicio);
                oveja1 = em.merge(oveja1);
            }
            for (Preniez preniezCollectionPreniez : servicio.getPreniezCollection()) {
                Servicio oldServicioOfPreniezCollectionPreniez = preniezCollectionPreniez.getServicio();
                preniezCollectionPreniez.setServicio(servicio);
                preniezCollectionPreniez = em.merge(preniezCollectionPreniez);
                if (oldServicioOfPreniezCollectionPreniez != null) {
                    oldServicioOfPreniezCollectionPreniez.getPreniezCollection().remove(preniezCollectionPreniez);
                    oldServicioOfPreniezCollectionPreniez = em.merge(oldServicioOfPreniezCollectionPreniez);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicio servicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio persistentServicio = em.find(Servicio.class, servicio.getServicioid());
            Oveja ovejaOld = persistentServicio.getOveja();
            Oveja ovejaNew = servicio.getOveja();
            Oveja oveja1Old = persistentServicio.getOveja1();
            Oveja oveja1New = servicio.getOveja1();
            Collection<Preniez> preniezCollectionOld = persistentServicio.getPreniezCollection();
            Collection<Preniez> preniezCollectionNew = servicio.getPreniezCollection();
            if (ovejaNew != null) {
                ovejaNew = em.getReference(ovejaNew.getClass(), ovejaNew.getOvejaid());
                servicio.setOveja(ovejaNew);
            }
            if (oveja1New != null) {
                oveja1New = em.getReference(oveja1New.getClass(), oveja1New.getOvejaid());
                servicio.setOveja1(oveja1New);
            }
            Collection<Preniez> attachedPreniezCollectionNew = new ArrayList<Preniez>();
            for (Preniez preniezCollectionNewPreniezToAttach : preniezCollectionNew) {
                preniezCollectionNewPreniezToAttach = em.getReference(preniezCollectionNewPreniezToAttach.getClass(), preniezCollectionNewPreniezToAttach.getPreniezid());
                attachedPreniezCollectionNew.add(preniezCollectionNewPreniezToAttach);
            }
            preniezCollectionNew = attachedPreniezCollectionNew;
            servicio.setPreniezCollection(preniezCollectionNew);
            servicio = em.merge(servicio);
            if (ovejaOld != null && !ovejaOld.equals(ovejaNew)) {
                ovejaOld.getServicioCollection().remove(servicio);
                ovejaOld = em.merge(ovejaOld);
            }
            if (ovejaNew != null && !ovejaNew.equals(ovejaOld)) {
                ovejaNew.getServicioCollection().add(servicio);
                ovejaNew = em.merge(ovejaNew);
            }
            if (oveja1Old != null && !oveja1Old.equals(oveja1New)) {
                oveja1Old.getServicioCollection().remove(servicio);
                oveja1Old = em.merge(oveja1Old);
            }
            if (oveja1New != null && !oveja1New.equals(oveja1Old)) {
                oveja1New.getServicioCollection().add(servicio);
                oveja1New = em.merge(oveja1New);
            }
            for (Preniez preniezCollectionOldPreniez : preniezCollectionOld) {
                if (!preniezCollectionNew.contains(preniezCollectionOldPreniez)) {
                    preniezCollectionOldPreniez.setServicio(null);
                    preniezCollectionOldPreniez = em.merge(preniezCollectionOldPreniez);
                }
            }
            for (Preniez preniezCollectionNewPreniez : preniezCollectionNew) {
                if (!preniezCollectionOld.contains(preniezCollectionNewPreniez)) {
                    Servicio oldServicioOfPreniezCollectionNewPreniez = preniezCollectionNewPreniez.getServicio();
                    preniezCollectionNewPreniez.setServicio(servicio);
                    preniezCollectionNewPreniez = em.merge(preniezCollectionNewPreniez);
                    if (oldServicioOfPreniezCollectionNewPreniez != null && !oldServicioOfPreniezCollectionNewPreniez.equals(servicio)) {
                        oldServicioOfPreniezCollectionNewPreniez.getPreniezCollection().remove(preniezCollectionNewPreniez);
                        oldServicioOfPreniezCollectionNewPreniez = em.merge(oldServicioOfPreniezCollectionNewPreniez);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = servicio.getServicioid();
                if (findServicio(id) == null) {
                    throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.");
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
            Servicio servicio;
            try {
                servicio = em.getReference(Servicio.class, id);
                servicio.getServicioid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.", enfe);
            }
            Oveja oveja = servicio.getOveja();
            if (oveja != null) {
                oveja.getServicioCollection().remove(servicio);
                oveja = em.merge(oveja);
            }
            Oveja oveja1 = servicio.getOveja1();
            if (oveja1 != null) {
                oveja1.getServicioCollection().remove(servicio);
                oveja1 = em.merge(oveja1);
            }
            Collection<Preniez> preniezCollection = servicio.getPreniezCollection();
            for (Preniez preniezCollectionPreniez : preniezCollection) {
                preniezCollectionPreniez.setServicio(null);
                preniezCollectionPreniez = em.merge(preniezCollectionPreniez);
            }
            em.remove(servicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicio> findServicioEntities() {
        return findServicioEntities(true, -1, -1);
    }

    public List<Servicio> findServicioEntities(int maxResults, int firstResult) {
        return findServicioEntities(false, maxResults, firstResult);
    }

    private List<Servicio> findServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicio.class));
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

    public Servicio findServicio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicio> rt = cq.from(Servicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
