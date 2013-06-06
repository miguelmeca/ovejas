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
import model.Criaxestadoxparto;
import java.util.ArrayList;
import java.util.Collection;
import model.Madrexestadoxparto;
import model.Historialxovejaxcorral;
import model.Oveja;
import model.Servicio;

/**
 *
 * @author laura
 */
public class OvejaJpaController {

    public OvejaJpaController() {
        emf = Persistence.createEntityManagerFactory("REEMPLAZARPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Oveja oveja) {
        if (oveja.getCriaxestadoxpartoCollection() == null) {
            oveja.setCriaxestadoxpartoCollection(new ArrayList<Criaxestadoxparto>());
        }
        if (oveja.getMadrexestadoxpartoCollection() == null) {
            oveja.setMadrexestadoxpartoCollection(new ArrayList<Madrexestadoxparto>());
        }
        if (oveja.getHistorialxovejaxcorralCollection() == null) {
            oveja.setHistorialxovejaxcorralCollection(new ArrayList<Historialxovejaxcorral>());
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
            Collection<Criaxestadoxparto> attachedCriaxestadoxpartoCollection = new ArrayList<Criaxestadoxparto>();
            for (Criaxestadoxparto criaxestadoxpartoCollectionCriaxestadoxpartoToAttach : oveja.getCriaxestadoxpartoCollection()) {
                criaxestadoxpartoCollectionCriaxestadoxpartoToAttach = em.getReference(criaxestadoxpartoCollectionCriaxestadoxpartoToAttach.getClass(), criaxestadoxpartoCollectionCriaxestadoxpartoToAttach.getCriaxestadoxpartoid());
                attachedCriaxestadoxpartoCollection.add(criaxestadoxpartoCollectionCriaxestadoxpartoToAttach);
            }
            oveja.setCriaxestadoxpartoCollection(attachedCriaxestadoxpartoCollection);
            Collection<Madrexestadoxparto> attachedMadrexestadoxpartoCollection = new ArrayList<Madrexestadoxparto>();
            for (Madrexestadoxparto madrexestadoxpartoCollectionMadrexestadoxpartoToAttach : oveja.getMadrexestadoxpartoCollection()) {
                madrexestadoxpartoCollectionMadrexestadoxpartoToAttach = em.getReference(madrexestadoxpartoCollectionMadrexestadoxpartoToAttach.getClass(), madrexestadoxpartoCollectionMadrexestadoxpartoToAttach.getMadrexestadoxpartoid());
                attachedMadrexestadoxpartoCollection.add(madrexestadoxpartoCollectionMadrexestadoxpartoToAttach);
            }
            oveja.setMadrexestadoxpartoCollection(attachedMadrexestadoxpartoCollection);
            Collection<Historialxovejaxcorral> attachedHistorialxovejaxcorralCollection = new ArrayList<Historialxovejaxcorral>();
            for (Historialxovejaxcorral historialxovejaxcorralCollectionHistorialxovejaxcorralToAttach : oveja.getHistorialxovejaxcorralCollection()) {
                historialxovejaxcorralCollectionHistorialxovejaxcorralToAttach = em.getReference(historialxovejaxcorralCollectionHistorialxovejaxcorralToAttach.getClass(), historialxovejaxcorralCollectionHistorialxovejaxcorralToAttach.getHistorialxovejaxcorralid());
                attachedHistorialxovejaxcorralCollection.add(historialxovejaxcorralCollectionHistorialxovejaxcorralToAttach);
            }
            oveja.setHistorialxovejaxcorralCollection(attachedHistorialxovejaxcorralCollection);
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
            for (Criaxestadoxparto criaxestadoxpartoCollectionCriaxestadoxparto : oveja.getCriaxestadoxpartoCollection()) {
                Oveja oldOvejaOfCriaxestadoxpartoCollectionCriaxestadoxparto = criaxestadoxpartoCollectionCriaxestadoxparto.getOveja();
                criaxestadoxpartoCollectionCriaxestadoxparto.setOveja(oveja);
                criaxestadoxpartoCollectionCriaxestadoxparto = em.merge(criaxestadoxpartoCollectionCriaxestadoxparto);
                if (oldOvejaOfCriaxestadoxpartoCollectionCriaxestadoxparto != null) {
                    oldOvejaOfCriaxestadoxpartoCollectionCriaxestadoxparto.getCriaxestadoxpartoCollection().remove(criaxestadoxpartoCollectionCriaxestadoxparto);
                    oldOvejaOfCriaxestadoxpartoCollectionCriaxestadoxparto = em.merge(oldOvejaOfCriaxestadoxpartoCollectionCriaxestadoxparto);
                }
            }
            for (Madrexestadoxparto madrexestadoxpartoCollectionMadrexestadoxparto : oveja.getMadrexestadoxpartoCollection()) {
                Oveja oldOvejaOfMadrexestadoxpartoCollectionMadrexestadoxparto = madrexestadoxpartoCollectionMadrexestadoxparto.getOveja();
                madrexestadoxpartoCollectionMadrexestadoxparto.setOveja(oveja);
                madrexestadoxpartoCollectionMadrexestadoxparto = em.merge(madrexestadoxpartoCollectionMadrexestadoxparto);
                if (oldOvejaOfMadrexestadoxpartoCollectionMadrexestadoxparto != null) {
                    oldOvejaOfMadrexestadoxpartoCollectionMadrexestadoxparto.getMadrexestadoxpartoCollection().remove(madrexestadoxpartoCollectionMadrexestadoxparto);
                    oldOvejaOfMadrexestadoxpartoCollectionMadrexestadoxparto = em.merge(oldOvejaOfMadrexestadoxpartoCollectionMadrexestadoxparto);
                }
            }
            for (Historialxovejaxcorral historialxovejaxcorralCollectionHistorialxovejaxcorral : oveja.getHistorialxovejaxcorralCollection()) {
                Oveja oldOvejaOfHistorialxovejaxcorralCollectionHistorialxovejaxcorral = historialxovejaxcorralCollectionHistorialxovejaxcorral.getOveja();
                historialxovejaxcorralCollectionHistorialxovejaxcorral.setOveja(oveja);
                historialxovejaxcorralCollectionHistorialxovejaxcorral = em.merge(historialxovejaxcorralCollectionHistorialxovejaxcorral);
                if (oldOvejaOfHistorialxovejaxcorralCollectionHistorialxovejaxcorral != null) {
                    oldOvejaOfHistorialxovejaxcorralCollectionHistorialxovejaxcorral.getHistorialxovejaxcorralCollection().remove(historialxovejaxcorralCollectionHistorialxovejaxcorral);
                    oldOvejaOfHistorialxovejaxcorralCollectionHistorialxovejaxcorral = em.merge(oldOvejaOfHistorialxovejaxcorralCollectionHistorialxovejaxcorral);
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
            Collection<Criaxestadoxparto> criaxestadoxpartoCollectionOld = persistentOveja.getCriaxestadoxpartoCollection();
            Collection<Criaxestadoxparto> criaxestadoxpartoCollectionNew = oveja.getCriaxestadoxpartoCollection();
            Collection<Madrexestadoxparto> madrexestadoxpartoCollectionOld = persistentOveja.getMadrexestadoxpartoCollection();
            Collection<Madrexestadoxparto> madrexestadoxpartoCollectionNew = oveja.getMadrexestadoxpartoCollection();
            Collection<Historialxovejaxcorral> historialxovejaxcorralCollectionOld = persistentOveja.getHistorialxovejaxcorralCollection();
            Collection<Historialxovejaxcorral> historialxovejaxcorralCollectionNew = oveja.getHistorialxovejaxcorralCollection();
            Collection<Servicio> servicioCollectionOld = persistentOveja.getServicioCollection();
            Collection<Servicio> servicioCollectionNew = oveja.getServicioCollection();
            Collection<Servicio> servicioCollection1Old = persistentOveja.getServicioCollection1();
            Collection<Servicio> servicioCollection1New = oveja.getServicioCollection1();
            List<String> illegalOrphanMessages = null;
            for (Criaxestadoxparto criaxestadoxpartoCollectionOldCriaxestadoxparto : criaxestadoxpartoCollectionOld) {
                if (!criaxestadoxpartoCollectionNew.contains(criaxestadoxpartoCollectionOldCriaxestadoxparto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Criaxestadoxparto " + criaxestadoxpartoCollectionOldCriaxestadoxparto + " since its oveja field is not nullable.");
                }
            }
            for (Madrexestadoxparto madrexestadoxpartoCollectionOldMadrexestadoxparto : madrexestadoxpartoCollectionOld) {
                if (!madrexestadoxpartoCollectionNew.contains(madrexestadoxpartoCollectionOldMadrexestadoxparto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Madrexestadoxparto " + madrexestadoxpartoCollectionOldMadrexestadoxparto + " since its oveja field is not nullable.");
                }
            }
            for (Historialxovejaxcorral historialxovejaxcorralCollectionOldHistorialxovejaxcorral : historialxovejaxcorralCollectionOld) {
                if (!historialxovejaxcorralCollectionNew.contains(historialxovejaxcorralCollectionOldHistorialxovejaxcorral)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Historialxovejaxcorral " + historialxovejaxcorralCollectionOldHistorialxovejaxcorral + " since its oveja field is not nullable.");
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
            Collection<Criaxestadoxparto> attachedCriaxestadoxpartoCollectionNew = new ArrayList<Criaxestadoxparto>();
            for (Criaxestadoxparto criaxestadoxpartoCollectionNewCriaxestadoxpartoToAttach : criaxestadoxpartoCollectionNew) {
                criaxestadoxpartoCollectionNewCriaxestadoxpartoToAttach = em.getReference(criaxestadoxpartoCollectionNewCriaxestadoxpartoToAttach.getClass(), criaxestadoxpartoCollectionNewCriaxestadoxpartoToAttach.getCriaxestadoxpartoid());
                attachedCriaxestadoxpartoCollectionNew.add(criaxestadoxpartoCollectionNewCriaxestadoxpartoToAttach);
            }
            criaxestadoxpartoCollectionNew = attachedCriaxestadoxpartoCollectionNew;
            oveja.setCriaxestadoxpartoCollection(criaxestadoxpartoCollectionNew);
            Collection<Madrexestadoxparto> attachedMadrexestadoxpartoCollectionNew = new ArrayList<Madrexestadoxparto>();
            for (Madrexestadoxparto madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach : madrexestadoxpartoCollectionNew) {
                madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach = em.getReference(madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach.getClass(), madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach.getMadrexestadoxpartoid());
                attachedMadrexestadoxpartoCollectionNew.add(madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach);
            }
            madrexestadoxpartoCollectionNew = attachedMadrexestadoxpartoCollectionNew;
            oveja.setMadrexestadoxpartoCollection(madrexestadoxpartoCollectionNew);
            Collection<Historialxovejaxcorral> attachedHistorialxovejaxcorralCollectionNew = new ArrayList<Historialxovejaxcorral>();
            for (Historialxovejaxcorral historialxovejaxcorralCollectionNewHistorialxovejaxcorralToAttach : historialxovejaxcorralCollectionNew) {
                historialxovejaxcorralCollectionNewHistorialxovejaxcorralToAttach = em.getReference(historialxovejaxcorralCollectionNewHistorialxovejaxcorralToAttach.getClass(), historialxovejaxcorralCollectionNewHistorialxovejaxcorralToAttach.getHistorialxovejaxcorralid());
                attachedHistorialxovejaxcorralCollectionNew.add(historialxovejaxcorralCollectionNewHistorialxovejaxcorralToAttach);
            }
            historialxovejaxcorralCollectionNew = attachedHistorialxovejaxcorralCollectionNew;
            oveja.setHistorialxovejaxcorralCollection(historialxovejaxcorralCollectionNew);
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
            for (Criaxestadoxparto criaxestadoxpartoCollectionNewCriaxestadoxparto : criaxestadoxpartoCollectionNew) {
                if (!criaxestadoxpartoCollectionOld.contains(criaxestadoxpartoCollectionNewCriaxestadoxparto)) {
                    Oveja oldOvejaOfCriaxestadoxpartoCollectionNewCriaxestadoxparto = criaxestadoxpartoCollectionNewCriaxestadoxparto.getOveja();
                    criaxestadoxpartoCollectionNewCriaxestadoxparto.setOveja(oveja);
                    criaxestadoxpartoCollectionNewCriaxestadoxparto = em.merge(criaxestadoxpartoCollectionNewCriaxestadoxparto);
                    if (oldOvejaOfCriaxestadoxpartoCollectionNewCriaxestadoxparto != null && !oldOvejaOfCriaxestadoxpartoCollectionNewCriaxestadoxparto.equals(oveja)) {
                        oldOvejaOfCriaxestadoxpartoCollectionNewCriaxestadoxparto.getCriaxestadoxpartoCollection().remove(criaxestadoxpartoCollectionNewCriaxestadoxparto);
                        oldOvejaOfCriaxestadoxpartoCollectionNewCriaxestadoxparto = em.merge(oldOvejaOfCriaxestadoxpartoCollectionNewCriaxestadoxparto);
                    }
                }
            }
            for (Madrexestadoxparto madrexestadoxpartoCollectionNewMadrexestadoxparto : madrexestadoxpartoCollectionNew) {
                if (!madrexestadoxpartoCollectionOld.contains(madrexestadoxpartoCollectionNewMadrexestadoxparto)) {
                    Oveja oldOvejaOfMadrexestadoxpartoCollectionNewMadrexestadoxparto = madrexestadoxpartoCollectionNewMadrexestadoxparto.getOveja();
                    madrexestadoxpartoCollectionNewMadrexestadoxparto.setOveja(oveja);
                    madrexestadoxpartoCollectionNewMadrexestadoxparto = em.merge(madrexestadoxpartoCollectionNewMadrexestadoxparto);
                    if (oldOvejaOfMadrexestadoxpartoCollectionNewMadrexestadoxparto != null && !oldOvejaOfMadrexestadoxpartoCollectionNewMadrexestadoxparto.equals(oveja)) {
                        oldOvejaOfMadrexestadoxpartoCollectionNewMadrexestadoxparto.getMadrexestadoxpartoCollection().remove(madrexestadoxpartoCollectionNewMadrexestadoxparto);
                        oldOvejaOfMadrexestadoxpartoCollectionNewMadrexestadoxparto = em.merge(oldOvejaOfMadrexestadoxpartoCollectionNewMadrexestadoxparto);
                    }
                }
            }
            for (Historialxovejaxcorral historialxovejaxcorralCollectionNewHistorialxovejaxcorral : historialxovejaxcorralCollectionNew) {
                if (!historialxovejaxcorralCollectionOld.contains(historialxovejaxcorralCollectionNewHistorialxovejaxcorral)) {
                    Oveja oldOvejaOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral = historialxovejaxcorralCollectionNewHistorialxovejaxcorral.getOveja();
                    historialxovejaxcorralCollectionNewHistorialxovejaxcorral.setOveja(oveja);
                    historialxovejaxcorralCollectionNewHistorialxovejaxcorral = em.merge(historialxovejaxcorralCollectionNewHistorialxovejaxcorral);
                    if (oldOvejaOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral != null && !oldOvejaOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral.equals(oveja)) {
                        oldOvejaOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral.getHistorialxovejaxcorralCollection().remove(historialxovejaxcorralCollectionNewHistorialxovejaxcorral);
                        oldOvejaOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral = em.merge(oldOvejaOfHistorialxovejaxcorralCollectionNewHistorialxovejaxcorral);
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
            Collection<Criaxestadoxparto> criaxestadoxpartoCollectionOrphanCheck = oveja.getCriaxestadoxpartoCollection();
            for (Criaxestadoxparto criaxestadoxpartoCollectionOrphanCheckCriaxestadoxparto : criaxestadoxpartoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Oveja (" + oveja + ") cannot be destroyed since the Criaxestadoxparto " + criaxestadoxpartoCollectionOrphanCheckCriaxestadoxparto + " in its criaxestadoxpartoCollection field has a non-nullable oveja field.");
            }
            Collection<Madrexestadoxparto> madrexestadoxpartoCollectionOrphanCheck = oveja.getMadrexestadoxpartoCollection();
            for (Madrexestadoxparto madrexestadoxpartoCollectionOrphanCheckMadrexestadoxparto : madrexestadoxpartoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Oveja (" + oveja + ") cannot be destroyed since the Madrexestadoxparto " + madrexestadoxpartoCollectionOrphanCheckMadrexestadoxparto + " in its madrexestadoxpartoCollection field has a non-nullable oveja field.");
            }
            Collection<Historialxovejaxcorral> historialxovejaxcorralCollectionOrphanCheck = oveja.getHistorialxovejaxcorralCollection();
            for (Historialxovejaxcorral historialxovejaxcorralCollectionOrphanCheckHistorialxovejaxcorral : historialxovejaxcorralCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Oveja (" + oveja + ") cannot be destroyed since the Historialxovejaxcorral " + historialxovejaxcorralCollectionOrphanCheckHistorialxovejaxcorral + " in its historialxovejaxcorralCollection field has a non-nullable oveja field.");
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
            Query q = em.createQuery("select object(o) from Oveja as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Oveja> findListaOvejaPorCorral(Integer corralid) {
        EntityManager em = getEntityManager();
        try{
            Query q  = em.createQuery("select object(o) from Oveja as o where corralid = " + corralid);

            return q.getResultList();
        } finally {
            em.close();
        }
    }

   public List<Oveja> findListaOvejaNoEstanCorral(Integer corralid){
        EntityManager em = getEntityManager();
        try{
            Query q  = em.createQuery("select object(o) from Oveja as o where corralid <> " + corralid);

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
            Query q = em.createQuery("select count(o) from Oveja as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
