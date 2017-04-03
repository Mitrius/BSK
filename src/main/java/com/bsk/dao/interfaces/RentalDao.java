package com.bsk.dao.interfaces;

import com.bsk.entities.Rental;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
public interface RentalDao {
    Rental findByID(Integer id);

    void save(Rental rental);

    List<Rental> findAllRentals();
}
