package com.bsk.services;

import com.bsk.dao.AbstractDao;
import com.bsk.entities.Video;
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

    public List<Object> getSpecificTable(String entityType) {
        return getProperDaoInstance(entityType).findAll();
    }

    public Object getEntry(String entityType, String id) {
        AbstractDao properDao = getProperDaoInstance(entityType);
        return properDao.findByID(properDao.convertToKeyType(id));
    }

    public void deleteEntity(String key, String entityType) {
        AbstractDao properDao = getProperDaoInstance(entityType);
        Serializable keyProper = properDao.convertToKeyType(key);
        Object obj = properDao.findByID(keyProper);
        if (obj != null)
            properDao.delete(obj);
    }



    public void insertValue(Object object) {
        String entityName = object.getClass().getSimpleName();
        getProperDaoInstance(entityName).persist(object);
    }

    public void editVideo(Video newObject, int key){
        AbstractDao properDao = getProperDaoInstance(Video.class.getSimpleName());
        Video obj = (Video) properDao.findByID(key);
        obj.setId(newObject.getId());
        obj.setPrice(newObject.getPrice());
        obj.setStatus(newObject.getStatus());
        obj.setTitle(newObject.getTitle());
        properDao.update(obj);
    }
}
