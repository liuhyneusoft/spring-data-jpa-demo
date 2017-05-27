package com.didispace.domain.p.one2many1;


import javax.persistence.*;

/**
 *  book和book1完全一样
 *
 */

@Entity
@Table(name="book1")
public class Book1 {

    @Id
    @GeneratedValue
    private Long id;

    /**书名*/
    @Column(length=32)
    private String name;

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