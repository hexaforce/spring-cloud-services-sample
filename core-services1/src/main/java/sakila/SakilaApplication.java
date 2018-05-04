package sakila;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ConfigurableApplicationContext;

import microservices.cloud.service.utile.ServiceUtileApplication;
import microservices.cloud.service.utile.StartupCompleteEvent;

@SpringBootApplication
public class SakilaApplication {
	
	public static void main(String[] args) throws Exception {
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(SakilaApplication.class)
				.sources(ServiceUtileApplication.class)
				.web(WebApplicationType.SERVLET)
				.listeners(new ApplicationPidFileWriter())
				.run(args);
		
		context.getBean(StartupCompleteEvent.class).onComplete(context);
		
	}
	
}
