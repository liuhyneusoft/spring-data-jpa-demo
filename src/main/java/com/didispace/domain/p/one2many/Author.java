package com.didispace.domain.p.one2many;

/**
 * Created by liuhaiyang on 2017/3/3.
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    /**作者的名字*/
    @Column(length=32)
    private String name;

    /**作者写的书*/
    //fetch=FetchType.EAGER 如果是lazy那么查询author的时候会抛异常，提示no session
    //fetch=FetchType.LAZY
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)//级联保存、更新、删除、刷新;延迟加载
    private Set<Book> books = new HashSet<Book>();



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


    public Set<Book> getBooks() {
        return books;
    }


    public void setBooks(Set<Book> books) {
        this.books = books;
    }




}