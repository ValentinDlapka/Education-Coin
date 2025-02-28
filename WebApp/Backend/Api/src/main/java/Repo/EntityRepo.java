package Repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class EntityRepo<T> {
    private Class<T> classType;
    @PersistenceContext
    protected EntityManager em;

    protected EntityRepo(Class<T> classType) {
        this.classType = classType;
    }

    protected EntityRepo() {
    }

    public T get(Long id) {
        return em.find
                (classType, id);
    }

    public List<T> getAll() {
        return em.createQuery("SELECT e FROM " + classType
                .getSimpleName() + " e", classType).getResultList();
    }

    @Transactional
    public void add(T e) {
        em.persist(e);
    }

    @Transactional
    public void update(T e) {
        em.merge(e);
    }

    @Transactional
    public void
    delete(Long id) {
        T e = get(id);
        if (e != null) em.remove(e);
    }
}
