package com.bsk.services;

import com.bsk.dao.interfaces.VideoDao;
import com.bsk.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
@Service("VideoService")
@Transactional
public class VideoService {

    @Autowired
    VideoDao videoDao;

    public Video getByID(Integer id) {
        return videoDao.findByID(id);
    }

    public List<Video> getAllVideos() {
        List<Video> temp = videoDao.findAllVideos();
        return temp;
    }

}
