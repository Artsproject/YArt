package com.qfedu.domain;

import java.util.Date;

public class CartItem {
    private Integer id;

    private Integer cid;

    private Integer wid;

    private Integer framePrice;//装裱费用
    private Integer transPrice;//运输费用
    private String frameType;//装裱类型
    private String cardType;//卡纸类型
    private Integer printNo;//版号

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

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }


    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", cid=" + cid +
                ", wid=" + wid +
                ", framePrice=" + framePrice +
                ", transPrice=" + transPrice +
                ", frameType='" + frameType + '\'' +
                ", cardType='" + cardType + '\'' +
                ", printNo=" + printNo +
                ", createtime=" + createtime +
                '}';
    }
}