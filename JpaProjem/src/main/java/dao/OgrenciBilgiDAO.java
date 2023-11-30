package dao;

import entity.OgrenciBilgi;
import util.Const;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class OgrenciBilgiDAO {

    private final EntityManagerFactory emf;

    public OgrenciBilgiDAO() {
        emf = Persistence.createEntityManagerFactory(Const.PERSISTENCE_UNIT_NAME);
    }

    public void executeInTransaction(ConsumerWithEntityManager<OgrenciBilgi> operation) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            operation.accept(em);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }

    public void insert(OgrenciBilgi ogrenciBilgi) {
        executeInTransaction(em -> em.persist(ogrenciBilgi));
    }

    public void update(OgrenciBilgi ogrenciBilgi) {
        executeInTransaction(em -> em.merge(ogrenciBilgi));
    }

    public void delete(OgrenciBilgi ogrenciBilgi) {
        executeInTransaction(em -> {
            OgrenciBilgi managedOgrenciBilgi = em.merge(ogrenciBilgi);
            em.remove(managedOgrenciBilgi);
        });
    }


    public List<OgrenciBilgi> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT o FROM OgrenciBilgi o", OgrenciBilgi.class).getResultList();
        } finally {
            em.close();
        }
    }

    @FunctionalInterface
    private interface ConsumerWithEntityManager<T> {
        void accept(EntityManager em);
    }
}
