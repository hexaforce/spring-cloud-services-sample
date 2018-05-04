package io.hexaforce.core.services1.sakila.repository;

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
@Table(name = "inventory")
public class Inventory extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private Integer inventoryId;

	@ManyToOne
	@JoinColumn(name = "film_id")
	private Film film;

	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	@OneToMany(mappedBy = "inventory")
	private List<Rental> rentals;

	public Rental addRental(Rental rental) {
		rentals.add(rental);
		rental.setInventory(this);
		return rental;
	}

	public Rental removeRental(Rental rental) {
		rentals.remove(rental);
		rental.setInventory(null);
		return rental;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}