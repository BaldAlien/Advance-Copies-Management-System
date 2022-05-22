package com.qjj.DTO;

import com.qjj.exception.BaseException;
import io.swagger.annotations.ApiModelProperty;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/**
 * <p>
 *      分页查询DTO
 * </p>
 *
 * @author qjj
 * @date 2022/3/9
 */


public final class PageDTO<T>{
    @ApiModelProperty(value = "页码",required = true)
    @Nullable
    private Long pageNumber;

    @ApiModelProperty(value = "每页个数", required = true)
    @Nullable
    private Long pageSize;

    @Nullable
    public final Long getPageNumber() throws BaseException {
        if (this.pageNumber == null){
            throw new BaseException("页码不能为空");
        }else {
            return this.pageNumber;
        }
    }

    public final void setPageNumber(@Nullable Long value) throws BaseException {
        if (value == null){
            throw new BaseException("页码不能为空");
        }else {
            this.pageNumber = value;
        }
    }

    @Nullable
    public final Long getPageSize() throws BaseException {
        if (this.pageSize == null) {
            throw new BaseException("每页个数不能为空");
        } else {
            Long var10000 = this.pageSize;
            Intrinsics.checkNotNull(var10000);
            return var10000;
        }
    }

    public final void setPageSize(@Nullable Long value) throws BaseException {
        if (value == null) {
            throw new BaseException("每页个数不能为空");
        } else {
            this.pageSize = value;
        }
    }
}
