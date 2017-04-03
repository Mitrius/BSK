package com.bsk.dao.interfaces;

import com.bsk.entities.AccessLevelChange;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
public interface AccessLevelChangeDao {
    AccessLevelChange findByID(Integer id);

    void save(AccessLevelChange accessLevelChange);

    List<AccessLevelChange> findAllChanges();
}
