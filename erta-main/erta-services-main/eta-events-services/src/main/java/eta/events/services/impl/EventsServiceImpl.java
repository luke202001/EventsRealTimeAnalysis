package eta.events.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import erta.common.constants.AppServiceConstants;
import erta.common.dto.EventViewInfo;
import erta.common.services.event.EventService;
import erta.common.wf.api.WFCtxInfo;
import erta.common.wf.api.WFResult;
import erta.common.wf.service.CRUDWFTaskBaseService;

@Service(AppServiceConstants.BEAN_ID_EVENTS_SERVICES_IMPL)
public class EventsServiceImpl extends CRUDWFTaskBaseService<WFCtxInfo> implements EventService<WFCtxInfo> {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventsServiceImpl.class);

	public EventsServiceImpl() {
	}

	@Override
	public WFResult get(WFCtxInfo wfCtxInfo) {
		LOGGER.debug("Enter");

		wfCtxInfo.addEntityViewInfo(new EventViewInfo());

		LOGGER.debug("Exit");
		return WFResult.SUCCESS;
	}
}
