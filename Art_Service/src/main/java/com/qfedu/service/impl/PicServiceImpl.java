package com.qfedu.service.impl;

import com.qfedu.domain.Pic;
import com.qfedu.mapper.PicMapper;
import com.qfedu.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PicServiceImpl implements PicService {
    @Autowired
    private PicMapper mapper;


    @Override
    public List<Pic> showFor() {
        return mapper.showFor();
    }
}
