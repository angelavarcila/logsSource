/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.SystemEvents;

/**
 *
 * @author angela
 */
public class SystemEventsJpaController implements Serializable {

    public SystemEventsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public SystemEventsJpaController() {
        emf = Persistence.createEntityManagerFactory("ConsultasLogAnalyzerPU");
    }

    public void create(SystemEvents systemEvents) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(systemEvents);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SystemEvents systemEvents) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            systemEvents = em.merge(systemEvents);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = systemEvents.getId();
                if (findSystemEvents(id) == null) {
                    throw new NonexistentEntityException("The systemEvents with id " + id + " no longer exists.");
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
            SystemEvents systemEvents;
            try {
                systemEvents = em.getReference(SystemEvents.class, id);
                systemEvents.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The systemEvents with id " + id + " no longer exists.", enfe);
            }
            em.remove(systemEvents);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SystemEvents> findSystemEventsEntities() {
        return findSystemEventsEntities(true, -1, -1);
    }

    public List<SystemEvents> findSystemEventsEntities(int maxResults, int firstResult) {
        return findSystemEventsEntities(false, maxResults, firstResult);
    }

    private List<SystemEvents> findSystemEventsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SystemEvents.class));
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

    public SystemEvents findSystemEvents(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SystemEvents.class, id);
        } finally {
            em.close();
        }
    }

    public int getSystemEventsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SystemEvents> rt = cq.from(SystemEvents.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<SystemEvents> getSystemEventsByHost(String hostname) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("SystemEvents.findByFromHost");
        q.setParameter("fromHost", hostname);

        return q.getResultList();
    }

}
