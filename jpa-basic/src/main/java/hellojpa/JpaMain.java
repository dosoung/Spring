package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //entityManagerFactory == emf
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //entityManager ==em
        EntityManager em = emf.createEntityManager();


        //데이타 베이스 트랜잭션 시
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setId(3L);
            member.setName("HelloC");
            //member를 db에 저장
            em.persist(member);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
