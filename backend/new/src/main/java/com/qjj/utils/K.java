package com.qjj.utils;

import cn.hutool.core.util.NumberUtil;
import com.qjj.exception.BaseException;
import com.qjj.exception.ThrowException;


import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author 周建伟
 * @date 2022/3/10
 */
public class K {
    public K() {
    }

    public static boolean isNullOrEmpty(Object obj) {
        if (obj instanceof String) {
            return isNullOrEmpty((CharSequence)((String)obj));
        } else if (obj instanceof Object[]) {
            return isNullOrEmpty((Object[])((Object[])obj));
        } else if (obj instanceof Collection) {
            return isNullOrEmpty((Collection)obj);
        } else if (obj instanceof Map) {
            return isNullOrEmpty((Map)obj);
        } else {
            return obj == null;
        }
    }

    public static boolean isNullOrEmpty(CharSequence o) {
        return o == null || o.length() == 0;
    }

    public static boolean isBlank(CharSequence o) {
        if (o == null) {
            return true;
        } else {
            int length = o.length();
            if (length == 0) {
                return true;
            } else {
                for(int i = 0; i < length; ++i) {
                    if (!Character.isWhitespace(o.charAt(i))) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    public static boolean isNullOrEmpty(Object[] o) {
        return o == null || o.length == 0;
    }

    public static boolean isNullOrEmpty(Collection<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Object obj) {
        if (obj instanceof String) {
            return isNotEmpty((CharSequence)((String)obj));
        } else if (obj instanceof Object[]) {
            return isNotEmpty((Object[])((Object[])obj));
        } else if (obj instanceof Collection) {
            return isNotEmpty((Collection)obj);
        } else if (obj instanceof Map) {
            return isNotEmpty((Map)obj);
        } else {
            return obj != null;
        }
    }

    public static boolean isNotBlank(CharSequence o) {
        return !isBlank(o);
    }

    public static boolean isNotEmpty(CharSequence o) {
        return !isNullOrEmpty(o);
    }

    public static boolean isNotEmpty(Object[] o) {
        return !isNullOrEmpty(o);
    }

    public static boolean isNotEmpty(Collection<?> list) {
        return !isNullOrEmpty(list);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isNullOrEmpty(map);
    }

    public static boolean equals(Object o1, Object o2) {
        return o1 instanceof BigDecimal && o2 instanceof BigDecimal ? NumberUtil.equals((BigDecimal)o1, (BigDecimal)o2) : Objects.equals(o1, o2);
    }

    public static ThrowException isTrueThrow(boolean b) {
        return (errorMessage) -> {
            if (b) {
                throw new BaseException(errorMessage);
            }
        };
    }

    public static  ThrowException isFalseThrow(boolean b) {
        return (errorMessage) -> {
            if (!b) {
                throw new BaseException(errorMessage);
            }
        };
    }

}
