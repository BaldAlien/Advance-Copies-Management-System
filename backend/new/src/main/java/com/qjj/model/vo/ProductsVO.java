package com.qjj.model.vo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【请填写功能名称】VO
 *
 * @author Rainbow
 * @date 2022-03-29 16:47:02
 */
@Data
public class ProductsVO {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private Long bookId;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String title;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String author;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String grade1;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String grade2;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String grade3;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String type;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String imgsrc;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String isbn;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String issn;

    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "")
    private Date publicationTime;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String wordCount;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String format;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String pageCount;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String bookbinding;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String language;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private Long points;

}
