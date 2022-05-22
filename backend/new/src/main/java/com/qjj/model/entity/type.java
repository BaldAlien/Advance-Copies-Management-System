package com.qjj.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class type {
    @ApiModelProperty(value = "shuji")
    private String type;
    @ApiModelProperty(value = "nianji")
    private String grade1;
}
