package com.eidiko.niranjana.config;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig 
{
public static final String AUTHORIZATION_HEADER = "Authorization";
	
	private ApiKey apiKeys()
	{
		return new ApiKey("JWT",AUTHORIZATION_HEADER,"header");
	}
	
	private List<SecurityContext> securityContexts()
	{
		return Arrays.asList(SecurityContext.builder().securityReferences(securityReference()).build());
	}
	private List<SecurityReference> securityReference()
	{
		AuthorizationScope scope = new AuthorizationScope("global","accessEverything"); 
		return Arrays.asList(new SecurityReference("scope", new AuthorizationScope[] {scope}));
	}
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.eidiko.niranjana.controller")) // Replace with your controller package
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Your API Title",
                "Description of your API",
                "API Version",
                "Terms of Service URL",
                new Contact("Your Name", "Contact URL", "Contact Email"),
                "License",
                "License URL",Collections.emptyList());
    }
}
