package repositories;


import db.Connect;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;

import java.util.List;


@Transactional
public abstract class CRUD_GENERIC<T> {
    protected EntityManager em = Connect.getInsConnection().getEntityManagerFactory().createEntityManager();

    private final Class<T> entityClass;


    public CRUD_GENERIC(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    public boolean create(T entity) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(entity);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public T update(T entity) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            T updatedEntity = em.merge(entity);
            tr.commit();
            return updatedEntity;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }

    public boolean delete(T entity) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.remove(entity);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

    public T findById(Object id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        return em.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass)
                .getResultList();
    }


}
