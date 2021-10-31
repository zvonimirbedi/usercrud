package com.example.usercrud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.util.Arrays;
import java.util.List;

import static org.springframework.security.config.Elements.BASIC_AUTH;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Reactive Documentation")
                .description("Reactive API Documentation")
                .version("1.0.0")
                .build();
    }
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.usercrud"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(basicScheme())
                .securityContexts(securityContext());
    }

    private List<SecurityScheme> basicScheme() {
        return Arrays.asList(new BasicAuth(BASIC_AUTH));
    }

    private SecurityReference basicAuthReference() {
        return new SecurityReference(BASIC_AUTH, new AuthorizationScope[0]);
    }
    private List<SecurityContext> securityContext() {
        return Arrays.asList(
                SecurityContext.builder()
                        .securityReferences(Arrays.asList(basicAuthReference()))
                        //.forPaths(PathSelectors.ant("/actuator/**"))
                        .build());
    }
}
