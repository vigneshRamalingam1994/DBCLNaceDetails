package com.nace.controller;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nace.controller"))
                .paths(regex("/dbclm.*")).build()
                .apiInfo(metaData())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("NACE DETAILS")
                .description("Available features: Create and persist Order details and Fetch NACE records for a given order id")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}
