package sakila.type;

import lombok.Getter;

@Getter
public enum Rating {

	G("General Audiences"), 
	
	PG("Parental Guidance Suggested"), 
	
	PG_13("Parents Strongly Cautioned"), 
	
	R("Restricted"), 
	
	NC_17("No One 17 and Under Admitted");

	String describe;

	Rating(String describe) {
		this.describe = describe;
	}

}
