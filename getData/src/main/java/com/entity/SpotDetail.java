package com.entity;

/**
 * @author 小关同学
 * @create 2021/11/7
 * 景点详细信息
 */
public class SpotDetail {

    //主键
    private int id;
    //标题
    private String title;
    //每个标题的简介
    private String info;
    //图片
    private String picture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "SpotDetail{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
