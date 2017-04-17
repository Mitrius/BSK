package com.bsk.services;

import com.bsk.dao.AbstractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mitrius on 17.04.17.
 */
@Service("tableDataService")
@Transactional
public class TableDataService {

    @Autowired
    List<AbstractDao> daos;

    public List<String> getSpecificTable(String tableName) {
        String entityName = tableName.substring(0, tableName.length() - 1);
        List<Object> entitiesList = daos.stream()
                .filter(abstractDao -> abstractDao
                        .getClass()
                        .getName()
                        .contains(entityName))
                .map(AbstractDao::findAll).collect(Collectors.toList());
        List<String> entities = entitiesList.stream()
                .map(c -> c.toString())
                .map(c -> c.replaceAll("[^a-zA-Z0-9,]", ""))
                .collect(Collectors.toList());
        return entities;
    }

}
