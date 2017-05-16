package com.bsk.services;

import com.bsk.dao.AbstractDao;
import com.bsk.entities.*;
import org.springframework.beans.BeanUtils;
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
public class UserTableAccessInfoService {

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

    public void editVideo(Video newObject, String key){
        AbstractDao properDao = getProperDaoInstance(Video.class.getSimpleName());
        Video obj = (Video) properDao.findByID(properDao.convertToKeyType(key));
        if (obj == null) return;
        //obj.setId(newObject.getId());
        obj.setPrice(newObject.getPrice());
        obj.setStatus(newObject.getStatus());
        obj.setTitle(newObject.getTitle());
        properDao.update(obj);
    }

    public void editUser(User newObject, String key){
        AbstractDao properDao = getProperDaoInstance(User.class.getSimpleName());
        User obj = (User) properDao.findByID(properDao.convertToKeyType(key));
        if (obj == null) return; //Nie powinno wystąpić, transakcja
        BeanUtils.copyProperties(newObject, obj);

        properDao.update(obj);
    }

    public void editTableClassLevel(TableClassLevel newObject, String key){
        AbstractDao properDao = getProperDaoInstance(TableClassLevel.class.getSimpleName());
        TableClassLevel obj = (TableClassLevel) properDao.findByID(properDao.convertToKeyType(key));
        if (obj == null) return;
        obj.setClassLevel(newObject.getClassLevel());
        //obj.setTableName(newObject.getTableName());
        properDao.update(obj);
    }

    public void editShopTransaction(ShopTransaction newObject, String key){
        AbstractDao properDao = getProperDaoInstance(ShopTransaction.class.getSimpleName());
        ShopTransaction obj = (ShopTransaction) properDao.findByID(properDao.convertToKeyType(key));
        if (obj == null) return;
        obj.setCustomer(newObject.getCustomer());
        obj.setEmployee(newObject.getEmployee());
        //obj.setId(newObject.getId());
        properDao.update(obj);
    }

    public void editRental(Rental newObject, String key){
        AbstractDao properDao = getProperDaoInstance(Rental.class.getSimpleName());
        Rental obj = (Rental) properDao.findByID(properDao.convertToKeyType(key));
        if (obj == null) return;
        obj.setCost(newObject.getCost());
        obj.setRentalDate(newObject.getRentalDate());
        obj.setTillDate(newObject.getTillDate());
        obj.setVideo(newObject.getVideo());
        obj.setTransaction(newObject.getTransaction());
        //obj.setId(newObject.getId());
        properDao.update(obj);
    }

    public void editEmployee(Employee newObject, String key){
        AbstractDao properDao = getProperDaoInstance(Employee.class.getSimpleName());
        Employee obj = (Employee) properDao.findByID(properDao.convertToKeyType(key));
        if (obj == null) return;
        obj.setName(newObject.getName());
        obj.setPosition(newObject.getPosition());
        obj.setSurname(newObject.getSurname());
        //obj.setId(newObject.getId());
        properDao.update(obj);
    }

    public void editCustomer(Customer newObject, String key){
        AbstractDao properDao = getProperDaoInstance(Customer.class.getSimpleName());
        Customer obj = (Customer) properDao.findByID(properDao.convertToKeyType(key));
        if (obj == null) return;
        obj.setName(newObject.getName());
        obj.setSurname(newObject.getSurname());
        //obj.setId(newObject.getId());
        properDao.update(obj);
    }
}
