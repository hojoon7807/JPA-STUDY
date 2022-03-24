package jpabook.jpashop;

import jpql.domain.Member3;
import jpql.domain.Member3DTO;
import jpql.domain.Team3;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team3 team = new Team3();
            team.setName("OB");
            em.persist(team);

            Member3 member = new Member3();
            member.setAge(20);
            member.setUsername("Hojoon");
            member.changeTeam(team);
            em.persist(member);

            em.flush();
            em.clear();
            List<Member3DTO> resultList = em.createQuery("select new jpql.domain.Member3DTO(m.age,m.username) from Member3 as m", Member3DTO.class)
                    .getResultList();

            List<Member3> resultList1 = em.createQuery("select m from Member3 as m order by m.age desc", Member3.class)
                    .setFirstResult(0)
                    .setMaxResults(5)
                    .getResultList();

            List<Member3> resultList2 = em.createQuery("select m from Member3 as m inner join m.team t", Member3.class)
                    .getResultList();


            Member3DTO memberDTO = resultList.get(0);
            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
            System.out.println("memberDTO.getUsername() = " + memberDTO.getAge());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
