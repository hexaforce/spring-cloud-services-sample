package io.hexaforce.core.services1;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "core1.config", ignoreUnknownFields = true)
public class Core1ConfigurationProperties {
	
	private String value1;
	
}
