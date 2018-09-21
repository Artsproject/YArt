package com.qfedu.mapper;


import org.apache.ibatis.annotations.Param;

/**
 * 作者：lienzhao
 * 时间：2018/9/20 0020 19:34
 */
public interface SoldWorkMapper {

    Integer[] selectPrintNosByWorkId(Integer workId);

    int insert(@Param("workId") Integer workId, @Param("printNo") Integer printNo);

    int selectPrintCountByWorkId(Integer workId);

}