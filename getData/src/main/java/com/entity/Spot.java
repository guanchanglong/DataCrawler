package com.entity;

/**
 * @author 小关同学
 * @create 2021/11/1
 * 景点
 */
public class Spot {
    private int id;
    //景点名
    private String name;
    //地点
    private String area;
    //简介
    private String info;
    //封面图片地址
    private String picture;
    //价格
    private double price;
    //详细介绍
    private String infoDetail;
    //开放时间
    private String openTime;
    //景点详情页面对应的页面id，为后续继续爬数据用
    private String spotWebId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spot spot = (Spot) o;

        if (Double.compare(spot.price, price) != 0) return false;
        if (name != null ? !name.equals(spot.name) : spot.name != null) return false;
        if (area != null ? !area.equals(spot.area) : spot.area != null) return false;
        if (info != null ? !info.equals(spot.info) : spot.info != null) return false;
        if (picture != null ? !picture.equals(spot.picture) : spot.picture != null) return false;
        if (infoDetail != null ? !infoDetail.equals(spot.infoDetail) : spot.infoDetail != null) return false;
        if (openTime != null ? !openTime.equals(spot.openTime) : spot.openTime != null) return false;
        return spotWebId != null ? spotWebId.equals(spot.spotWebId) : spot.spotWebId == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (infoDetail != null ? infoDetail.hashCode() : 0);
        result = 31 * result + (openTime != null ? openTime.hashCode() : 0);
        result = 31 * result + (spotWebId != null ? spotWebId.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfoDetail() {
        return infoDetail;
    }

    public void setInfoDetail(String infoDetail) {
        this.infoDetail = infoDetail;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getSpotWebId() {
        return spotWebId;
    }

    public void setSpotWebId(String spotWebId) {
        this.spotWebId = spotWebId;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", info='" + info + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", infoDetail='" + infoDetail + '\'' +
                ", openTime='" + openTime + '\'' +
                ", spotWebId='" + spotWebId + '\'' +
                '}';
    }

}