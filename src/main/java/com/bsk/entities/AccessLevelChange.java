package com.bsk.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mitrius on 02.04.17.
 */
@Entity
@Table(name = "AccessLevelChanges")
public class AccessLevelChange implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    Employee employee;

    @Column(name = "objectClass")
    Integer objectClass;


}
