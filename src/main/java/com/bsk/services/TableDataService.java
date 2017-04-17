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

    public List<Object> getSpecificTable(String tableName) {
        List<Object> entitiesList = daos.stream()
                .filter(abstractDao -> abstractDao
                        .getClass()
                        .getName()
                        .contains(tableName))
                .map(AbstractDao::findAll).collect(Collectors.toList());
        return entitiesList;
    }

    public void insertValue(Object object) {
        String entityName = object.getClass().getName();
        AbstractDao properDao = daos.stream().filter(abstractDao -> abstractDao
                .getClass()
                .getName()
                .contains(entityName)).collect(Collectors.toList()).get(0);
        properDao.persist(object);
    }

}
