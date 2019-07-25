/**
 * 
 */
package erta.common.domain;

public class EventScheduleInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long eventDate;
	private Integer eventStartHour;
	private Integer eventStartMinute;
	private Integer eventEndHour;
	private Integer eventEndMinute;

	public EventScheduleInfo() {
	}

	public Long getEventDate() {
		return eventDate;
	}

	public void setEventDate(Long eventDate) {
		this.eventDate = eventDate;
	}

	public Integer getEventStartHour() {
		return eventStartHour;
	}

	public void setEventStartHour(Integer eventStartHour) {
		this.eventStartHour = eventStartHour;
	}

	public Integer getEventStartMinute() {
		return eventStartMinute;
	}

	public void setEventStartMinute(Integer eventStartMinute) {
		this.eventStartMinute = eventStartMinute;
	}

	public Integer getEventEndHour() {
		return eventEndHour;
	}

	public void setEventEndHour(Integer eventEndHour) {
		this.eventEndHour = eventEndHour;
	}

	public Integer getEventEndMinute() {
		return eventEndMinute;
	}

	public void setEventEndMinute(Integer eventEndMinute) {
		this.eventEndMinute = eventEndMinute;
	}

}
