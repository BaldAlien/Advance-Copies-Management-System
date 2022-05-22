package com.qjj.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trolley {
    private int user_id;
    private Integer book_id;
    private int count;
}
