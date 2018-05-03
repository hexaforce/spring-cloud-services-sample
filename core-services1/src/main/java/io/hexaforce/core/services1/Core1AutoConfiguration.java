package io.hexaforce.core.services1;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties(Core1ConfigurationProperties.class)
public class Core1AutoConfiguration implements WebMvcConfigurer {

}
