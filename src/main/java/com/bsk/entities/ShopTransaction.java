package com.bsk.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Mitrius on 02.04.17.
 */
@Entity
@Data
@Table(name = "ShopTransactions")
public class ShopTransaction implements Serializable, EntityBSKClass {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @OneToMany(mappedBy = "transaction")
    private Set<Rental> rentals;

    public String getHeader() {
        return "id,employee,customer";
    }

    @Override
    public Serializable getKey() {
        return id;
    }

    public String toString() {
        return id + "," + employee + "," + customer;
    }
}
