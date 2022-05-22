package com.qjj.config;

//import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.constraints.NotNull;
import java.util.List;


@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许跨域访问的路径
        registry.addMapping("/**")
                //允许跨域访问的源
                .allowedOriginPatterns("*")
                //允许请求方法
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                //预检间隔时间
                .maxAge(3600)
                //允许头部设置
                .allowedHeaders("*")
                //是否发送cookie
                .allowCredentials(true);
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/"};

    @Override
    public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
        //swagger静态资源
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.QuoteFieldNames,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteDateUseDateFormat,
//                SerializerFeature.WriteNullStringAsEmpty);
//
//        List<MediaType> mediaTypeList = new ArrayList<>();
//        mediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);
//        mediaTypeList.add(MediaType.APPLICATION_JSON);
//        messageConverter.setSupportedMediaTypes(mediaTypeList);
//        messageConverter.setFastJsonConfig(fastJsonConfig);
//
//        converters.add(0, messageConverter);
    }
}
