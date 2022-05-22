package com.qjj.model.param;

import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 【请填写功能名称】查询参数
 *
 * @author Rainbow
 * @date 2022-03-29 16:47:02
 */
@Data
public class ProductsQueryParam {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String title;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String author;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String grade1;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String grade2;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String grade3;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String type;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String imgsrc;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String isbn;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String issn;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private Date publicationTime;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String wordCount;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String format;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String pageCount;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String bookbinding;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private String language;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    @BindQuery(comparison = Comparison.EQ)
    private Long points;

}
