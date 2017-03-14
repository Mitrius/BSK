package com.bsk.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;

/**
 * Created by Mitrius on 14.03.17.
 */
@Entity
@Getter
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String name;
    private String surname;

    @Override
    public String toString() {
        return id.toString() + "," + name + "," + surname;
    }
}
