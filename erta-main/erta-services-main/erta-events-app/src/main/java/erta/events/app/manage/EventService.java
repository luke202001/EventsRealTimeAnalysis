package erta.events.app.manage;

import erta.common.domain.event.EventInfo;
import erta.common.dto.EventViewInfo;

public interface EventService {

	Long createEvent(EventInfo e);
	
	EventViewInfo getEventViewInfo(Long eventId);
}