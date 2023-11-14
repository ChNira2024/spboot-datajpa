package com.eidiko.niranjana.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerTicketConfig
{

    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(documentationInfo())
        		.select()
        		.apis(RequestHandlerSelectors.basePackage("com.eidiko.niranjana.controller"))
        		.paths(PathSelectors.any())   //.paths(PathSelectors.regex("/ticket.*"))
        		.build();		
    }
    private ApiInfo documentationInfo()
    {
    	Contact contact = new Contact("Dev-Niranjana", "https://www.dev-team.com/", "dev-team@gmail.com");
        ApiInfo apiInfo = new ApiInfo("Spring Boot Swagger Request API",
						        		"Spring Boot Swagger Request API", 
						        		"2.6.1",
						        		"Terms of Service URL",              					  
						        		contact,
						        		"Apache License Version 2.0",
						        		"https://www.apache.org/licenses/LICENSE-2.0.html"
						        		);
    	return apiInfo;
    	
//        return new ApiInfoBuilder().title("Spring Boot Swagger Request API")
//                .description("Spring boot application ticket request api")
//                .contact(new Contact("Dev-Niranjana", "https://www.payment.example.com/", "niranjanacharty2013@gmail.com"))
//                .license("Apache 2.0")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
//                .version("1.0.0")
//                .build();

        
    }


}
