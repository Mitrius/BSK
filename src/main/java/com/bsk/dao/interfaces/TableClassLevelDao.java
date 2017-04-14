package com.bsk.dao.interfaces;

import com.bsk.entities.TableClassLevel;

import java.util.List;

/**
 * Created by Mitrius on 08.04.17.
 */
public interface TableClassLevelDao {
    TableClassLevel findByID(Integer id);

    void save(TableClassLevel tableClassLevel);

    List<TableClassLevel> findAllTableClassLevels();
}
