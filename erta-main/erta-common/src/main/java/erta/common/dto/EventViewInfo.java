/**
 * 
 */
package erta.common.dto;

import java.util.List;

import erta.common.entity.event.EventInfo;

public class EventViewInfo extends AppCtxResponseInfo {

	private static final long serialVersionUID = 1L;

	private EventInfo eventInfo;
	private List<EventInfo> eventInfos;

	public EventViewInfo() {
	}

	public EventViewInfo(EventInfo eventInfo) {
		super();
		this.eventInfo = eventInfo;
	}

	public EventViewInfo(List<EventInfo> eventInfos) {
		super();
		this.eventInfos = eventInfos;
	}

	public EventInfo getEventInfo() {
		return eventInfo;
	}

	public void setEventInfo(EventInfo eventInfo) {
		this.eventInfo = eventInfo;
	}

	public List<EventInfo> getEventInfos() {
		return eventInfos;
	}

	public void setEventInfos(List<EventInfo> eventInfos) {
		this.eventInfos = eventInfos;
	}

}
