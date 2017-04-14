package com.bsk.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Mitrius on 08.04.17.
 */
@Entity
@Data
public class TableClassLevel {
    @Id
    @GeneratedValue
    Integer id;

    @Column(name = "tableName")
    String tableName;

    @Column(name = "classLevel")
    Integer classLevel;
}
