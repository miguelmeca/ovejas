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
import model.Criaxestadoxparto;
import java.util.ArrayList;
import java.util.Collection;
import model.Madrexestadoxparto;

/**
 *
 * @author laura
 */
public class PartoJpaController {

    public PartoJpaController() {
        emf = Persistence.createEntityManagerFactory("REEMPLAZARPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Parto parto) {
        if (parto.getCriaxestadoxpartoCollection() == null) {
            parto.setCriaxestadoxpartoCollection(new ArrayList<Criaxestadoxparto>());
        }
        if (parto.getMadrexestadoxpartoCollection() == null) {
            parto.setMadrexestadoxpartoCollection(new ArrayList<Madrexestadoxparto>());
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
            Collection<Criaxestadoxparto> attachedCriaxestadoxpartoCollection = new ArrayList<Criaxestadoxparto>();
            for (Criaxestadoxparto criaxestadoxpartoCollectionCriaxestadoxpartoToAttach : parto.getCriaxestadoxpartoCollection()) {
                criaxestadoxpartoCollectionCriaxestadoxpartoToAttach = em.getReference(criaxestadoxpartoCollectionCriaxestadoxpartoToAttach.getClass(), criaxestadoxpartoCollectionCriaxestadoxpartoToAttach.getCriaxestadoxpartoid());
                attachedCriaxestadoxpartoCollection.add(criaxestadoxpartoCollectionCriaxestadoxpartoToAttach);
            }
            parto.setCriaxestadoxpartoCollection(attachedCriaxestadoxpartoCollection);
            Collection<Madrexestadoxparto> attachedMadrexestadoxpartoCollection = new ArrayList<Madrexestadoxparto>();
            for (Madrexestadoxparto madrexestadoxpartoCollectionMadrexestadoxpartoToAttach : parto.getMadrexestadoxpartoCollection()) {
                madrexestadoxpartoCollectionMadrexestadoxpartoToAttach = em.getReference(madrexestadoxpartoCollectionMadrexestadoxpartoToAttach.getClass(), madrexestadoxpartoCollectionMadrexestadoxpartoToAttach.getMadrexestadoxpartoid());
                attachedMadrexestadoxpartoCollection.add(madrexestadoxpartoCollectionMadrexestadoxpartoToAttach);
            }
            parto.setMadrexestadoxpartoCollection(attachedMadrexestadoxpartoCollection);
            em.persist(parto);
            if (preniez != null) {
                preniez.getPartoCollection().add(parto);
                preniez = em.merge(preniez);
            }
            for (Criaxestadoxparto criaxestadoxpartoCollectionCriaxestadoxparto : parto.getCriaxestadoxpartoCollection()) {
                Parto oldPartoOfCriaxestadoxpartoCollectionCriaxestadoxparto = criaxestadoxpartoCollectionCriaxestadoxparto.getParto();
                criaxestadoxpartoCollectionCriaxestadoxparto.setParto(parto);
                criaxestadoxpartoCollectionCriaxestadoxparto = em.merge(criaxestadoxpartoCollectionCriaxestadoxparto);
                if (oldPartoOfCriaxestadoxpartoCollectionCriaxestadoxparto != null) {
                    oldPartoOfCriaxestadoxpartoCollectionCriaxestadoxparto.getCriaxestadoxpartoCollection().remove(criaxestadoxpartoCollectionCriaxestadoxparto);
                    oldPartoOfCriaxestadoxpartoCollectionCriaxestadoxparto = em.merge(oldPartoOfCriaxestadoxpartoCollectionCriaxestadoxparto);
                }
            }
            for (Madrexestadoxparto madrexestadoxpartoCollectionMadrexestadoxparto : parto.getMadrexestadoxpartoCollection()) {
                Parto oldPartoOfMadrexestadoxpartoCollectionMadrexestadoxparto = madrexestadoxpartoCollectionMadrexestadoxparto.getParto();
                madrexestadoxpartoCollectionMadrexestadoxparto.setParto(parto);
                madrexestadoxpartoCollectionMadrexestadoxparto = em.merge(madrexestadoxpartoCollectionMadrexestadoxparto);
                if (oldPartoOfMadrexestadoxpartoCollectionMadrexestadoxparto != null) {
                    oldPartoOfMadrexestadoxpartoCollectionMadrexestadoxparto.getMadrexestadoxpartoCollection().remove(madrexestadoxpartoCollectionMadrexestadoxparto);
                    oldPartoOfMadrexestadoxpartoCollectionMadrexestadoxparto = em.merge(oldPartoOfMadrexestadoxpartoCollectionMadrexestadoxparto);
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
            Collection<Criaxestadoxparto> criaxestadoxpartoCollectionOld = persistentParto.getCriaxestadoxpartoCollection();
            Collection<Criaxestadoxparto> criaxestadoxpartoCollectionNew = parto.getCriaxestadoxpartoCollection();
            Collection<Madrexestadoxparto> madrexestadoxpartoCollectionOld = persistentParto.getMadrexestadoxpartoCollection();
            Collection<Madrexestadoxparto> madrexestadoxpartoCollectionNew = parto.getMadrexestadoxpartoCollection();
            List<String> illegalOrphanMessages = null;
            for (Criaxestadoxparto criaxestadoxpartoCollectionOldCriaxestadoxparto : criaxestadoxpartoCollectionOld) {
                if (!criaxestadoxpartoCollectionNew.contains(criaxestadoxpartoCollectionOldCriaxestadoxparto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Criaxestadoxparto " + criaxestadoxpartoCollectionOldCriaxestadoxparto + " since its parto field is not nullable.");
                }
            }
            for (Madrexestadoxparto madrexestadoxpartoCollectionOldMadrexestadoxparto : madrexestadoxpartoCollectionOld) {
                if (!madrexestadoxpartoCollectionNew.contains(madrexestadoxpartoCollectionOldMadrexestadoxparto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Madrexestadoxparto " + madrexestadoxpartoCollectionOldMadrexestadoxparto + " since its parto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (preniezNew != null) {
                preniezNew = em.getReference(preniezNew.getClass(), preniezNew.getPreniezid());
                parto.setPreniez(preniezNew);
            }
            Collection<Criaxestadoxparto> attachedCriaxestadoxpartoCollectionNew = new ArrayList<Criaxestadoxparto>();
            for (Criaxestadoxparto criaxestadoxpartoCollectionNewCriaxestadoxpartoToAttach : criaxestadoxpartoCollectionNew) {
                criaxestadoxpartoCollectionNewCriaxestadoxpartoToAttach = em.getReference(criaxestadoxpartoCollectionNewCriaxestadoxpartoToAttach.getClass(), criaxestadoxpartoCollectionNewCriaxestadoxpartoToAttach.getCriaxestadoxpartoid());
                attachedCriaxestadoxpartoCollectionNew.add(criaxestadoxpartoCollectionNewCriaxestadoxpartoToAttach);
            }
            criaxestadoxpartoCollectionNew = attachedCriaxestadoxpartoCollectionNew;
            parto.setCriaxestadoxpartoCollection(criaxestadoxpartoCollectionNew);
            Collection<Madrexestadoxparto> attachedMadrexestadoxpartoCollectionNew = new ArrayList<Madrexestadoxparto>();
            for (Madrexestadoxparto madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach : madrexestadoxpartoCollectionNew) {
                madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach = em.getReference(madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach.getClass(), madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach.getMadrexestadoxpartoid());
                attachedMadrexestadoxpartoCollectionNew.add(madrexestadoxpartoCollectionNewMadrexestadoxpartoToAttach);
            }
            madrexestadoxpartoCollectionNew = attachedMadrexestadoxpartoCollectionNew;
            parto.setMadrexestadoxpartoCollection(madrexestadoxpartoCollectionNew);
            parto = em.merge(parto);
            if (preniezOld != null && !preniezOld.equals(preniezNew)) {
                preniezOld.getPartoCollection().remove(parto);
                preniezOld = em.merge(preniezOld);
            }
            if (preniezNew != null && !preniezNew.equals(preniezOld)) {
                preniezNew.getPartoCollection().add(parto);
                preniezNew = em.merge(preniezNew);
            }
            for (Criaxestadoxparto criaxestadoxpartoCollectionNewCriaxestadoxparto : criaxestadoxpartoCollectionNew) {
                if (!criaxestadoxpartoCollectionOld.contains(criaxestadoxpartoCollectionNewCriaxestadoxparto)) {
                    Parto oldPartoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto = criaxestadoxpartoCollectionNewCriaxestadoxparto.getParto();
                    criaxestadoxpartoCollectionNewCriaxestadoxparto.setParto(parto);
                    criaxestadoxpartoCollectionNewCriaxestadoxparto = em.merge(criaxestadoxpartoCollectionNewCriaxestadoxparto);
                    if (oldPartoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto != null && !oldPartoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto.equals(parto)) {
                        oldPartoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto.getCriaxestadoxpartoCollection().remove(criaxestadoxpartoCollectionNewCriaxestadoxparto);
                        oldPartoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto = em.merge(oldPartoOfCriaxestadoxpartoCollectionNewCriaxestadoxparto);
                    }
                }
            }
            for (Madrexestadoxparto madrexestadoxpartoCollectionNewMadrexestadoxparto : madrexestadoxpartoCollectionNew) {
                if (!madrexestadoxpartoCollectionOld.contains(madrexestadoxpartoCollectionNewMadrexestadoxparto)) {
                    Parto oldPartoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto = madrexestadoxpartoCollectionNewMadrexestadoxparto.getParto();
                    madrexestadoxpartoCollectionNewMadrexestadoxparto.setParto(parto);
                    madrexestadoxpartoCollectionNewMadrexestadoxparto = em.merge(madrexestadoxpartoCollectionNewMadrexestadoxparto);
                    if (oldPartoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto != null && !oldPartoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto.equals(parto)) {
                        oldPartoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto.getMadrexestadoxpartoCollection().remove(madrexestadoxpartoCollectionNewMadrexestadoxparto);
                        oldPartoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto = em.merge(oldPartoOfMadrexestadoxpartoCollectionNewMadrexestadoxparto);
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
            Collection<Criaxestadoxparto> criaxestadoxpartoCollectionOrphanCheck = parto.getCriaxestadoxpartoCollection();
            for (Criaxestadoxparto criaxestadoxpartoCollectionOrphanCheckCriaxestadoxparto : criaxestadoxpartoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Parto (" + parto + ") cannot be destroyed since the Criaxestadoxparto " + criaxestadoxpartoCollectionOrphanCheckCriaxestadoxparto + " in its criaxestadoxpartoCollection field has a non-nullable parto field.");
            }
            Collection<Madrexestadoxparto> madrexestadoxpartoCollectionOrphanCheck = parto.getMadrexestadoxpartoCollection();
            for (Madrexestadoxparto madrexestadoxpartoCollectionOrphanCheckMadrexestadoxparto : madrexestadoxpartoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Parto (" + parto + ") cannot be destroyed since the Madrexestadoxparto " + madrexestadoxpartoCollectionOrphanCheckMadrexestadoxparto + " in its madrexestadoxpartoCollection field has a non-nullable parto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Preniez preniez = parto.getPreniez();
            if (preniez != null) {
                preniez.getPartoCollection().remove(parto);
                preniez = em.merge(preniez);
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
