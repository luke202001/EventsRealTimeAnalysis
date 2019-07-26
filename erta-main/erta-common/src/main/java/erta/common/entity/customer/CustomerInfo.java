package erta.common.entity.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import erta.common.entity.BaseEntity;

@Entity(name = "CustomerInfo")
@Table(name = "customer_info")
public class CustomerInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id", nullable = true)
	private Long userId;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "customer_type", nullable = false, updatable = false)
	private String customerTYpe;

	public CustomerInfo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerTYpe() {
		return customerTYpe;
	}

	public void setCustomerTYpe(String customerTYpe) {
		this.customerTYpe = customerTYpe;
	}

}
