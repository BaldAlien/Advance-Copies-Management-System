package com.qjj.utils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.diboot.core.binding.query.dynamic.ExtQueryWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.Null;

/**
 * <p>
 *
 * </p>
 *
 * @author 周建伟
 * @date 2022/3/15
 */


public final class QueryBuilder {

    @NotNull
    public static final QueryWrapper toQueryWrapper(@Nullable Object dto){
        return com.diboot.core.binding.QueryBuilder.toQueryWrapper(dto);
    }

    @NotNull
    public static final ExtQueryWrapper toExtQueryWrapper(@Nullable Object dto){
        return com.diboot.core.binding.QueryBuilder.toDynamicJoinQueryWrapper(dto);
    }

    @NotNull
    public static final LambdaQueryWrapper toLambdaQueryWrapper(@Nullable Object dto){
        return com.diboot.core.binding.QueryBuilder.toLambdaQueryWrapper(dto);
    }



}
