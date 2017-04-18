package com.bsk.services;

import com.bsk.dao.AbstractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
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

    private AbstractDao getProperDaoInstance(String tableName) {
        List<AbstractDao> properDao = daos.stream()
                .filter(abstractDao -> abstractDao
                        .getClass()
                        .getName()
                        .contains(tableName))
                .collect(Collectors.toList());
        if (properDao.size() > 0)
            return properDao.get(0);
        return null;
    }

    public List<Object> getSpecificTable(String tableName) {
        return getProperDaoInstance(tableName).findAll();
    }

    public Object getVerySpecificTable(String tableName, Object id) {
        return getProperDaoInstance(tableName).getByKey((Serializable) id);
    }

    public void deleteEntity(String key, String tableName){
        AbstractDao properDao = getProperDaoInstance(tableName);
        Serializable keyProper = properDao.convertToKeyType(key);
        Object obj = properDao.findByID(keyProper);
        if (obj != null)
            properDao.delete(obj);
    }

    public void insertValue(Object object) {
        String entityName = object.getClass().getSimpleName();
        getProperDaoInstance(entityName).persist(object);
    }

}
