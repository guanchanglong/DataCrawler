package com.dao;

import com.entity.SpotDetail;
import org.apache.ibatis.annotations.Param;

/**
 * @author 小关同学
 * @create 2021/11/7
 */
public interface SpotDetailDao {
    void insertSpotDetailData(@Param("spotDetail") SpotDetail spotDetail);
}
