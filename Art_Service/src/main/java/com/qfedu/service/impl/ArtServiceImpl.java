package com.qfedu.service.impl;

import com.qfedu.common.result.R;
import com.qfedu.common.vo.Analysevo;
import com.qfedu.domain.Analyse;
import com.qfedu.mapper.AnalyseMapper;
import com.qfedu.mapper.ArtistMapper;
import com.qfedu.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtServiceImpl implements ArtService {
    @Autowired
    private ArtistMapper mapper;

    @Autowired
    private AnalyseMapper amapper;

    @Override
    public Analyse selectBywid(int wid) {
        return amapper.selectBywid(wid);
    }


    @Override
    public List queryartists() {
        List list = mapper.queryartists();

        return list;
    }


}
