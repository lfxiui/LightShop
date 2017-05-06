package com.service;

import com.dao.StatisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by AgZou on 2017/5/1.
 */
@Service
@Transactional
public class StatisticsService {
    @Autowired
    private StatisticsDao statisticsDao;
    public List getStatistics(){
       return statisticsDao.getStatisticsList();
    }
}
