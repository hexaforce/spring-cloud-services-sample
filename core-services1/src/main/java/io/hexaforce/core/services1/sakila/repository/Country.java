package io.hexaforce.core.services1.sakila.repository;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.hexaforce.core.services1.sakila.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
public class Country extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private Integer countryId;

	@Column(name = "country")
	private String country;

	@OneToMany(mappedBy = "country")
	private List<City> cities;

	public City addCity(City city) {
		cities.add(city);
		city.setCountry(this);
		return city;
	}

	public City removeCity(City city) {
		cities.remove(city);
		city.setCountry(null);
		return city;
	}

}