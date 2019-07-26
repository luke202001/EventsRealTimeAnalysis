/**
 * 
 */
package erta.common.dto;

import java.util.List;

import erta.common.entity.event.EventInfo;

public class EventViewInfo extends EntityViewInfo<EventInfo> {

	private static final long serialVersionUID = 1L;

	public EventViewInfo() {
	}

	public EventViewInfo(EventInfo eventInfo) {
		super();
	}

	public EventViewInfo(List<EventInfo> eventInfos) {
		super(eventInfos);
	}

}
