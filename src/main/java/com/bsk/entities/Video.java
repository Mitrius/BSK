package com.bsk.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mitrius on 14.03.17.
 */
@Getter
@Setter
@Entity
@Table(name = "Videos")
public class Video implements Serializable, EntityBSKClass {
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

    public String getHeader() {
        return "id,title,price,status";
    }

    @Override
    public Serializable getKey() {
        return id;
    }

    public String toString() {
        return id + "," + title + "," + price.toString() + "," + status;
    }

}
