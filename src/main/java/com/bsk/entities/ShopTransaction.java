package com.bsk.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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
