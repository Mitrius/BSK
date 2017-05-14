package com.bsk.services;

import com.bsk.dao.interfaces.TableClassLevelDao;
import com.bsk.dao.interfaces.UserDao;
import com.bsk.entities.TableClassLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service("TableInfo")
@Transactional
public class TableInfoService {

    @Autowired
    UserDao dao;
    @Autowired
    TableClassLevelDao tableClassLevelDao;

    public Boolean isReadable(String username, String tableName) {
        List<TableClassLevel> filteredTables = tableClassLevelDao
                .findAll()
                .stream()
                .filter(c -> c.getClassLevel() <= dao.findByID(username).getClearanceLevel())
                .collect(Collectors.toList());
        return filteredTables.stream().anyMatch(c -> Objects.equals(c.getTableName(), tableName));
    }

    public Boolean isWritable(String username, String tableName) {
        List<TableClassLevel> filteredTables = tableClassLevelDao
                .findAll()
                .stream()
                .filter(c -> c.getClassLevel() >= dao.findByID(username).getClearanceLevel())
                .collect(Collectors.toList());
        return filteredTables.stream().anyMatch(c -> Objects.equals(c.getTableName(), tableName));
    }

    public List<String> listAllTables() {
        List<TableClassLevel> filteredTables = tableClassLevelDao.findAll();
        return new ArrayList<>(filteredTables.stream().map(TableClassLevel::getTableName).collect(Collectors.toList()));
    }
}
