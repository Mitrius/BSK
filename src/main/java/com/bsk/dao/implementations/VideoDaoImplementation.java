package com.bsk.dao.implementations;

import com.bsk.dao.AbstractDao;
import com.bsk.dao.interfaces.VideoDao;
import com.bsk.entities.Video;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
@Repository("videoDao")
public class VideoDaoImplementation extends AbstractDao<Integer, Video> implements VideoDao {
    @Transactional
    @Override
    public Video findByID(Integer id) {
        Video video = getByKey(id);
        if (video != null) {
            Hibernate.initialize(video.getRentalSet());
        }
        return video;
    }

    @Override
    public void save(Video video) {
        persist(video);
    }

    @Override
    public List<Video> findAllVideos() {
        Criteria criteria = createEntityCriteria();
        return (List<Video>) criteria.list();
    }
}
