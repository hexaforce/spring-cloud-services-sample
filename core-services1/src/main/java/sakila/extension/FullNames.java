package sakila.extension;

public interface FullNames {

	String getFirstName();

	String getLastName();

	default String getFullName() {
		return getLastName().concat(" ").concat(getFirstName());
	}

}
