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
import model.Estado;
import model.Madrexestadoxparto;

/**
 *
 * @author laura
 */
public class EstadoJpaController {

    public EstadoJpaController() {
        emf = Persistence.createEntityManagerFactory("REEMPLAZARPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estado estado) {
        if (estado.getCriaxestadoxpartoCollection() == null) {
            estado.setCriaxestadoxpartoCollection(new ArrayList<Criaxestadoxparto>());
        }
        if (estado.getMadrexestadoxpartoCollection() == null) {
            estado.setMadrexestadoxpartoCollection(new ArrayList<Madrexestadoxparto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Criaxestadoxparto> attachedCriaxestadoxpartoCollection = new ArrayList<Criaxestadoxparto>();
            for (Criaxestadoxparto criaxestadoxpartoCollectionCriaxestadoxpartoToAttach : estado.getCriaxestadoxpartoCollection()) {
                criaxestadoxpartoCollectionCriaxestadoxpartoToAttach = em.getReference(criaxestadoxpartoCollectionCriaxestadoxpartoToAttach.getClass(), criaxestadoxpartoCollectionCriaxestadoxpartoToAttach.getCriaxestadoxpartoid());
                attachedCriaxestadoxpartoCollection.add(criaxestadoxpartoCollectionCriaxestadoxpartoToAttach);
            }
            estado.setCriaxestadoxpartoCollection(attachedCriaxestadoxpartoCollection);
            Collection<Madrexestadoxparto> attachedMadrexestadoxpartoCollection = new ArrayList<Madrexestadoxparto>();
            for (Madrexestadoxparto madrexestadoxpartoCollectionMadrexestadoxpartoToAttach : estado.getMadrexestadoxpartoCollection()) {
                madrexestadoxpartoCollectionMadrexestadoxpartoToAttach = em.getReference(madrexestadoxpartoCollectionMadrexestadoxpartoToAttach.getClass(), madrexestadoxpartoCollectionMadrexestadoxpartoToAttach.getMadrexestadoxpartoid());
                attachedMadrexestadoxpartoCollection.add(madrexestadoxpartoCollectionMadrexestadoxpartoToAttach);
            }
            estado.setMadrexestadoxpartoCollection(attachedMadrexestadoxpartoCollection);
            em.persist(estado);
            for (Criaxestadoxparto criaxestadoxpartoCollectionCriaxestadoxparto : estado.getCriaxestadoxpartoCollection()) {
                Estado oldEstadoOfCriaxestadoxpartoCollectionCriaxestadoxparto = criaxestadoxpartoCollectionCriaxestadoxparto.getEstado();
                criaxestadoxpartoCollectionCriaxestadoxparto.setEstado(estado);
                criaxestadoxpartoCollectionCriaxestadoxparto = em.merge(criaxestadoxpartoCollectionCriaxestadoxparto);
                if (oldEstadoOfCriaxestadoxpartoCollectionCriaxestadoxparto != null) {
                    oldEstadoOfCriaxestadoxpartoCollectionCriaxestadoxparto.getCriaxestadoxpartoCollection().remove(criaxestadoxpartoCollectionCriaxestadoxparto);
                    oldEstadoOfCriaxestadoxpartoCollectionCriaxestadoxparto = em.merge(oldEstadoOfCriaxestadoxpartoCollectionCriaxestadoxparto);
                }
            }
            for (Madrexestadoxparto madrexestadoxpartoCollectionMadrexestadoxparto : estado.getMadrexestadoxpartoCollection()) {
                Estado oldEstadoOfMadrexestadoxpartoCollectionMadrexestadoxparto = madrexestadoxpartoCollectionMadrexestadoxparto.getEstado();
                madrexestadoxpartoCollectionMadrexestadoxparto.setEstado(estado);
                madrexestadoxpartoCollectionMadrexestadoxparto = em.merge(madrexestadoxpartoCollectionMadrexestadoxparto);
                if (oldEstadoOfMadrexestadoxpartoCollectionMadrexestadoxparto != null) {
                    oldEstadoOfMadrexestadoxpartoCollectionMadrexestadoxparto.getMadrexestadoxpartoCollection().remove(madrexestadoxpartoCollectionMadrexestadoxparto);
                    oldEstadoOfMadrexestadoxpartoCollectionMadrexestadoxparto = em.merge(oldEstadoOfMadrexestadoxpartoCollectionMadrexestadoxparto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estado estado) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estado persistentEstado = em.find(Estado.class, estado.getEstadoid());
            Collection<Criaxestadoxparto> criaxestadoxpartoCollectionOld = persistentEstado.getCriaxestadoxpartoCollection();
            Collection<Criaxestadoxparto> criaxestadoxpartoCollectionNew = estado.getCriaxestadoxpartoCollection();
            Collection<Madrexestadoxparto> madrexestadoxpartoCollectionOld = persistentEstado.getMadrexestadoxpartoCollection();
            Collection<Madrexestadoxparto> madrexestadoxpartoCollectionNew = estado.getMadrexestadoxpartoCollection();
            List<String> illegalOrphanMessages = null;
            for (Criaxestadoxparto criaxestadoxpartoCollectionOldCriaxestadoxparto : criaxestadoxpartoCollectionOld) {
                if (!criaxestadoxpartoCollectionNew.contains(criaxestadoxpartoCollectionOldCriaxestadoxparto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Criaxestadoxparto " + criaxestadoxpartoCollectionOldCriaxestadoxparto + " since its estado field is not nullable.");
                }
            }
            for (Madrexestadoxparto madrexestadoxpartoCollectionOldMadrexestadoxparto : madrexestadoxpartoCollectionOld) {
                if (!madrexestadoxpartoCollectionNew.contains(madrexestadoxpartoCollectionOldMadrexestadoxparto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Madrexestadoxparto " + madrexestadoxpartoCollectionOldMadrexestadoxparto + " since its estado field is not nullable.");
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
            estado.setCriaxestadoxpartoCollection(criaxestadoxpartoCollectionNew);
            Collection<Madrexestadoxparto> attachedMadrexestadoxpartoCollectionNew = new ArrayList<Madrexestadoxparto>();
            for (Madrexestadoxparto madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach : madrexestadoxpartoCollectionNew) {
                madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach = em.getReference(madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach.getClass(), madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach.getMadrexestadoxpartoid());
                attachedMadrexestadoxpartoCollectionNew.add(madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach);
            }
            madrexestadoxpartoCollectionNew = attachedMadrexestadoxpartoCollectionNew;
            estado.setMadrexestadoxpartoCollection(madrexestadoxpartoCollectionNew);
            estado = em.merge(estado);
            for (Criaxestadoxparto criaxestadoxpartoCollectionNewCriaxestadoxparto : criaxestadoxpartoCollectionNew) {
                if (!criaxestadoxpartoCollectionOld.contains(criaxestadoxpartoCollectionNewCriaxestadoxparto)) {
                    Estado oldEstadoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto = criaxestadoxpartoCollectionNewCriaxestadoxparto.getEstado();
                    criaxestadoxpartoCollectionNewCriaxestadoxparto.setEstado(estado);
                    criaxestadoxpartoCollectionNewCriaxestadoxparto = em.merge(criaxestadoxpartoCollectionNewCriaxestadoxparto);
                    if (oldEstadoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto != null && !oldEstadoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto.equals(estado)) {
                        oldEstadoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto.getCriaxestadoxpartoCollection().remove(criaxestadoxpartoCollectionNewCriaxestadoxparto);
                        oldEstadoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto = em.merge(oldEstadoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto);
                    }
                }
            }
            for (Madrexestadoxparto madrexestadoxpartoCollectionNewMadrexestadoxparto : madrexestadoxpartoCollectionNew) {
                if (!madrexestadoxpartoCollectionOld.contains(madrexestadoxpartoCollectionNewMadrexestadoxparto)) {
                    Estado oldEstadoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto = madrexestadoxpartoCollectionNewMadrexestadoxparto.getEstado();
                    madrexestadoxpartoCollectionNewMadrexestadoxparto.setEstado(estado);
                    madrexestadoxpartoCollectionNewMadrexestadoxparto = em.merge(madrexestadoxpartoCollectionNewMadrexestadoxparto);
                    if (oldEstadoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto != null && !oldEstadoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto.equals(estado)) {
                        oldEstadoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto.getMadrexestadoxpartoCollection().remove(madrexestadoxpartoCollectionNewMadrexestadoxparto);
                        oldEstadoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto = em.merge(oldEstadoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estado.getEstadoid();
                if (findEstado(id) == null) {
                    throw new NonexistentEntityException("The estado with id " + id + " no longer exists.");
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
            Estado estado;
            try {
                estado = em.getReference(Estado.class, id);
                estado.getEstadoid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estado with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Criaxestadoxparto> criaxestadoxpartoCollectionOrphanCheck = estado.getCriaxestadoxpartoCollection();
            for (Criaxestadoxparto criaxestadoxpartoCollectionOrphanCheckCriaxestadoxparto : criaxestadoxpartoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estado (" + estado + ") cannot be destroyed since the Criaxestadoxparto " + criaxestadoxpartoCollectionOrphanCheckCriaxestadoxparto + " in its criaxestadoxpartoCollection field has a non-nullable estado field.");
            }
            Collection<Madrexestadoxparto> madrexestadoxpartoCollectionOrphanCheck = estado.getMadrexestadoxpartoCollection();
            for (Madrexestadoxparto madrexestadoxpartoCollectionOrphanCheckMadrexestadoxparto : madrexestadoxpartoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Estado (" + estado + ") cannot be destroyed since the Madrexestadoxparto " + madrexestadoxpartoCollectionOrphanCheckMadrexestadoxparto + " in its madrexestadoxpartoCollection field has a non-nullable estado field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(estado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estado> findEstadoEntities() {
        return findEstadoEntities(true, -1, -1);
    }

    public List<Estado> findEstadoEntities(int maxResults, int firstResult) {
        return findEstadoEntities(false, maxResults, firstResult);
    }

    private List<Estado> findEstadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Estado as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Estado findEstado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Estado as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
