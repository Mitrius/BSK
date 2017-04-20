package com.bsk.dao.implementations;

import com.bsk.dao.AbstractDao;
import com.bsk.dao.interfaces.TableClassLevelDao;
import com.bsk.entities.TableClassLevel;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mitrius on 08.04.17.
 */
@Repository("tableClassLevelDao")
public class TableClassLevelDaoImplementation extends AbstractDao<Integer, TableClassLevel>
        implements TableClassLevelDao {
    @Override
    public void save(TableClassLevel tableClassLevel) {
        persist(tableClassLevel);
    }

    @Override
    public String convertToKeyType(String key) {
        return key;
    }
    @Override
    public List<TableClassLevel> findAll() {
        Criteria crit = createEntityCriteria();
        return (List<TableClassLevel>) crit.list();
    }
}
