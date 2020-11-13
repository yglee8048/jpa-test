package simple;

import simple.persistence.entity.TestC;
import simple.persistence.entity.TestP;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            System.out.println("INIT DATA================================");
            TestP testP = new TestP();
            testP.setId("a");
            testP.setName("a");
            em.persist(testP);

            TestC testC = new TestC();
            testC.setId("b");
            testC.setName("c");
            testC.setTestP(testP);
            testP.getChildren().add(testC);
            em.persist(testC);

            System.out.println("FLUSH & CLEAR================================");
            em.flush();
            em.clear();

            System.out.println("SELECT P================================");
            em.createQuery("select distinct p from TestP p left join fetch p.children", TestP.class)
                    .getResultList();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
