/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Automovil;

/**
 *
 * @author etien
 */
public class AutomovilJpaController implements Serializable {
      private EntityManagerFactory emf = null;

    public AutomovilJpaController() {
        this.emf = Persistence.createEntityManagerFactory("AutoPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear
    public void crearAutomovil(Automovil auto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(auto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Editar
    public void editarAutomovil(Automovil auto) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(auto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error al editar el automovil: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Eliminar
    public void eliminarAutomovil(int id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Automovil auto = em.find(Automovil.class, id);
            if (auto != null) {
                em.remove(auto);
                em.getTransaction().commit();
            } else {
                throw new Exception("El automovil con id " + id + " no existe.");
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

        // FIND TODOS
    public List<Automovil> findAutomovilEntities() {
        return findAutomovilEntities(true, -1, -1);
    }

    public List<Automovil> findAutomovilEntities(int maxResults, int firstResult) {
        return findAutomovilEntities(false, maxResults, firstResult);
    }

    private List<Automovil> findAutomovilEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Automovil> cq = em.getCriteriaBuilder().createQuery(Automovil.class);
            cq.select(cq.from(Automovil.class));
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

    // FIND POR ID
    public Automovil findAutomovil(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Automovil.class, id);
        } finally {
            em.close();
        }
    }

    // COUNT
    public int getAutomovilCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Automovil> rt = cq.from(Automovil.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
