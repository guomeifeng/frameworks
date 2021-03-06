package org.example.config;

import org.example.entity.SwaggerProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by Kelly on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("org.example.controller")
                .title("frameworks后台系统")
                .description("frameworks后台相关接口文档")
                .contactName("kelly")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }
}
