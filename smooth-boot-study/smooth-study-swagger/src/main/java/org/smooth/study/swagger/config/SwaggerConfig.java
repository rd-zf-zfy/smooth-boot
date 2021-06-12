package org.smooth.study.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * Swagger2 配置
 * </p>
 *
 * @author zhangfei
 * @date Created in 2021-06-11 11:14
 */
// 使用swagger 首先引入swagger依赖 在编写配置类
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 注入 swagger 的bean 到 spring
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.smooth.study.swagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    // swagger 页面 简单的描述
    // swagger 页面 url 默认为 http;//[ip]:[port]/[context-path]/swagger-ui.html
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("spring-boot-study")
                .description("这是一个简单的 Swagger API 演示，学习一下吧。")
                .contact(new Contact("", "", ""))
                .version("1.0.0-SNAPSHOT").build();
    }

}
