package com.bsk.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "Customers")
public class Customer implements Serializable, EntityBSKClass {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private Set<ShopTransaction> transactionSet;

    public Integer getKey() {
        return id;
    }

    public String getHeader() {
        return "id;name;surname";
    }
    public String toString() {
        return id + ";" + name + ";" + surname;
    }
}
