package com.qfedu.mapper;

import com.qfedu.domain.Artist;

public interface ArtistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Artist record);

    int insertSelective(Artist record);

    Artist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Artist record);

    int updateByPrimaryKey(Artist record);
}