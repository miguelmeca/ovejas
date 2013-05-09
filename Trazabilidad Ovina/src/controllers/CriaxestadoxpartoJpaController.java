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
import model.Criaxestadoxparto;
import model.Parto;
import model.Oveja;
import model.Estado;

/**
 *
 * @author laura
 */
public class CriaxestadoxpartoJpaController {

    public CriaxestadoxpartoJpaController() {
        emf = Persistence.createEntityManagerFactory("REEMPLAZARPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Criaxestadoxparto criaxestadoxparto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Parto parto = criaxestadoxparto.getParto();
            if (parto != null) {
                parto = em.getReference(parto.getClass(), parto.getPartoid());
                criaxestadoxparto.setParto(parto);
            }
            Oveja oveja = criaxestadoxparto.getOveja();
            if (oveja != null) {
                oveja = em.getReference(oveja.getClass(), oveja.getOvejaid());
                criaxestadoxparto.setOveja(oveja);
            }
            Estado estado = criaxestadoxparto.getEstado();
            if (estado != null) {
                estado = em.getReference(estado.getClass(), estado.getEstadoid());
                criaxestadoxparto.setEstado(estado);
            }
            em.persist(criaxestadoxparto);
            if (parto != null) {
                parto.getCriaxestadoxpartoCollection().add(criaxestadoxparto);
                parto = em.merge(parto);
            }
            if (oveja != null) {
                oveja.getCriaxestadoxpartoCollection().add(criaxestadoxparto);
                oveja = em.merge(oveja);
            }
            if (estado != null) {
                estado.getCriaxestadoxpartoCollection().add(criaxestadoxparto);
                estado = em.merge(estado);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Criaxestadoxparto criaxestadoxparto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Criaxestadoxparto persistentCriaxestadoxparto = em.find(Criaxestadoxparto.class, criaxestadoxparto.getCriaxestadoxpartoid());
            Parto partoOld = persistentCriaxestadoxparto.getParto();
            Parto partoNew = criaxestadoxparto.getParto();
            Oveja ovejaOld = persistentCriaxestadoxparto.getOveja();
            Oveja ovejaNew = criaxestadoxparto.getOveja();
            Estado estadoOld = persistentCriaxestadoxparto.getEstado();
            Estado estadoNew = criaxestadoxparto.getEstado();
            if (partoNew != null) {
                partoNew = em.getReference(partoNew.getClass(), partoNew.getPartoid());
                criaxestadoxparto.setParto(partoNew);
            }
            if (ovejaNew != null) {
                ovejaNew = em.getReference(ovejaNew.getClass(), ovejaNew.getOvejaid());
                criaxestadoxparto.setOveja(ovejaNew);
            }
            if (estadoNew != null) {
                estadoNew = em.getReference(estadoNew.getClass(), estadoNew.getEstadoid());
                criaxestadoxparto.setEstado(estadoNew);
            }
            criaxestadoxparto = em.merge(criaxestadoxparto);
            if (partoOld != null && !partoOld.equals(partoNew)) {
                partoOld.getCriaxestadoxpartoCollection().remove(criaxestadoxparto);
                partoOld = em.merge(partoOld);
            }
            if (partoNew != null && !partoNew.equals(partoOld)) {
                partoNew.getCriaxestadoxpartoCollection().add(criaxestadoxparto);
                partoNew = em.merge(partoNew);
            }
            if (ovejaOld != null && !ovejaOld.equals(ovejaNew)) {
                ovejaOld.getCriaxestadoxpartoCollection().remove(criaxestadoxparto);
                ovejaOld = em.merge(ovejaOld);
            }
            if (ovejaNew != null && !ovejaNew.equals(ovejaOld)) {
                ovejaNew.getCriaxestadoxpartoCollection().add(criaxestadoxparto);
                ovejaNew = em.merge(ovejaNew);
            }
            if (estadoOld != null && !estadoOld.equals(estadoNew)) {
                estadoOld.getCriaxestadoxpartoCollection().remove(criaxestadoxparto);
                estadoOld = em.merge(estadoOld);
            }
            if (estadoNew != null && !estadoNew.equals(estadoOld)) {
                estadoNew.getCriaxestadoxpartoCollection().add(criaxestadoxparto);
                estadoNew = em.merge(estadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = criaxestadoxparto.getCriaxestadoxpartoid();
                if (findCriaxestadoxparto(id) == null) {
                    throw new NonexistentEntityException("The criaxestadoxparto with id " + id + " no longer exists.");
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
            Criaxestadoxparto criaxestadoxparto;
            try {
                criaxestadoxparto = em.getReference(Criaxestadoxparto.class, id);
                criaxestadoxparto.getCriaxestadoxpartoid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The criaxestadoxparto with id " + id + " no longer exists.", enfe);
            }
            Parto parto = criaxestadoxparto.getParto();
            if (parto != null) {
                parto.getCriaxestadoxpartoCollection().remove(criaxestadoxparto);
                parto = em.merge(parto);
            }
            Oveja oveja = criaxestadoxparto.getOveja();
            if (oveja != null) {
                oveja.getCriaxestadoxpartoCollection().remove(criaxestadoxparto);
                oveja = em.merge(oveja);
            }
            Estado estado = criaxestadoxparto.getEstado();
            if (estado != null) {
                estado.getCriaxestadoxpartoCollection().remove(criaxestadoxparto);
                estado = em.merge(estado);
            }
            em.remove(criaxestadoxparto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Criaxestadoxparto> findCriaxestadoxpartoEntities() {
        return findCriaxestadoxpartoEntities(true, -1, -1);
    }

    public List<Criaxestadoxparto> findCriaxestadoxpartoEntities(int maxResults, int firstResult) {
        return findCriaxestadoxpartoEntities(false, maxResults, firstResult);
    }

    private List<Criaxestadoxparto> findCriaxestadoxpartoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Criaxestadoxparto as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Criaxestadoxparto findCriaxestadoxparto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Criaxestadoxparto.class, id);
        } finally {
            em.close();
        }
    }

    public int getCriaxestadoxpartoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Criaxestadoxparto as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
