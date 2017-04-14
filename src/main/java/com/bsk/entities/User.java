package com.bsk.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mitrius on 02.04.17.
 */
@Entity
@Data
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;
    @Column(name = "password")
    String password;
    @Column(name = "role")
    String role;
    @Column(name = "enabled")
    boolean enabled;
    @Column(name = "clearanceLevel")
    Integer clearanceLevel;
}
