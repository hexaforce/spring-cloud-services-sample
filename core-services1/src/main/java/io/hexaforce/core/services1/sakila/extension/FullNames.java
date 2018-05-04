package io.hexaforce.core.services1.sakila.extension;

public interface FullNames {

	String getFirstName();

	String getLastName();

	default String getFullName() {
		return getLastName().concat(" ").concat(getFirstName());
	}

}
