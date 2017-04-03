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
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "objectClass")
    private Integer objectClass;

    @OneToMany(mappedBy = "customer")
    private Set<ShopTransaction> transactions;
}
