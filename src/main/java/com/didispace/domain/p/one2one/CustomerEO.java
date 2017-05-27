package com.didispace.domain.p.one2one;

import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.*;

/**
 * Created by liuhaiyang on 2017/3/3.
 */
@Entity
@Table(name="customer") //主表
public class CustomerEO  {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="address_id")//关联的表为address表，其主键是id
    private AddressEO address;

    /////*******//////
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressEO getAddress() {
        return address;
    }

    public void setAddress(AddressEO address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}