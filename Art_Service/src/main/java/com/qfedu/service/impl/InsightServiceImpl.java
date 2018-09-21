package com.qfedu.service.impl;

import com.qfedu.domain.Insight;
import com.qfedu.mapper.InsightMapper;
import com.qfedu.service.InsightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InsightServiceImpl implements InsightService {
    @Autowired
    private InsightMapper mapper;

    @Override
    public List<Insight> queryHomepage() {
        List<Insight> insights = mapper.queryHomepage();
        return insights;
    }


    @Override
    public List<Insight> queryForDetail(int id) {
        return mapper.queryForDetail(id);
    }
}
