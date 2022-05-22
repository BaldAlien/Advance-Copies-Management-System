package com.qjj.config;

//
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * swagger2配置类
 * 默认访问地址是：http://${host}:${port}/doc.html
 */
@Configuration
@EnableSwagger2WebMvc
@Slf4j
public class SwaggerConfig {

    @Bean
    @ConditionalOnMissingBean
    public Docket createRestApi() {
        log.info("swagger2初始化");
        return new Docket(DocumentationType.SWAGGER_2)
                // 判断是否显示swagger页面
                .enable(true)
                .groupName("默认")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qjj.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建api文档信息
     */
    private ApiInfo apiInfo() {
        log.info("swagger2初始化------------------");
        return new ApiInfoBuilder()
                .title("demo-API")
                .description("demo-API接口文档")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }


}
