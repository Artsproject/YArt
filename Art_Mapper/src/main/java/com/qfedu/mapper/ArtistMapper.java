package com.qfedu.mapper;

import com.qfedu.domain.Artist;

import java.util.List;

public interface ArtistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Artist record);

    int insertSelective(Artist record);

    Artist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Artist record);

    int updateByPrimaryKey(Artist record);
    //艺术家---首页更多艺术家展示接口
    List queryartists();
    //艺术家---首页推荐艺术家接口 (缺少主题图片和艺术家风格介绍)
    Artist selectByName(String truename);
}