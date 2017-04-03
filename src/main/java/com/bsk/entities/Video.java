package com.bsk.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Mitrius on 14.03.17.
 */
@Data
@ToString(exclude = {"id", "rentalSet"})
@Entity
@Table(name = "Videos")
public class Video implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private Double price;
    @Column(name = "status")
    private String status;
    @Column(name = "objectclass")
    private Integer objectClass;


    @OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
    private Set<Rental> rentalSet;
}