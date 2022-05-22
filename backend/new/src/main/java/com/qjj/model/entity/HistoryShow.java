package com.qjj.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryShow {
    private String historyId;
    private int userId;
    private String userName;
    private int bookId;
    private String title;
    private int count;
    private int points;
    private int sum;
    private String transactionTime;
}
