package sakila.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "rental")
public class Rental extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_id")
	private Integer rentalId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rental_date")
	private Date rentalDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "return_date")
	private Date returnDate;

	@OneToMany(mappedBy = "rental")
	private List<Payment> payments;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;

	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;

	public Payment addPayment(Payment payment) {
		payments.add(payment);
		payment.setRental(this);
		return payment;
	}

	public Payment removePayment(Payment payment) {
		payments.remove(payment);
		payment.setRental(null);
		return payment;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}