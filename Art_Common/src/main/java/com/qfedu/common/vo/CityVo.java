package com.qfedu.common.vo;

import com.qfedu.domain.County;

import java.util.List;

/**
 * 作者：lienzhao
 * 时间：2018/9/22 0022 11:27
 */
public class CityVo {

    private Integer id;
    private String no;
    private String name;

    private List<County> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<County> getChildren() {
        return children;
    }

    public void setChildren(List<County> children) {
        this.children = children;
    }
}
