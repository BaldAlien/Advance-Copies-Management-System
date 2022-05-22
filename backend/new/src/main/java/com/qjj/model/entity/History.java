package com.qjj.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {
    private int userId;
    private int bookId;
    private String title;
    private int count;
    private int points;
    private String transactionTime;
}
