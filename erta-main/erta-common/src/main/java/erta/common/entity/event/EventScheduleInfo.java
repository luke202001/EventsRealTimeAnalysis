/**
 * 
 */
package erta.common.entity.event;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import erta.common.entity.BaseEntity;

@Entity(name = "EventScheduleInfo")
@Table(name = "event_schedule_info")
public class EventScheduleInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	private EventInfo eventInfo;

	private Date eventDate;
	private Integer eventStartHour;
	private Integer eventStartMinute;
	private Integer eventEndHour;
	private Integer eventEndMinute;

	public EventScheduleInfo() {
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
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
