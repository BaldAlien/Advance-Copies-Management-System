package com.qjj.utils;

import kotlin.jvm.internal.Intrinsics;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author zjw
 * @package drug
 * @Date 2022/3/13
 * @Time 16:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVO<T> {

    @NotNull
    private List<T> records;

    private Long total;

    @Override
    public String toString() {
        return "PageVO{" +
                "records=" + records +
                ", total=" + total +
                '}';
    }
}
