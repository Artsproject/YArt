package com.qfedu.common.vo;

import com.qfedu.domain.Artist;
import com.qfedu.domain.WorkItem;

import java.util.Date;

/**
 * 作者：lienzhao
 * 时间：2018/9/26 0026 20:11
 */
public class OrderItemVo {

    private Integer orderItemId;

    private Integer wid;
    private String picurl;
    private String workName;
    private Integer workPrice;
    private Integer wide;
    private Integer high;
    private Integer deep;

    private Integer artistId;
    private String artistName;

    private Integer count;
    private Integer framePrice;//装裱费用
    private Integer transPrice;//运输费用
    private String frameType;//装裱类型
    private String cardType;//卡纸类型
    private Integer printNo;//版号

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Integer getWorkPrice() {
        return workPrice;
    }

    public void setWorkPrice(Integer workPrice) {
        this.workPrice = workPrice;
    }

    public Integer getWide() {
        return wide;
    }

    public void setWide(Integer wide) {
        this.wide = wide;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getFramePrice() {
        return framePrice;
    }

    public void setFramePrice(Integer framePrice) {
        this.framePrice = framePrice;
    }

    public Integer getTransPrice() {
        return transPrice;
    }

    public void setTransPrice(Integer transPrice) {
        this.transPrice = transPrice;
    }

    public String getFrameType() {
        return frameType;
    }

    public void setFrameType(String frameType) {
        this.frameType = frameType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getPrintNo() {
        return printNo;
    }

    public void setPrintNo(Integer printNo) {
        this.printNo = printNo;
    }
}


