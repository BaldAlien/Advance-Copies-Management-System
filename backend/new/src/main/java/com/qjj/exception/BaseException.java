package com.qjj.exception;

import com.qjj.enums.ResultStatusType;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/**
 * <p>
 *      自定义异常类
 * </p>
 *
 * @author 周建伟
 * @date 2022/3/9
 */
public class BaseException extends RuntimeException{
    private final long serialVersionUID = 1L;

    @NotNull
    private final ResultStatusType errorStatus;


    public BaseException(@NotNull String message){
        super(message);
        Intrinsics.checkNotNullParameter(message,"message");
        this.errorStatus = ResultStatusType.FAIL;
    }

    public BaseException(@NotNull Object message) {
        super(message.toString());
        Intrinsics.checkNotNullParameter(message,"message");
        this.errorStatus = ResultStatusType.FAIL;
    }

    @NotNull
    public final ResultStatusType getErrorStatus() {
        return this.errorStatus;
    }

}
