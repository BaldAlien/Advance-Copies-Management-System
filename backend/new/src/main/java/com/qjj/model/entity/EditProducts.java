package com.qjj.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditProducts {
    private Integer bookId;
    private String title;
    private String author;
    private String grade1;
    private String grade2;
    private String grade3;
    private String type;
    private String imgsrc;
    private String isbn;
    private String issn;
    private String publicationTime;
    private String wordCount;
    private String format;
    private String pageCount;
    private String bookbinding;
    private String language;
    private Integer points;
    private Character delflag;
}
