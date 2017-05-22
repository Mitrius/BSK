package com.bsk.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mitrius on 14.03.17.
 */

@Entity
@Table(name = "Employees")
@Getter
@Setter
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

    public String getHeader() {
        return "id;name;surname;position";
    }

    @Override
    public Integer getKey() {
        return id;
    }

    public String toString() {
        return id + ";" + name + ";" + surname + ";" + position;
    }

}
