package erta.events.app.manage;

import org.springframework.stereotype.Service;

import erta.common.constants.EventInfoConstants;
import erta.common.domain.event.EventInfo;
import erta.common.dto.EventViewInfo;
import erta.common.wf.WFCtxInfo;
import erta.common.wf.WFResult;
import erta.common.wf.WFTask;

@Service("EventServiceImpl")
public class EventServiceImpl implements EventService, WFTask<WFCtxInfo, WFResult> {

	public EventServiceImpl() {
	}

	@Override
	public Long createEvent(EventInfo eventInfo) {
		return eventInfo.getId();
	}

	@Override
	public EventViewInfo getEventViewInfo(Long eventId) {
		return new EventViewInfo();
	}

	@Override
	public WFResult executeTask(WFCtxInfo wfCtxInfo) {

		WFResult result = new WFResult();

		switch (wfCtxInfo.getEventInfoCRUDType()) {
		case EventInfoConstants.KEY_EVENT_TYPE_CREATE:
			break;
		case EventInfoConstants.KEY_EVENT_TYPE_UPDATE:
			break;
		case EventInfoConstants.KEY_EVENT_TYPE_DELETE:
			break;
		case EventInfoConstants.KEY_EVENT_TYPE_GET:
			wfCtxInfo.addEventInfo(new EventViewInfo());
			break;
		case EventInfoConstants.KEY_EVENT_TYPE_GET_ALL:
			wfCtxInfo.addEventInfo(new EventViewInfo());
			break;
		default:
			result = WFResult.FAIL;
			break;
		}

		result.setResult(Boolean.TRUE);
		return result;
	}

}
