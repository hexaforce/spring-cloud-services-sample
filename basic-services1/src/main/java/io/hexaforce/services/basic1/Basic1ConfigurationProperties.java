package io.hexaforce.services.basic1;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "basic1.config", ignoreUnknownFields = true)
public class Basic1ConfigurationProperties {
	
	private String value1;
	
}
