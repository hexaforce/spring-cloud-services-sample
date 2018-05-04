package sakila.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sakila.AbstractEntity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private Integer cityId;

	@Column(name = "city")
	private String city;

	@OneToMany(mappedBy = "city")
	private List<Address> addresses;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	public Address addAddress(Address address) {
		addresses.add(address);
		address.setCity(this);
		return address;
	}

	public Address removeAddress(Address address) {
		addresses.remove(address);
		address.setCity(null);
		return address;
	}

	public void setCountry(Country country) {
		this.country = country;
		
	}

}