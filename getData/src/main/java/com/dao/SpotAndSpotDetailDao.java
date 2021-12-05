package com.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author 小关同学
 * @create 2021/11/8
 */
public interface SpotAndSpotDetailDao {
    void saveRelation(@Param("id")int id,@Param("spotId") int spotId, @Param("spotDetailId") int spotDetailId);

    int countNotNullNum();
}
