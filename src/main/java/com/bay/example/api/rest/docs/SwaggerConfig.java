package com.bay.example.api.rest.docs;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Class SwaggerConfig
 * 
 * @author Dinesh Metkari
 * @version v0.1
 * @since 2017-01-13
 * 
 */
@Configuration
@EnableSwagger
@ComponentScan("com.bay.example.api.rest")
public class SwaggerConfig {

    public static final String DEFAULT_INCLUDE_PATTERNS = "/example/.*";

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean 
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(DEFAULT_INCLUDE_PATTERNS);
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Product Review REST APIs",
                "The APIs are under open source licence",
                "http://opensource.org/licenses/MIT",
                "dineshmetkari@gmail.com",
                "BAY",
                "http://opensource.org/licenses/MIT"
        );
        return apiInfo;
    }
}
