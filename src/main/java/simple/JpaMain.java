package simple;

import simple.persistence.entity.Member;
import simple.persistence.entity.Team;

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

        try {
            Team team1 = new Team();
            team1.setId1("team1_id1");
            team1.setId2("team1_id2");
            team1.setAtt1("team1_att1");

            Team team2 = new Team();
            team2.setId1("team2_id1");
            team2.setId2("team2_id2");
            team2.setAtt1("team2_att1");

            Member member1 = new Member();
            member1.setUid("member1_uid");
            member1.setTeam(team1);
            member1.setAtt1("member1_att1");
            team1.getMembers().add(member1);

            Member member2 = new Member();
            member2.setUid("member2_uid");
            member2.setTeam(team1);
            member2.setAtt1("member2_att1");
            team1.getMembers().add(member2);

            Member member3 = new Member();
            member3.setUid("member3_uid");
            member3.setTeam(team2);
            member3.setAtt1("member3_att1");
            team2.getMembers().add(member3);

            Member member4 = new Member();
            member4.setUid("member4_uid");
            member4.setTeam(team2);
            member4.setAtt1("member4_att1");
            team2.getMembers().add(member4);

            System.out.println("INIT DATA================================");
            em.persist(team1);
            em.persist(team2);
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);

            System.out.println("FLUSH & CLEAR================================");
            em.flush();
            em.clear();

            System.out.println("SELECT TEAM================================");
            List<Team> teamList = em.createQuery("select distinct t from Team t left outer join fetch t.members", Team.class)
                    .getResultList();

            for (Team t : teamList) {
                System.out.println("team id1 : " + t.getId1());
                System.out.println("team id2 : " + t.getId2());
                System.out.println("team member size : " + t.getMembers().size());

//                for (Member m : t.getMembers()) {
//                    System.out.println("member uid : " + m.getUid());
//                    System.out.println("member att1 : " + m.getAtt1());
//                }
            }

//            System.out.println("SELECT MEMBER================================");
//            List<Member> memberList = em.createQuery("select m from Member m join fetch m.team", Member.class)
//                    .getResultList();
//
//            for (Member m : memberList) {
//                System.out.println("member uid : " + m.getUid());
//                System.out.println("member id2 : " + m.getTeam().getId2());
//            }

//            System.out.println("TEST================================");
//            List<Member> newMembers = new ArrayList<Member>();
//
//            Member member1_change = new Member();
//            member1_change.setUid("member1_uid");
//            member1_change.setTeam(team1);
//            member1_change.setAtt1("att2");
//            newMembers.add(member1_change);
//
//            Member member5 = new Member();
//            member5.setUid("member5_uid");
//            member5.setTeam(team1);
//            member5.setAtt1("att1");
//            newMembers.add(member5);
//
//            team1.setMembers(newMembers);

//            List<Member> membersOfTeam1 = teamList.get(0).getMembers();
//            membersOfTeam1.get(0).setAtt1("att change!");
//            membersOfTeam1.add()

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
