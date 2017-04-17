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
@Service("TableDataService")
@Transactional
public class TableDataService {

    @Autowired
    List<AbstractDao> daos;

    public List<Object> getSpecificTable(String tableName) {
        List<AbstractDao> properDao = daos.stream()
                .filter(abstractDao -> abstractDao
                        .getClass()
                        .getName()
                        .contains(tableName))
                .collect(Collectors.toList());
        if (properDao.size() > 0)
            return properDao.get(0).findAll();
        return null;
    }

    public Object getVerySpecificTable(String tableName, Object id) {
        List<AbstractDao> properDao = daos.stream()
                .filter(abstractDao -> abstractDao
                        .getClass()
                        .getName()
                        .contains(tableName))
                .collect(Collectors.toList());
        if (properDao.size() > 0)
            return properDao.get(0).findAll();
        return null;
    }

    public void insertValue(Object object) {
        String entityName = object.getClass().getSimpleName();
        List<AbstractDao> properDao = daos.stream()
                .filter(abstractDao -> abstractDao
                        .getClass()
                        .getName()
                        .contains(entityName))
                .collect(Collectors.toList());
        if (properDao.size() > 0)
            properDao.get(0).persist(object);
    }

}
