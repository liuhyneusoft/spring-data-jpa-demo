package com.didispace.domain.p.user;

import javax.persistence.*;


@Entity
@Table(name="user")
@NamedQueries({
        @NamedQuery(name="User.nqFindByAge",query="SELECT u FROM User u WHERE u.age > ?1"),
        @NamedQuery(name="User.nqFfindUserWithName",query="SELECT u FROM User u WHERE u.name = :name")
})
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public User(){}

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
