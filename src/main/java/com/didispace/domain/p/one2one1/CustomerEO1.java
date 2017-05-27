package com.didispace.domain.p.one2one1;

import javax.persistence.*;

/**
 * Created by liuhaiyang on 2017/3/3.
 */
@Entity
@Table(name="customer1") //主表
public class CustomerEO1 {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToOne(cascade={CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private AddressEO1 address;


    /////*******//////
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressEO1 getAddress() {
        return address;
    }

    public void setAddress(AddressEO1 address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}