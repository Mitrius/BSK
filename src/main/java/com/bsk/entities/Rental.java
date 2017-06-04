package com.bsk.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Mitrius on 02.04.17.
 */
@Entity
@Table(name = "Rentals")
@Getter
@Setter
public class Rental implements Serializable, EntityBSKClass {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @Column(name = "cost")
    private double cost;
    @Column(name = "rentalDate")
    private Date rentalDate;
    @Column(name = "tillDate")
    private Date tillDate;

    @ManyToOne
    @JoinColumn(name = "transaction")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ShopTransaction transaction;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "video")
    private Video video;

    public String getHeader() {
        return "id;cost;rentalDate;tillDate;transactionID;videoID";
    }

    @Override
    public Integer getKey() {
        return id;
    }

    public String toString() {
        return id + ";" + cost + ";" + rentalDate.toString() + ";" + tillDate.toString()
                + ";" + transaction.getId() + ";" + video.getId();
    }
}
