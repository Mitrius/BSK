package com.bsk.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Mitrius on 02.04.17.
 */
@Entity
@Getter
@Setter
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

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.REMOVE)
    private Set<Rental> rentalSet;

    public String getHeader() {
        return "id;employee;customer";
    }
    @Override
    public Serializable getKey() {
        return id;
    }

    public String toString() {
        return id + ";" + employee.getId() + ";" + customer.getId();
    }
}
