package com.qjj.dao;

import com.qjj.model.entity.History;

import java.util.List;

public interface HistoryDao {
    int createHistory(History history);
    List<History> getAllHistory();
    List<History> getHistoryByID(int user_id);
}
