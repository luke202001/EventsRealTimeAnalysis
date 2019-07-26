package erta.common.entity.event;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import erta.common.entity.BaseEntity;

@Entity(name = "EventInfo")
@Table(name = "event_info")
public class EventInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "customer_id", nullable = false)
	private Long customerId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "status", nullable = false)
	private String status;

	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_info_id", nullable = true)
	private EventScheduleInfo eventScheduleInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public EventScheduleInfo getEventScheduleInfo() {
		return eventScheduleInfo;
	}

	public void setEventScheduleInfo(EventScheduleInfo eventScheduleInfo) {
		this.eventScheduleInfo = eventScheduleInfo;
	}

}
