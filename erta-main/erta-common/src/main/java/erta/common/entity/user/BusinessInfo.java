package erta.common.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import erta.common.entity.BaseEntity;

@Entity(name = "BusinessInfo")
@Table(name = "business_info")
public class BusinessInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "bus_ref_name", nullable = false, unique = true)
	private String businessReferenceName;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "primary_contact_user_id", nullable = false)
	private Long primaryContactUserId;

	public BusinessInfo() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessReferenceName() {
		return businessReferenceName;
	}

	public void setBusinessReferenceName(String businessReferenceName) {
		this.businessReferenceName = businessReferenceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPrimaryContactUserId() {
		return primaryContactUserId;
	}

	public void setPrimaryContactUserId(Long primaryContactUserId) {
		this.primaryContactUserId = primaryContactUserId;
	}

}
