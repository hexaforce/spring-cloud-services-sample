package io.hexaforce.services.basic1.response;

import lombok.Data;

@Data
public class ProductInventoryResponse {
    
	private String productCode;
	
    private int availableQuantity;
    
}