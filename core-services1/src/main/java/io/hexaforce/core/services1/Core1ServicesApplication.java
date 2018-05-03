package io.hexaforce.core.services1;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ConfigurableApplicationContext;

import microservices.cloud.service.utile.ServiceUtileApplication;
import microservices.cloud.service.utile.StartupCompleteEvent;
import microservices.cloud.services.common.ServicesCommonApplication;

@SpringBootApplication
public class Core1ServicesApplication {
	
	public static void main(String[] args) throws BeansException, IOException {
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(Core1ServicesApplication.class)
				.sources(ServiceUtileApplication.class)
				.sources(ServicesCommonApplication.class)
				.web(WebApplicationType.SERVLET)
				.listeners(new ApplicationPidFileWriter())
				.run(args);
		
		context.getBean(StartupCompleteEvent.class).onComplete(context);
		
	}
	
}
