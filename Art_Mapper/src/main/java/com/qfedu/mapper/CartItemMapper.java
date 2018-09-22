package com.qfedu.mapper;

import com.qfedu.domain.CartItem;
import org.apache.ibatis.annotations.Param;

public interface CartItemMapper {

    int selectCountByWorkIdAndPrintNo(@Param("workId") Integer workId, @Param("printNo") Integer printNo);

    int deleteByPrimaryKey(Integer id);

    int insert(CartItem record);


}