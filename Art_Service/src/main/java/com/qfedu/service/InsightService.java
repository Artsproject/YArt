package com.qfedu.service;

import com.qfedu.domain.Insight;

import java.util.List;

public interface InsightService {

    List<Insight> queryHomepage();

    List<Insight> queryForDetail(int id);
}
