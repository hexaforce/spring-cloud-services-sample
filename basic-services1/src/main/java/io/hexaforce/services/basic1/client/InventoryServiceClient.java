package io.hexaforce.services.basic1.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.hexaforce.services.basic1.response.ProductInventoryResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryServiceClient {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getDefaultProductInventoryByCode")
	public Optional<ProductInventoryResponse> getProductInventoryByCode(String productCode) {

		ResponseEntity<ProductInventoryResponse> itemResponseEntity = restTemplate.getForEntity(
				"http://inventory-service/api/inventory/{code}", ProductInventoryResponse.class, productCode);

		if (itemResponseEntity.getStatusCode() == HttpStatus.OK) {
			
			return Optional.ofNullable(itemResponseEntity.getBody());
			
		} else {
			
			log.error("Unable to get inventory level for product_code: " + productCode + ", StatusCode: "
					+ itemResponseEntity.getStatusCode());
			
			return Optional.empty();
		}

	}

	Optional<ProductInventoryResponse> getDefaultProductInventoryByCode(String productCode) {
		
		log.info("Returning default ProductInventoryByCode for productCode: " + productCode);
		
		ProductInventoryResponse response = new ProductInventoryResponse();
		
		response.setProductCode(productCode);
		
		response.setAvailableQuantity(50);
		
		return Optional.ofNullable(response);
	}

}