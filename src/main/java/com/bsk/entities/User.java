package com.bsk.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Mitrius on 02.04.17.
 */
@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;
    @Column(name = "salt")
    String salt;
    @Column(name = "password")
    String password;
    @Column(name = "clearanceLevel")
    Integer clearanceLevel;
}
