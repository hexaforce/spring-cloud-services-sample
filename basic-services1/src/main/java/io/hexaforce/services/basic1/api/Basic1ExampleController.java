package io.hexaforce.services.basic1.api;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/basic1-service")
public class Basic1ExampleController {
	
	@ResponseBody
	@GetMapping(value = "/example1")
	public String example1() {
		return new Date().toString();
	}
	
//	@ResponseBody
//	@Secured("ROLE_ADMIN")
//	@GetMapping(value = "/init")
//	public ResponseEntity<ImplementsReference> init() {
//		// log.trace(msg);
//		// log.error(msg);
//		// log.debug(msg);
//		// log.warn(msg);
//		log.info("Controller(java): init()");
//		implementsReferenceService.MyBatisToJPAwithHibernate2();
//		String x = implementsReferenceService.init();
//		return new ResponseEntity<ImplementsReference>(new ImplementsReference(x), HttpStatus.OK);
//	}
}
