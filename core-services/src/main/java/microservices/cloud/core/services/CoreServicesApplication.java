package microservices.cloud.core.services;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CoreServicesApplication {
	
	public static void main(String[] args) throws BeansException, IOException {
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(CoreServicesApplication.class)
				.web(WebApplicationType.SERVLET)
				.listeners(new ApplicationPidFileWriter())
				.run(args);
		
		context.getBean(StartupCompleteEvent.class).onComplete();
		
	}
	
}
