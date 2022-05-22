package com.qjj.model.entity;

import com.diboot.core.binding.annotation.BindEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrolleyShow implements Serializable {
    private Integer bookId;
    private String title;
    private int count;
    private int points;
    private String imgSrc;
}
