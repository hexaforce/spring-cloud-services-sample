package io.hexaforce.core.services1.sakila.model;

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
@Table(name = "address")
public class Address extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;

	@Column(name = "address")
	private String address;

	@Column(name = "address2")
	private String address2;

	@Column(name = "district")
	private String district;

	@Column(name = "location")
	private String location;

	@Column(name = "phone")
	private String phone;

	@Column(name = "postal_code")
	private String postalCode;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@OneToMany(mappedBy = "address")
	private List<Customer> customers;

	@OneToMany(mappedBy = "address")
	private List<Staff> staffs;

	@OneToMany(mappedBy = "address")
	private List<Store> stores;

	public Customer addCustomer(Customer customer) {
		customers.add(customer);
		customer.setAddress(this);
		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		customers.remove(customer);
		customer.setAddress(null);
		return customer;
	}

	public Staff addStaff(Staff staff) {
		staffs.add(staff);
		staff.setAddress(this);
		return staff;
	}

	public Staff removeStaff(Staff staff) {
		staffs.remove(staff);
		staff.setAddress(null);
		return staff;
	}

	public Store addStore(Store store) {
		stores.add(store);
		store.setAddress(this);
		return store;
	}

	public Store removeStore(Store store) {
		stores.remove(store);
		store.setAddress(null);
		return store;
	}

	public void setCity(City city) {
		this.city = city;	
	}

}