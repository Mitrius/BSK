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
public class Employee implements Serializable {
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
    @Column(name = "objectClass")
    private Integer objectClass;
    @Column(name = "userClearanceLevel")
    private String userClearanceLevel;

    @OneToMany(mappedBy = "employee")
    private Set<ShopTransaction> transactions;
    @OneToMany(mappedBy = "employee")
    private Set<AccessLevelChange> accessLevelChanges;
}