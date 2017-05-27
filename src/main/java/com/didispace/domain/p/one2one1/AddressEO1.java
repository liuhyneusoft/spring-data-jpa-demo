package com.didispace.domain.p.one2one1;

import javax.persistence.*;

/**
 * Created by liuhaiyang on 2017/3/3.
 */
@Entity
@Table(name="address1")//从表
public class AddressEO1 {
    @Id
    @GeneratedValue
    private long id;

    private String addres;

    //双向关联，在从表中要关联主表的一个java属性
    @OneToOne(mappedBy="address")
    private CustomerEO1 customer;
    //这里的“address”是指customer类的Address的属性名。
    //CustomerEO1类中  private AddressEO1 address; 所以这里是address

    /////*******//////
    public long getId() {
        return id;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerEO1 getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEO1 customer) {
        this.customer = customer;
    }
}