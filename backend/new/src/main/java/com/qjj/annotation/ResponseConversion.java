package com.qjj.annotation;

/**
 * @author zjw
 * @package drug
 * @Date 2022/3/12
 * @Time 8:51
 */

import java.lang.annotation.*;

/**
 * 用来标记在controller层类or方法上
 * 表示请求该URI的response需要被转换
 *  * @author moguchen
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Inherited
public @interface ResponseConversion {
}
