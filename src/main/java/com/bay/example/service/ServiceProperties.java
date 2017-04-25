package com.bay.example.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * @Class ServiceProperties
 * demonstrates how service-specific properties can be injected
 * @author Dinesh Metkari
 * @version v0.1
 * @since 2017-01-13
 * 
 */
@ConfigurationProperties(prefix = "Products.service", ignoreUnknownFields = false)
@Component
public class ServiceProperties {

    @NotNull // you can also create configurationPropertiesValidator
	private String name = "Empty";

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
