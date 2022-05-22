package com.qjj.service;

import com.qjj.model.entity.History;

import java.util.List;

public interface HistoryService {
    int createHistory(History history);

    List<History> getAllHistory();
    List<History> getHistoryByID(int user_id);
}
