package com.bsk.dao.interfaces;

import com.bsk.entities.Video;

import java.util.List;

/**
 * Created by Mitrius on 03.04.17.
 */
public interface VideoDao {
    Video findByID(Integer id);

    void save(Video video);

    List<Video> findAll();
}
