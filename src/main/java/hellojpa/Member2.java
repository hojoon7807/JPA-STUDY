package hellojpa;

import javax.persistence.*;
import java.util.Date;

public class Member2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member2() {
    }
    //Getter, Setter…


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}