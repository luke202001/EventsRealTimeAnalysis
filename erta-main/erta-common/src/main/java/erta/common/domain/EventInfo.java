package erta.common.domain;

public class EventInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private String status;

	private EventScheduleInfo scheduleInfo = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public EventScheduleInfo getScheduleInfo() {
		return scheduleInfo;
	}

	public void setScheduleInfo(EventScheduleInfo scheduleInfo) {
		this.scheduleInfo = scheduleInfo;
	}

}
