package com.aido.portal.utils;  
  
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.ComponentScan;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;  
  
  
import springfox.documentation.builders.ApiInfoBuilder;  
import springfox.documentation.builders.PathSelectors;  
import springfox.documentation.builders.RequestHandlerSelectors;  
import springfox.documentation.service.ApiInfo;  
import springfox.documentation.spi.DocumentationType;  
import springfox.documentation.spring.web.plugins.Docket;  
import springfox.documentation.swagger2.annotations.EnableSwagger2;  
/** 
 * ClassName: RestApiConfig  
 * Restful API 访问路径: 
 * eg:http://localhost:8080/jd-config-web/swagger-ui.html 
 * @author DOUBLE
 * @version
 */
  
//@EnableWebMvc  
//@EnableSwagger2  
//@ComponentScan(basePackages = {"com.aido.portal.controller"})  
//@Configuration  
public class RestApiConfig extends WebMvcConfigurationSupport{  
  
    @Bean  
    public Docket createRestApi() {  
        return new Docket(DocumentationType.SWAGGER_2)  
                .apiInfo(apiInfo())  
                .select()  
                .apis(RequestHandlerSelectors.basePackage("com.aido.portal.controller"))  
                .paths(PathSelectors.any())  
                .build();  
    }  
  
    @SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {  
        return new ApiInfoBuilder()  
                .title("Spring 中使用Swagger2构建RESTful APIs")  
                .termsOfServiceUrl("http://ufdouble.com")
                .contact("DOUBLE")  
                .version("1.1")  
                .build();  
    }  
} 