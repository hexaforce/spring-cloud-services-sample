package io.hexaforce.core.services2;


import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ConfigurableApplicationContext;

import microservices.cloud.service.utile.StartupCompleteEvent;

@SpringBootApplication
public class CoreServicesApplication2 {
	public static void main(String[] args) throws BeansException, IOException {
		ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(CoreServicesApplication2.class)
				.web(WebApplicationType.SERVLET).listeners(new ApplicationPidFileWriter()).run(args);
		context.getBean(StartupCompleteEvent.class).onComplete(context);
	}
}
