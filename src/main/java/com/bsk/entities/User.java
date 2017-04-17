package com.bsk.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Mitrius on 02.04.17.
 */
@Entity
@Data
@Table(name = "Users")
@ToString(includeFieldNames = false)
public class User implements Serializable {
    @Id
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "role")
    String role;
    @Column(name = "enabled")
    boolean enabled;
    @Column(name = "clearanceLevel")
    Integer clearanceLevel;
}
