package io.hexaforce.core.services1.sakila.repository;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.hexaforce.core.services1.sakila.AbstractEntity;
import io.hexaforce.core.services1.sakila.extension.FullNames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "staff")
public class Staff extends AbstractEntity implements FullNames {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	private Byte staffId;

	@Column(name = "active")
	private Byte active;

	@Column(name = "email")
	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	private String password;

	@Lob
	@Column(name = "picture")
	private Byte[] picture;

	@Column(name = "username")
	private String username;

	@OneToMany(mappedBy = "staff")
	private List<Payment> payments;

	@OneToMany(mappedBy = "staff")
	private List<Rental> rentals;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	@OneToMany(mappedBy = "staff")
	private List<Store> stores;

	public Payment addPayment(Payment payment) {
		this.payments.add(payment);
		payment.setStaff(this);
		return payment;
	}

	public Payment removePayment(Payment payment) {
		this.payments.remove(payment);
		payment.setStaff(null);
		return payment;
	}

	public Rental addRental(Rental rental) {
		this.rentals.add(rental);
		rental.setStaff(this);
		return rental;
	}

	public Rental removeRental(Rental rental) {
		this.rentals.remove(rental);
		rental.setStaff(null);
		return rental;
	}

	public Store addStore(Store store) {
		this.stores.add(store);
		store.setStaff(this);
		return store;
	}

	public Store removeStore(Store store) {
		this.stores.remove(store);
		store.setStaff(null);
		return store;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}
	
}