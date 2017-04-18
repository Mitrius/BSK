package com.bsk.dao.implementations;

import com.bsk.dao.AbstractDao;
import com.bsk.dao.interfaces.VideoDao;
import com.bsk.entities.Video;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
@Repository("videoDao")
public class VideoDaoImplementation extends AbstractDao<Integer, Video> implements VideoDao {

    @Override
    public Integer convertToKeyType(String key) {
        return Integer.parseInt(key);
    }
    @Override
    public void save(Video video) {
        persist(video);
    }

    @Override
    public List<Video> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<Video>) criteria.list();
    }
}
