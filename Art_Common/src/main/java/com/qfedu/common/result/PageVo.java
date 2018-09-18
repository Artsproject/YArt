package com.qfedu.common.result;

import java.util.List;

public class PageVo<T> {
    private int code;
    private String msg;
    private List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static <T> PageVo<T> createPage(List<T> data, int count) {

        PageVo<T> pageVo = new PageVo<>();
        pageVo.setCode(0);
        pageVo.setMsg("ok");
        pageVo.setData(data);
        return  pageVo;
    }


    public PageVo() {}

}
