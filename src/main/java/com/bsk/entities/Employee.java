package com.bsk.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Mitrius on 14.03.17.
 */
@Getter
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String surname;
    private String position;

    @Override
    public String toString() {
        return id.toString() + "," + name + "," + surname + "," + position;
    }
}
