package jpql.domain;

public class Member3DTO {
    private int age;
    private String username;

    public Member3DTO(int age, String username) {
        this.age = age;
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
