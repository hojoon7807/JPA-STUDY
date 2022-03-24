package jpql.domain;

import javax.persistence.*;

@Entity
public class Member3 {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team3 team;

    public void changeTeam(Team3 team){
        this.team = team;
        team.getMemebers().add(this);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team3 getTeam() {
        return team;
    }

    public void setTeam(Team3 team) {
        this.team = team;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
