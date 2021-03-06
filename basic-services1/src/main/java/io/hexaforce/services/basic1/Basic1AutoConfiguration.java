package io.hexaforce.services.basic1;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties(Basic1ConfigurationProperties.class)
public class Basic1AutoConfiguration implements WebMvcConfigurer {

}
