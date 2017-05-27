package com.didispace.domain.p.one2one;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
/**
 * Created by liuhaiyang on 2017/3/3.
 */
@Entity
@Table(name="address")//从表
public class AddressEO {
    @Id
    @GeneratedValue
    private long id;

    //在单项关联中，从表对应的类中不需要引用主表类

    private String addres;

    /////*******//////
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
}