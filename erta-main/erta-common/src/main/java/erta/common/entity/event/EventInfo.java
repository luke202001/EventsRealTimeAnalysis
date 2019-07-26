package erta.common.entity.event;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "event_schedule_info", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EventScheduleInfo> comments = new ArrayList<>();

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

}
