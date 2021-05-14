package com.comcast.orion.workorder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * SwaggerConfiguration
 *
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {

  /**
 * orionPropertiesType
 */
@Value("${orion.properties.type}")
  private String orionPropertiesType;
  


  /**
 * buildVersion
 */
@Value("${orion.build.version}")
  private String buildVersion;



  /**
 * propertiesVersion
 */
@Value("${orion.properties.version}")
  private String propertiesVersion;

	
  /**
 * @return Docket
 */
@Bean
  public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.comcast.orion.workorder.controller"))
        .build();
  }



  /**
 * @return ApiInfo
 */
private ApiInfo apiInfo() {
      return new ApiInfoBuilder()
          .title("Workorder REST Web Services API")
          .description("Swagger documentation for the workorder REST webservices API")
          .version("v2; Artifact Version :" + buildVersion+ "; Properties Version :" + propertiesVersion +"; Environment : " + orionPropertiesType)
          .build();
  }
  
  
  /* (non-Javadoc)
 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
 */
  //This method adds ResourceHandler
@Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
      registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
}
