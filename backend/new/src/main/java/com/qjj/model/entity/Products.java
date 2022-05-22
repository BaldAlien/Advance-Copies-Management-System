package com.qjj.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.diboot.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
//import com.qjj.model.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 【请填写功能名称】对象 products
 * 
 * @author Rainbow
 * @date 2022-03-29 16:47:02
 */
@ApiModel(value="products对象", description="【请填写功能名称】")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
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


    //声明逻辑删除
    @ApiModelProperty(value = "")
    @TableLogic
    @TableField(fill = FieldFill.INSERT) //只有插入时才赋予默认值”0“
    private String delFlag;

}
