package com.qfedu.common.vo;

import java.util.List;

public class Analysevo {

    private int id;

    private int wid;

    private String title;

    private String content;

    private String createtime;

    private List<String> picurl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public List<String> getPicurl() {
        return picurl;
    }

    public void setPicurl(List<String> picurl) {
        this.picurl = picurl;
    }
}
