package com.qjj;

import com.qjj.utils.QueryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({QueryBuilder.class})
@MapperScan(basePackages = {"com.qjj.dao"})
@ComponentScan(basePackages = {"com.qjj.*", "com.diboot.*"})
public class  NewApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(NewApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NewApplication.class);
    }
}
