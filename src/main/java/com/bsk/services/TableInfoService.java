package com.bsk.services;

import com.bsk.dao.interfaces.TableClassLevelDao;
import com.bsk.dao.interfaces.UserDao;
import com.bsk.entities.TableClassLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mitrius on 17.04.17.
 */
@Service("TableInfo")
@Transactional
public class TableInfoService {
    @Autowired
    UserDao userDao;
    @Autowired
    TableClassLevelDao tableClassLevelDao;

    public List<String> getUserPossibleTables(String username) {
        List<TableClassLevel> filteredTables = tableClassLevelDao
                .findAllTableClassLevels()
                .stream()
                .filter(c -> c.getClassLevel() <= userDao.findByID(username).getClearanceLevel())
                .collect(Collectors.toList());
        return new ArrayList<>(filteredTables.stream().map(TableClassLevel::getTableName).collect(Collectors.toList()));

    }
}
