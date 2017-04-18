package com.bsk.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Mitrius on 08.04.17.
 */
@Entity
@Getter
@Setter
@Table(name = "TableClassLevels")
public class TableClassLevel implements Serializable, EntityBSKClass {
    @Id
    @Column(name = "tableName")
    String tableName;

    @Column(name = "classLevel")
    Integer classLevel;

    public String getHeader() {
        return "tableName,classLevel";
    }

    @Override
    public Serializable getKey() {
        return tableName;
    }

    public String toString() {
        return tableName + "," + classLevel;
    }
}
