package com.qjj.enums;

/**
 * <p>
 *
 * </p>
 *
 * @author 周建伟
 * @date 2022/3/9
 */
public enum ResultStatusType {
    SUCCESS(200),
    NO_PERMISSION(403),
    FAIL(500);

    private final int value;

    public int getValue() {
        return value;
    }
    private ResultStatusType(final int value) {
        this.value = value;
    }
}
