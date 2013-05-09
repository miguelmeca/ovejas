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
import model.Madrexestadoxparto;
import model.Parto;
import model.Oveja;
import model.Estado;

/**
 *
 * @author laura
 */
public class MadrexestadoxpartoJpaController {

    public MadrexestadoxpartoJpaController() {
        emf = Persistence.createEntityManagerFactory("REEMPLAZARPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Madrexestadoxparto madrexestadoxparto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Parto parto = madrexestadoxparto.getParto();
            if (parto != null) {
                parto = em.getReference(parto.getClass(), parto.getPartoid());
                madrexestadoxparto.setParto(parto);
            }
            Oveja oveja = madrexestadoxparto.getOveja();
            if (oveja != null) {
                oveja = em.getReference(oveja.getClass(), oveja.getOvejaid());
                madrexestadoxparto.setOveja(oveja);
            }
            Estado estado = madrexestadoxparto.getEstado();
            if (estado != null) {
                estado = em.getReference(estado.getClass(), estado.getEstadoid());
                madrexestadoxparto.setEstado(estado);
            }
            em.persist(madrexestadoxparto);
            if (parto != null) {
                parto.getMadrexestadoxpartoCollection().add(madrexestadoxparto);
                parto = em.merge(parto);
            }
            if (oveja != null) {
                oveja.getMadrexestadoxpartoCollection().add(madrexestadoxparto);
                oveja = em.merge(oveja);
            }
            if (estado != null) {
                estado.getMadrexestadoxpartoCollection().add(madrexestadoxparto);
                estado = em.merge(estado);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Madrexestadoxparto madrexestadoxparto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Madrexestadoxparto persistentMadrexestadoxparto = em.find(Madrexestadoxparto.class, madrexestadoxparto.getMadrexestadoxpartoid());
            Parto partoOld = persistentMadrexestadoxparto.getParto();
            Parto partoNew = madrexestadoxparto.getParto();
            Oveja ovejaOld = persistentMadrexestadoxparto.getOveja();
            Oveja ovejaNew = madrexestadoxparto.getOveja();
            Estado estadoOld = persistentMadrexestadoxparto.getEstado();
            Estado estadoNew = madrexestadoxparto.getEstado();
            if (partoNew != null) {
                partoNew = em.getReference(partoNew.getClass(), partoNew.getPartoid());
                madrexestadoxparto.setParto(partoNew);
            }
            if (ovejaNew != null) {
                ovejaNew = em.getReference(ovejaNew.getClass(), ovejaNew.getOvejaid());
                madrexestadoxparto.setOveja(ovejaNew);
            }
            if (estadoNew != null) {
                estadoNew = em.getReference(estadoNew.getClass(), estadoNew.getEstadoid());
                madrexestadoxparto.setEstado(estadoNew);
            }
            madrexestadoxparto = em.merge(madrexestadoxparto);
            if (partoOld != null && !partoOld.equals(partoNew)) {
                partoOld.getMadrexestadoxpartoCollection().remove(madrexestadoxparto);
                partoOld = em.merge(partoOld);
            }
            if (partoNew != null && !partoNew.equals(partoOld)) {
                partoNew.getMadrexestadoxpartoCollection().add(madrexestadoxparto);
                partoNew = em.merge(partoNew);
            }
            if (ovejaOld != null && !ovejaOld.equals(ovejaNew)) {
                ovejaOld.getMadrexestadoxpartoCollection().remove(madrexestadoxparto);
                ovejaOld = em.merge(ovejaOld);
            }
            if (ovejaNew != null && !ovejaNew.equals(ovejaOld)) {
                ovejaNew.getMadrexestadoxpartoCollection().add(madrexestadoxparto);
                ovejaNew = em.merge(ovejaNew);
            }
            if (estadoOld != null && !estadoOld.equals(estadoNew)) {
                estadoOld.getMadrexestadoxpartoCollection().remove(madrexestadoxparto);
                estadoOld = em.merge(estadoOld);
            }
            if (estadoNew != null && !estadoNew.equals(estadoOld)) {
                estadoNew.getMadrexestadoxpartoCollection().add(madrexestadoxparto);
                estadoNew = em.merge(estadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = madrexestadoxparto.getMadrexestadoxpartoid();
                if (findMadrexestadoxparto(id) == null) {
                    throw new NonexistentEntityException("The madrexestadoxparto with id " + id + " no longer exists.");
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
            Madrexestadoxparto madrexestadoxparto;
            try {
                madrexestadoxparto = em.getReference(Madrexestadoxparto.class, id);
                madrexestadoxparto.getMadrexestadoxpartoid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The madrexestadoxparto with id " + id + " no longer exists.", enfe);
            }
            Parto parto = madrexestadoxparto.getParto();
            if (parto != null) {
                parto.getMadrexestadoxpartoCollection().remove(madrexestadoxparto);
                parto = em.merge(parto);
            }
            Oveja oveja = madrexestadoxparto.getOveja();
            if (oveja != null) {
                oveja.getMadrexestadoxpartoCollection().remove(madrexestadoxparto);
                oveja = em.merge(oveja);
            }
            Estado estado = madrexestadoxparto.getEstado();
            if (estado != null) {
                estado.getMadrexestadoxpartoCollection().remove(madrexestadoxparto);
                estado = em.merge(estado);
            }
            em.remove(madrexestadoxparto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Madrexestadoxparto> findMadrexestadoxpartoEntities() {
        return findMadrexestadoxpartoEntities(true, -1, -1);
    }

    public List<Madrexestadoxparto> findMadrexestadoxpartoEntities(int maxResults, int firstResult) {
        return findMadrexestadoxpartoEntities(false, maxResults, firstResult);
    }

    private List<Madrexestadoxparto> findMadrexestadoxpartoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Madrexestadoxparto as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Madrexestadoxparto findMadrexestadoxparto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Madrexestadoxparto.class, id);
        } finally {
            em.close();
        }
    }

    public int getMadrexestadoxpartoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Madrexestadoxparto as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
