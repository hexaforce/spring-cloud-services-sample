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
@Table(name = "store")
public class Store extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private Byte storeId;

	@OneToMany(mappedBy = "store")
	private List<Customer> customers;

	@OneToMany(mappedBy = "store")
	private List<Inventory> inventories;

	@OneToMany(mappedBy = "store")
	private List<Staff> staffs;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "manager_staff_id")
	private Staff staff;

	public Customer addCustomer(Customer customer) {
		customers.add(customer);
		customer.setStore(this);
		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		customers.remove(customer);
		customer.setStore(null);
		return customer;
	}

	public Inventory addInventory(Inventory inventory) {
		inventories.add(inventory);
		inventory.setStore(this);
		return inventory;
	}

	public Inventory removeInventory(Inventory inventory) {
		inventories.remove(inventory);
		inventory.setStore(null);
		return inventory;
	}
	public Staff addStaff(Staff staff) {
		staffs.add(staff);
		staff.setStore(this);
		return staff;
	}

	public Staff removeStaff(Staff staff) {
		staffs.remove(staff);
		staff.setStore(null);
		return staff;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}