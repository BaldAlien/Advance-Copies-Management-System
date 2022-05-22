package com.qjj.service.impl;
import com.qjj.dao.HistoryDao;
import com.qjj.model.entity.History;
import com.qjj.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryDao historyDao;

    @Override
    public int createHistory(History history){
        return historyDao.createHistory(history);
    }

    @Override
    public List<History> getAllHistory(){
        return historyDao.getAllHistory();
    }

    @Override
    public List<History> getHistoryByID(int user_id){
        return historyDao.getHistoryByID(user_id);
    }
}
