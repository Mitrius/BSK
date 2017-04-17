package com.bsk.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Mitrius on 08.04.17.
 */
@Entity
@Data
@Table(name = "TableClassLevels")
@ToString(includeFieldNames = false)
public class TableClassLevel {
    @Id
    @Column(name = "tableName")
    String tableName;

    @Column(name = "classLevel")
    Integer classLevel;
}
