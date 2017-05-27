package com.didispace.domain.p.person;



import javax.persistence.*;

/**
 * Created by liuhaiyang on 2017/3/3.
 */

@Entity
@Table(name="person1")
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public Person() {

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
}
