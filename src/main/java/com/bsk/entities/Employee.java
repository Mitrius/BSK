package com.bsk.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Mitrius on 14.03.17.
 */

@Entity
@Table(name = "Employees")
@Data
public class Employee implements Serializable, EntityBSKClass {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy = "employee")
    private Set<ShopTransaction> transactions;

    public String getHeader() {
        return "id,name,surname,position";
    }

    @Override
    public Integer getKey() {
        return id;
    }

    public String toString() {
        return id + "," + name + "," + surname + "," + position;
    }

}
