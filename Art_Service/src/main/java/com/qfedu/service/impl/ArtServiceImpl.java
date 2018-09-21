package com.qfedu.service.impl;

import com.qfedu.mapper.ArtistMapper;
import com.qfedu.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtServiceImpl implements ArtService {
    @Autowired
    private ArtistMapper mapper;

    @Override
    public List queryartists() {
        List list = mapper.queryartists();

        return list;
    }
}
