package io.hexaforce.services.basic1.api;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/basic1")
public class Basic1ExampleController {

	public String printDate() {
		return new Date().toString();
	}
	
}
