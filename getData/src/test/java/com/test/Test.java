package com.test;

import com.dao.SpotAndSpotDetailDao;
import com.dao.SpotDao;
import com.dao.SpotDetailDao;
import com.entity.Spot;
import com.entity.SpotDetail;
import com.utils.SpotDataCrawler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 小关同学
 * @create 2021/8/23
 */
public class Test {

    private InputStream in;
    private SqlSessionFactory factory;

    public SqlSession init(){
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(in);
        return factory.openSession();
    }




    public static List<Object> getAllDetailData(List<Spot> listSpot){

        List<Object> result = new ArrayList<>();
        for (int i = 0;i < listSpot.size();i++){
            Spot spot = listSpot.get(i);
            Object[] param = SpotDataCrawler.requestSpotDetailData(spot.getName(),spot.getId(),spot.getSpotWebId());

            //生成1-10的随机数
            int random = (int)(1+Math.random()*(10-1+1));
            random *= 100;
            try {
                //停顿一段时间，免得被反爬机制检测出来
                Thread.sleep(random);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("============================第"+i+"条数据=================================");
            //爬取信息是否成功
            if (param==null){
                i--;
            }else{
                //成功就添加到集合中去
                result.add(param);
            }
        }

        return result;
    }

    public static void findAllSpotNameAndSpotWebId(List<Object> param){
        Test test = new Test();
        SqlSession sessionSpot = test.init();
        SqlSession sessionSpotDetail = test.init();
        SqlSession sessionSpotAndSpotDetail = test.init();

        SpotDao spotDao = sessionSpot.getMapper(SpotDao.class);
        SpotDetailDao spotDetailDao = sessionSpotDetail.getMapper(SpotDetailDao.class);
        SpotAndSpotDetailDao spotAndSpotDetailDao = sessionSpotAndSpotDetail.getMapper(SpotAndSpotDetailDao.class);

        int totalSpotDetailSize = spotAndSpotDetailDao.countNotNullNum()+1;

        //获取所有的景点简介
        for (int i = 0;i < param.size();i++){
            Object[]data = (Object[]) param.get(i);

            Spot spotToUpdate = (Spot) data[0];
            if (spotToUpdate!=null){
                //更新Spot的详细信息
                spotDao.updateSpot(spotToUpdate,spotToUpdate.getId());
            }

            //保存每个景点对应的详细信息
            List<SpotDetail> spotDetails = (List<SpotDetail>) data[1];
            if (spotDetails!=null){
                for (SpotDetail spotDetail:spotDetails){
                    spotDetailDao.insertSpotDetailData(spotDetail);
                    //保存每个景点详细信息和景点简介信息的关系表
                    spotAndSpotDetailDao.saveRelation(totalSpotDetailSize,spotToUpdate.getId(),totalSpotDetailSize);
                    totalSpotDetailSize++;
                }
            }
        }

        sessionSpot.commit();
        sessionSpotDetail.commit();
        sessionSpotAndSpotDetail.commit();

    }

    /**
     * 爬取执行页数的景点简介数据
     * @param page
     */
    public static void getSpotData(int page){
        Test test = new Test();
        SqlSession session = test.init();
        SpotDao spotDao = session.getMapper(SpotDao.class);
        Set<Spot> list = SpotDataCrawler.requestSpotData("西安",page);
        for (Spot spot:list){
            spotDao.insertSpotData(spot);
        }
        session.commit();
    }


    public static void main(String[] args) {

        //爬取景点简介数据
//        getSpotData(10);


        //爬取景点详细数据
        Test test = new Test();
        SqlSession sessionSpot = test.init();
        SpotDao spotDao = sessionSpot.getMapper(SpotDao.class);
        List<Spot> list = spotDao.findAll();
        List<Object> data = getAllDetailData(list);
        findAllSpotNameAndSpotWebId(data);
    }
}
