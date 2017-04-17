package com.bsk.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Mitrius on 14.03.17.
 */
@Entity
@Data
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

    @OneToMany(mappedBy = "customer")
    private Set<ShopTransaction> transactions;

    public Integer getKey() {
        return id;
    }

    public String getHeader() {
        return "id,name,surname";
    }
    public String toString() {
        return id + "," + name + "," + surname;
    }
}
