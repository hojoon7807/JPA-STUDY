package jpabook.jpashop;

import hellojpa.Member2;
import hellojpa.Team;

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

        try{
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member2 member = new Member2();
            member.setUsername("hojoon");
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            Member2 findMember = em.find(Member2.class, member.getId());
            Team findTeam = findMember.getTeam();
            List<Member2> members = findTeam.getMembers();

            for (Member2 m : members){
                System.out.println("m" + m.getUsername());
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
