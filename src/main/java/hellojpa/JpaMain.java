package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        /* 등록
        try{
            Member member = new Member();
            member.setId(1L);
            member.setName("hojoon");
            em.persist(member);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        */

        /* 조회
        try{
            Member findMember = em.find(Member.class, 1L);
            System.out.println(findMember.getId());
            System.out.println(findMember.getName());
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
         */

        /* 수정
        try{
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("update hojoon");
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
         */


        try{
            //Member findMember = em.find(Member.class, 1L);
            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(5)
                    .getResultList();
            for (Member member : resultList) {
                System.out.println(member.getName());
                System.out.println(member.getId());
            }

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
