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
import model.Oveja;
import model.Parto;
import model.Majada;
import model.Ovejaxcorral;
import java.util.ArrayList;
import java.util.Collection;
import model.Estadopartoxpartoxoveja;
import model.Servicio;

/**
 *
 * @author laura
 */
public class OvejaJpaController {

    public OvejaJpaController() {
        emf = Persistence.createEntityManagerFactory("Trazabilidad_OvinaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Oveja oveja) {
        if (oveja.getOvejaxcorralCollection() == null) {
            oveja.setOvejaxcorralCollection(new ArrayList<Ovejaxcorral>());
        }
        if (oveja.getEstadopartoxpartoxovejaCollection() == null) {
            oveja.setEstadopartoxpartoxovejaCollection(new ArrayList<Estadopartoxpartoxoveja>());
        }
        if (oveja.getServicioCollection() == null) {
            oveja.setServicioCollection(new ArrayList<Servicio>());
        }
        if (oveja.getServicioCollection1() == null) {
            oveja.setServicioCollection1(new ArrayList<Servicio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Parto parto = oveja.getParto();
            if (parto != null) {
                parto = em.getReference(parto.getClass(), parto.getPartoid());
                oveja.setParto(parto);
            }
            Majada majada = oveja.getMajada();
            if (majada != null) {
                majada = em.getReference(majada.getClass(), majada.getMajadaid());
                oveja.setMajada(majada);
            }
            Collection<Ovejaxcorral> attachedOvejaxcorralCollection = new ArrayList<Ovejaxcorral>();
            for (Ovejaxcorral ovejaxcorralCollectionOvejaxcorralToAttach : oveja.getOvejaxcorralCollection()) {
                ovejaxcorralCollectionOvejaxcorralToAttach = em.getReference(ovejaxcorralCollectionOvejaxcorralToAttach.getClass(), ovejaxcorralCollectionOvejaxcorralToAttach.getOvejaxcorralid());
                attachedOvejaxcorralCollection.add(ovejaxcorralCollectionOvejaxcorralToAttach);
            }
            oveja.setOvejaxcorralCollection(attachedOvejaxcorralCollection);
            Collection<Estadopartoxpartoxoveja> attachedEstadopartoxpartoxovejaCollection = new ArrayList<Estadopartoxpartoxoveja>();
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach : oveja.getEstadopartoxpartoxovejaCollection()) {
                estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach = em.getReference(estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach.getClass(), estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach.getEstadopartoxpartoxovejaid());
                attachedEstadopartoxpartoxovejaCollection.add(estadopartoxpartoxovejaCollectionEstadopartoxpartoxovejaToAttach);
            }
            oveja.setEstadopartoxpartoxovejaCollection(attachedEstadopartoxpartoxovejaCollection);
            Collection<Servicio> attachedServicioCollection = new ArrayList<Servicio>();
            for (Servicio servicioCollectionServicioToAttach : oveja.getServicioCollection()) {
                servicioCollectionServicioToAttach = em.getReference(servicioCollectionServicioToAttach.getClass(), servicioCollectionServicioToAttach.getServicioid());
                attachedServicioCollection.add(servicioCollectionServicioToAttach);
            }
            oveja.setServicioCollection(attachedServicioCollection);
            Collection<Servicio> attachedServicioCollection1 = new ArrayList<Servicio>();
            for (Servicio servicioCollection1ServicioToAttach : oveja.getServicioCollection1()) {
                servicioCollection1ServicioToAttach = em.getReference(servicioCollection1ServicioToAttach.getClass(), servicioCollection1ServicioToAttach.getServicioid());
                attachedServicioCollection1.add(servicioCollection1ServicioToAttach);
            }
            oveja.setServicioCollection1(attachedServicioCollection1);
            em.persist(oveja);
            if (parto != null) {
                parto.getOvejaCollection().add(oveja);
                parto = em.merge(parto);
            }
            if (majada != null) {
                majada.getOvejaCollection().add(oveja);
                majada = em.merge(majada);
            }
            for (Ovejaxcorral ovejaxcorralCollectionOvejaxcorral : oveja.getOvejaxcorralCollection()) {
                Oveja oldOvejaOfOvejaxcorralCollectionOvejaxcorral = ovejaxcorralCollectionOvejaxcorral.getOveja();
                ovejaxcorralCollectionOvejaxcorral.setOveja(oveja);
                ovejaxcorralCollectionOvejaxcorral = em.merge(ovejaxcorralCollectionOvejaxcorral);
                if (oldOvejaOfOvejaxcorralCollectionOvejaxcorral != null) {
                    oldOvejaOfOvejaxcorralCollectionOvejaxcorral.getOvejaxcorralCollection().remove(ovejaxcorralCollectionOvejaxcorral);
                    oldOvejaOfOvejaxcorralCollectionOvejaxcorral = em.merge(oldOvejaOfOvejaxcorralCollectionOvejaxcorral);
                }
            }
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja : oveja.getEstadopartoxpartoxovejaCollection()) {
                Oveja oldOvejaOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja = estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja.getOveja();
                estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja.setOveja(oveja);
                estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja = em.merge(estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja);
                if (oldOvejaOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja != null) {
                    oldOvejaOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja);
                    oldOvejaOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja = em.merge(oldOvejaOfEstadopartoxpartoxovejaCollectionEstadopartoxpartoxoveja);
                }
            }
            for (Servicio servicioCollectionServicio : oveja.getServicioCollection()) {
                Oveja oldOvejaOfServicioCollectionServicio = servicioCollectionServicio.getOveja();
                servicioCollectionServicio.setOveja(oveja);
                servicioCollectionServicio = em.merge(servicioCollectionServicio);
                if (oldOvejaOfServicioCollectionServicio != null) {
                    oldOvejaOfServicioCollectionServicio.getServicioCollection().remove(servicioCollectionServicio);
                    oldOvejaOfServicioCollectionServicio = em.merge(oldOvejaOfServicioCollectionServicio);
                }
            }
            for (Servicio servicioCollection1Servicio : oveja.getServicioCollection1()) {
                Oveja oldOveja1OfServicioCollection1Servicio = servicioCollection1Servicio.getOveja1();
                servicioCollection1Servicio.setOveja1(oveja);
                servicioCollection1Servicio = em.merge(servicioCollection1Servicio);
                if (oldOveja1OfServicioCollection1Servicio != null) {
                    oldOveja1OfServicioCollection1Servicio.getServicioCollection1().remove(servicioCollection1Servicio);
                    oldOveja1OfServicioCollection1Servicio = em.merge(oldOveja1OfServicioCollection1Servicio);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Oveja oveja) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Oveja persistentOveja = em.find(Oveja.class, oveja.getOvejaid());
            Parto partoOld = persistentOveja.getParto();
            Parto partoNew = oveja.getParto();
            Majada majadaOld = persistentOveja.getMajada();
            Majada majadaNew = oveja.getMajada();
            Collection<Ovejaxcorral> ovejaxcorralCollectionOld = persistentOveja.getOvejaxcorralCollection();
            Collection<Ovejaxcorral> ovejaxcorralCollectionNew = oveja.getOvejaxcorralCollection();
            Collection<Estadopartoxpartoxoveja> estadopartoxpartoxovejaCollectionOld = persistentOveja.getEstadopartoxpartoxovejaCollection();
            Collection<Estadopartoxpartoxoveja> estadopartoxpartoxovejaCollectionNew = oveja.getEstadopartoxpartoxovejaCollection();
            Collection<Servicio> servicioCollectionOld = persistentOveja.getServicioCollection();
            Collection<Servicio> servicioCollectionNew = oveja.getServicioCollection();
            Collection<Servicio> servicioCollection1Old = persistentOveja.getServicioCollection1();
            Collection<Servicio> servicioCollection1New = oveja.getServicioCollection1();
            List<String> illegalOrphanMessages = null;
            for (Ovejaxcorral ovejaxcorralCollectionOldOvejaxcorral : ovejaxcorralCollectionOld) {
                if (!ovejaxcorralCollectionNew.contains(ovejaxcorralCollectionOldOvejaxcorral)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ovejaxcorral " + ovejaxcorralCollectionOldOvejaxcorral + " since its oveja field is not nullable.");
                }
            }
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionOldEstadopartoxpartoxoveja : estadopartoxpartoxovejaCollectionOld) {
                if (!estadopartoxpartoxovejaCollectionNew.contains(estadopartoxpartoxovejaCollectionOldEstadopartoxpartoxoveja)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Estadopartoxpartoxoveja " + estadopartoxpartoxovejaCollectionOldEstadopartoxpartoxoveja + " since its oveja field is not nullable.");
                }
            }
            for (Servicio servicioCollection1OldServicio : servicioCollection1Old) {
                if (!servicioCollection1New.contains(servicioCollection1OldServicio)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Servicio " + servicioCollection1OldServicio + " since its oveja1 field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (partoNew != null) {
                partoNew = em.getReference(partoNew.getClass(), partoNew.getPartoid());
                oveja.setParto(partoNew);
            }
            if (majadaNew != null) {
                majadaNew = em.getReference(majadaNew.getClass(), majadaNew.getMajadaid());
                oveja.setMajada(majadaNew);
            }
            Collection<Ovejaxcorral> attachedOvejaxcorralCollectionNew = new ArrayList<Ovejaxcorral>();
            for (Ovejaxcorral ovejaxcorralCollectionNewOvejaxcorralToAttach : ovejaxcorralCollectionNew) {
                ovejaxcorralCollectionNewOvejaxcorralToAttach = em.getReference(ovejaxcorralCollectionNewOvejaxcorralToAttach.getClass(), ovejaxcorralCollectionNewOvejaxcorralToAttach.getOvejaxcorralid());
                attachedOvejaxcorralCollectionNew.add(ovejaxcorralCollectionNewOvejaxcorralToAttach);
            }
            ovejaxcorralCollectionNew = attachedOvejaxcorralCollectionNew;
            oveja.setOvejaxcorralCollection(ovejaxcorralCollectionNew);
            Collection<Estadopartoxpartoxoveja> attachedEstadopartoxpartoxovejaCollectionNew = new ArrayList<Estadopartoxpartoxoveja>();
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach : estadopartoxpartoxovejaCollectionNew) {
                estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach = em.getReference(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach.getClass(), estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach.getEstadopartoxpartoxovejaid());
                attachedEstadopartoxpartoxovejaCollectionNew.add(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxovejaToAttach);
            }
            estadopartoxpartoxovejaCollectionNew = attachedEstadopartoxpartoxovejaCollectionNew;
            oveja.setEstadopartoxpartoxovejaCollection(estadopartoxpartoxovejaCollectionNew);
            Collection<Servicio> attachedServicioCollectionNew = new ArrayList<Servicio>();
            for (Servicio servicioCollectionNewServicioToAttach : servicioCollectionNew) {
                servicioCollectionNewServicioToAttach = em.getReference(servicioCollectionNewServicioToAttach.getClass(), servicioCollectionNewServicioToAttach.getServicioid());
                attachedServicioCollectionNew.add(servicioCollectionNewServicioToAttach);
            }
            servicioCollectionNew = attachedServicioCollectionNew;
            oveja.setServicioCollection(servicioCollectionNew);
            Collection<Servicio> attachedServicioCollection1New = new ArrayList<Servicio>();
            for (Servicio servicioCollection1NewServicioToAttach : servicioCollection1New) {
                servicioCollection1NewServicioToAttach = em.getReference(servicioCollection1NewServicioToAttach.getClass(), servicioCollection1NewServicioToAttach.getServicioid());
                attachedServicioCollection1New.add(servicioCollection1NewServicioToAttach);
            }
            servicioCollection1New = attachedServicioCollection1New;
            oveja.setServicioCollection1(servicioCollection1New);
            oveja = em.merge(oveja);
            if (partoOld != null && !partoOld.equals(partoNew)) {
                partoOld.getOvejaCollection().remove(oveja);
                partoOld = em.merge(partoOld);
            }
            if (partoNew != null && !partoNew.equals(partoOld)) {
                partoNew.getOvejaCollection().add(oveja);
                partoNew = em.merge(partoNew);
            }
            if (majadaOld != null && !majadaOld.equals(majadaNew)) {
                majadaOld.getOvejaCollection().remove(oveja);
                majadaOld = em.merge(majadaOld);
            }
            if (majadaNew != null && !majadaNew.equals(majadaOld)) {
                majadaNew.getOvejaCollection().add(oveja);
                majadaNew = em.merge(majadaNew);
            }
            for (Ovejaxcorral ovejaxcorralCollectionNewOvejaxcorral : ovejaxcorralCollectionNew) {
                if (!ovejaxcorralCollectionOld.contains(ovejaxcorralCollectionNewOvejaxcorral)) {
                    Oveja oldOvejaOfOvejaxcorralCollectionNewOvejaxcorral = ovejaxcorralCollectionNewOvejaxcorral.getOveja();
                    ovejaxcorralCollectionNewOvejaxcorral.setOveja(oveja);
                    ovejaxcorralCollectionNewOvejaxcorral = em.merge(ovejaxcorralCollectionNewOvejaxcorral);
                    if (oldOvejaOfOvejaxcorralCollectionNewOvejaxcorral != null && !oldOvejaOfOvejaxcorralCollectionNewOvejaxcorral.equals(oveja)) {
                        oldOvejaOfOvejaxcorralCollectionNewOvejaxcorral.getOvejaxcorralCollection().remove(ovejaxcorralCollectionNewOvejaxcorral);
                        oldOvejaOfOvejaxcorralCollectionNewOvejaxcorral = em.merge(oldOvejaOfOvejaxcorralCollectionNewOvejaxcorral);
                    }
                }
            }
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja : estadopartoxpartoxovejaCollectionNew) {
                if (!estadopartoxpartoxovejaCollectionOld.contains(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja)) {
                    Oveja oldOvejaOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja = estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.getOveja();
                    estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.setOveja(oveja);
                    estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja = em.merge(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja);
                    if (oldOvejaOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja != null && !oldOvejaOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.equals(oveja)) {
                        oldOvejaOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja.getEstadopartoxpartoxovejaCollection().remove(estadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja);
                        oldOvejaOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja = em.merge(oldOvejaOfEstadopartoxpartoxovejaCollectionNewEstadopartoxpartoxoveja);
                    }
                }
            }
            for (Servicio servicioCollectionOldServicio : servicioCollectionOld) {
                if (!servicioCollectionNew.contains(servicioCollectionOldServicio)) {
                    servicioCollectionOldServicio.setOveja(null);
                    servicioCollectionOldServicio = em.merge(servicioCollectionOldServicio);
                }
            }
            for (Servicio servicioCollectionNewServicio : servicioCollectionNew) {
                if (!servicioCollectionOld.contains(servicioCollectionNewServicio)) {
                    Oveja oldOvejaOfServicioCollectionNewServicio = servicioCollectionNewServicio.getOveja();
                    servicioCollectionNewServicio.setOveja(oveja);
                    servicioCollectionNewServicio = em.merge(servicioCollectionNewServicio);
                    if (oldOvejaOfServicioCollectionNewServicio != null && !oldOvejaOfServicioCollectionNewServicio.equals(oveja)) {
                        oldOvejaOfServicioCollectionNewServicio.getServicioCollection().remove(servicioCollectionNewServicio);
                        oldOvejaOfServicioCollectionNewServicio = em.merge(oldOvejaOfServicioCollectionNewServicio);
                    }
                }
            }
            for (Servicio servicioCollection1NewServicio : servicioCollection1New) {
                if (!servicioCollection1Old.contains(servicioCollection1NewServicio)) {
                    Oveja oldOveja1OfServicioCollection1NewServicio = servicioCollection1NewServicio.getOveja1();
                    servicioCollection1NewServicio.setOveja1(oveja);
                    servicioCollection1NewServicio = em.merge(servicioCollection1NewServicio);
                    if (oldOveja1OfServicioCollection1NewServicio != null && !oldOveja1OfServicioCollection1NewServicio.equals(oveja)) {
                        oldOveja1OfServicioCollection1NewServicio.getServicioCollection1().remove(servicioCollection1NewServicio);
                        oldOveja1OfServicioCollection1NewServicio = em.merge(oldOveja1OfServicioCollection1NewServicio);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = oveja.getOvejaid();
                if (findOveja(id) == null) {
                    throw new NonexistentEntityException("The oveja with id " + id + " no longer exists.");
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
            Oveja oveja;
            try {
                oveja = em.getReference(Oveja.class, id);
                oveja.getOvejaid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The oveja with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ovejaxcorral> ovejaxcorralCollectionOrphanCheck = oveja.getOvejaxcorralCollection();
            for (Ovejaxcorral ovejaxcorralCollectionOrphanCheckOvejaxcorral : ovejaxcorralCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Oveja (" + oveja + ") cannot be destroyed since the Ovejaxcorral " + ovejaxcorralCollectionOrphanCheckOvejaxcorral + " in its ovejaxcorralCollection field has a non-nullable oveja field.");
            }
            Collection<Estadopartoxpartoxoveja> estadopartoxpartoxovejaCollectionOrphanCheck = oveja.getEstadopartoxpartoxovejaCollection();
            for (Estadopartoxpartoxoveja estadopartoxpartoxovejaCollectionOrphanCheckEstadopartoxpartoxoveja : estadopartoxpartoxovejaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Oveja (" + oveja + ") cannot be destroyed since the Estadopartoxpartoxoveja " + estadopartoxpartoxovejaCollectionOrphanCheckEstadopartoxpartoxoveja + " in its estadopartoxpartoxovejaCollection field has a non-nullable oveja field.");
            }
            Collection<Servicio> servicioCollection1OrphanCheck = oveja.getServicioCollection1();
            for (Servicio servicioCollection1OrphanCheckServicio : servicioCollection1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Oveja (" + oveja + ") cannot be destroyed since the Servicio " + servicioCollection1OrphanCheckServicio + " in its servicioCollection1 field has a non-nullable oveja1 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Parto parto = oveja.getParto();
            if (parto != null) {
                parto.getOvejaCollection().remove(oveja);
                parto = em.merge(parto);
            }
            Majada majada = oveja.getMajada();
            if (majada != null) {
                majada.getOvejaCollection().remove(oveja);
                majada = em.merge(majada);
            }
            Collection<Servicio> servicioCollection = oveja.getServicioCollection();
            for (Servicio servicioCollectionServicio : servicioCollection) {
                servicioCollectionServicio.setOveja(null);
                servicioCollectionServicio = em.merge(servicioCollectionServicio);
            }
            em.remove(oveja);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Oveja> findOvejaEntities() {
        return findOvejaEntities(true, -1, -1);
    }

    public List<Oveja> findOvejaEntities(int maxResults, int firstResult) {
        return findOvejaEntities(false, maxResults, firstResult);
    }

    private List<Oveja> findOvejaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Oveja.class));
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

    public Oveja findOveja(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Oveja.class, id);
        } finally {
            em.close();
        }
    }

    public int getOvejaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Oveja> rt = cq.from(Oveja.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
