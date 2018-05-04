package io.hexaforce.core.services1.sakila.repository;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "payment")
public class Payment extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Integer paymentId;

	@Column(name = "amount")
	private BigDecimal amount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_date")
	private Date paymentDate;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "rental_id")
	private Rental rental;

	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}