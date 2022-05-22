package com.qjj.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.resource.Resource;
import com.qjj.annotation.ResponseConversion;
import com.qjj.utils.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * <p>
 *      拦截controller方法默认返回参数，统一处理返回值/响应体
 * </p>
 *执行顺序：
 *
 * 1、HandlerInterceptor.preHandle()
 *
 * 2、 业务方法
 *
 * 3、@ExceptionHandler
 *
 * 4、ResponseBodyAdvice.supports()
 *
 * 5、ResponseBodyAdvice.beforeBodyWrite()
 *
 * 6、HandlerInterceptor.postHandle()
 *
 * 7、HandlerInterceptor.afterCompletion()

 * @author 周建伟
 * @date 2022/3/9
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.qjj.controller")
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {


    //这里设置成false 它就不会再走这个类了
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        Method method = methodParameter.getMethod();
        ResponseConversion responseConversion = method.getAnnotation(ResponseConversion.class);

        //如果没加上该注解则不设置变量为true
        if (!BeanUtil.isEmpty(responseConversion))
            return true;
        return false;
    }


    @Override
    public Object beforeBodyWrite(Object o, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //本身就为转换的response或者文件上传下载 不需要转换 直接返回
        if (o instanceof ResultBean || o instanceof Resource) {
            return o;
        } else if (o == null){
            return ResultBean.success(null);
        }
        return ResultBean.success(o);
    }

    /**
     * 参数缺失异常处理方法
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResultBean<String> exceptionRequestParameter(MissingServletRequestParameterException e) {
        log.error("参数缺失: {}, {}", e.getParameterName(), e.getMessage(), e);
        return ResultBean.error("参数缺失: " + e.getParameterName() + "为必传参数");
    }

    /**
     * 请求方式异常处理方法
     *
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResultBean<String> exceptionMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        log.error("请求方式异常: {}, {}", e.getMethod(), e.getMessage(), e);
        return ResultBean.error("请求方式异常: " + e.getMessage());
    }

    /**
     * 通用异常处理方法
     *
     */
    @ExceptionHandler(value = Exception.class)
    public ResultBean<String> exceptionHandler(Exception e) {
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        log.error("\n-----------------------全局通用异常分析 start-----------------------------------\n\t" +
                        "文件名: {}\n\t" +
                        "类名: {}\n\t" +
                        "方法名: {}\n\t" +
                        "抛出异常行号: {}\n\t" +
                        "异常栈信息: {}\n\t" +
                        "------------------全局通用异常分析 end ---------------------------------------",
                stackTraceElement.getFileName(),
                stackTraceElement.getClassName(),
                stackTraceElement.getMethodName(),
                stackTraceElement.getLineNumber(),
                e.getMessage(),
                e);
        return ResultBean.error(e.getMessage());
        //return ResultBean.error(ResultMsgType.SERVER_ERROR.getValue());
    }

}
