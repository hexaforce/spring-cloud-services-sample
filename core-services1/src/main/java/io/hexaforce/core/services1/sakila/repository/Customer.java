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
@Table(name = "customer")
public class Customer extends AbstractEntity implements FullNames {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "active")
	private Byte active;

	@Column(name = "email")
	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

	@OneToMany(mappedBy = "customer")
	private List<Payment> payments;

	@OneToMany(mappedBy = "customer")
	private List<Rental> rentals;

	public Payment addPayment(Payment payment) {
		payments.add(payment);
		payment.setCustomer(this);
		return payment;
	}

	public Payment removePayment(Payment payment) {
		payments.remove(payment);
		payment.setCustomer(null);
		return payment;
	}

	public Rental addRental(Rental rental) {
		rentals.add(rental);
		rental.setCustomer(this);
		return rental;
	}

	public Rental removeRental(Rental rental) {
		rentals.remove(rental);
		rental.setCustomer(null);
		return rental;
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