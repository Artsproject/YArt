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

    private WorkItem workItem;
    private Artist artist;

    private Date createdate;
    private Integer framePrice;//装裱费用
    private Integer transPrice;//运输费用
    private String frameType;//装裱类型
    private String cardType;//卡纸类型
    private Integer printNo;//版号

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public WorkItem getWorkItem() {
        return workItem;
    }

    public void setWorkItem(WorkItem workItem) {
        this.workItem = workItem;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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


