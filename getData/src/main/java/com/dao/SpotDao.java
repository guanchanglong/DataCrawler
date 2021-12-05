package com.dao;

import com.entity.Spot;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 小关同学
 * @create 2021/11/7
 */
public interface SpotDao {
    void insertSpotData(@Param("spot") Spot spot);

    List<Spot> findAll();

    void updateSpot(@Param("spot") Spot spot,@Param("id")int id);

    Spot findAllById(@Param("id")int id);

    Spot findAllByWebId(@Param("webId")String webId);

    int countNotNullNum();

}
