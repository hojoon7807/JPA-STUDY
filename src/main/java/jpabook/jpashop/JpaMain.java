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
            Team3 teamA = new Team3();
            teamA.setName("팀A");
            em.persist(teamA);

            Team3 teamB = new Team3();
            teamB.setName("팀B");
            em.persist(teamB);

            Team3 teamC = new Team3();
            teamC.setName("팀C");
            em.persist(teamC);

            Member3 member = new Member3();
            member.setAge(20);
            member.setUsername("Hojoon");
            member.changeTeam(teamA);
            em.persist(member);

            Member3 member2 = new Member3();
            member2.setAge(20);
            member2.setUsername("Hojoon2");
            member2.changeTeam(teamB);
            em.persist(member2);

            Member3 member3 = new Member3();
            member3.setAge(20);
            member3.setUsername("Hojoon3");
            member3.changeTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

//            List<Member3DTO> resultList = em.createQuery("select new jpql.domain.Member3DTO(m.age,m.username) from Member3 as m", Member3DTO.class)
//                    .getResultList();
//
//            List<Member3> resultList1 = em.createQuery("select m from Member3 as m order by m.age desc", Member3.class)
//                    .setFirstResult(0)
//                    .setMaxResults(5)
//                    .getResultList();
//
//            List<Member3> resultList2 = em.createQuery("select m from Member3 as m inner join m.team t", Member3.class)
//                    .getResultList();

            String query = "select m from Member3 m join fetch m.team";
            List<Member3> members = em.createQuery(query, Member3.class)
                    .getResultList();

            for (Member3 member1 : members) {
                System.out.println("member1.getUsername() = " + member1.getUsername()+","+
                        "teamName= " + member1.getTeam().getName());
            }


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
