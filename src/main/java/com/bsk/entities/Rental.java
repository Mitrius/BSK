package com.bsk.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Mitrius on 02.04.17.
 */
@Entity
@Table(name = "Rentals")
@Data
public class Rental implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "cost")
    private double cost;
    @Column(name = "rentalDate")
    private Date rentalDate;
    @Column(name = "tillDate")
    private Date tillDate;

    @ManyToOne
    @JoinColumn(name = "transaction")
    private ShopTransaction transaction;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Video video;

    public String toString() {
        return id + "," + cost + "," + rentalDate + "," + tillDate + "," + transaction.getId() + "," + video.getId();
    }
}
