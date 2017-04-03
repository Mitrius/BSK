package com.bsk.dao.implementations;

import com.bsk.dao.AbstractDao;
import com.bsk.dao.interfaces.AccessLevelChangeDao;
import com.bsk.entities.AccessLevelChange;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
@Repository("accessLevelChangeDao")
public class AccessLevelChangeDaoImplementation extends AbstractDao<Integer, AccessLevelChange> implements AccessLevelChangeDao {
    @Override
    public AccessLevelChange findByID(Integer id) {
        return getByKey(id);
    }

    @Override
    public void save(AccessLevelChange accessLevelChange) {
        persist(accessLevelChange);
    }

    @Override
    public List<AccessLevelChange> findAllChanges() {
        Criteria criteria = createEntityCriteria();
        List temp = criteria.list();
        return (List<AccessLevelChange>) criteria.list();
    }
}
