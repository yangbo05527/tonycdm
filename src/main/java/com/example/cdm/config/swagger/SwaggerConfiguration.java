package com.example.cdm.config.swagger;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.WebMvcRequestHandler;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Objects;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration {


    @Bean
    public Docket setVersion101(){
        return buildDocket(ApiVersionConstant.VERSION_1_01);
    }

    @Bean
    public Docket setVersion102(){
        return buildDocket(ApiVersionConstant.VERSION_1_02);
    }

    //默认版本的接口api-docs分组
    @Bean
    public Docket createDefault(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo(ApiVersionConstant.VERSION_1_01))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//controller路径
                .paths(PathSelectors.any())
                .build();
    }



    private Docket buildDocket(String version){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo(version))
                .groupName(version)
                .select()
                .apis(input -> {
                    WebMvcRequestHandler requestHandler = (WebMvcRequestHandler)input;
                    if(Objects.nonNull(requestHandler)) {
                        ApiVersion apiVersion = input.getHandlerMethod().getMethodAnnotation(ApiVersion.class);
                        return apiVersion != null && Arrays.asList(apiVersion.group()).contains(version);
                    }else{
                        return false;
                    }
                })//controller路径
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo(String version){
        return new ApiInfoBuilder()
                .title("接口列表")
                .description("springmvc swagger 接口测试")
                .version(version)
                .build();
    }

}