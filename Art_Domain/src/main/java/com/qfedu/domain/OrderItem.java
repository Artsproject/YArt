package com.qfedu.domain;

import java.util.Date;

public class OrderItem {
    private Integer id;

    private Integer oid;

    private Integer wid;

    private Integer count;

    private Integer framePrice;//装裱费用
    private Integer transPrice;//运输费用
    private String frameType;//装裱类型
    private String cardType;//卡纸类型
    private Integer printNo;//版号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
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