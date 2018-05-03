package io.hexaforce.services.basic1.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Core1ServiceClient {
	
	private final RestTemplate restTemplate;

	@Autowired
	public Core1ServiceClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
}
