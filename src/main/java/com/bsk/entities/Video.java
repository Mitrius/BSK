package com.bsk.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by Mitrius on 14.03.17.
 */
@Data
@Entity
@AllArgsConstructor
public class Video {
    private Integer id;
    private String title;
    private Double price;
    private String status;

    @Override
    public String toString() {
        return id.toString() + "," + title + "," + price.toString() + "," + status;
    }
}
