package eta.events.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import erta.common.constants.AppServiceConstants;
import erta.common.dto.EntityViewInfo;
import erta.common.entity.event.EventInfo;
import erta.common.services.AppService;
import erta.common.wf.api.WFCtxInfo;
import erta.common.wf.api.WFResult;
import erta.common.wf.service.CRUDWFTaskBaseService;

@Service(AppServiceConstants.BEAN_ID_EVENTS_SERVICES_IMPL)
public class EventsServiceImpl extends CRUDWFTaskBaseService<WFCtxInfo, EventInfo> implements AppService<WFCtxInfo> {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventsServiceImpl.class);

	public EventsServiceImpl() {
	}

	@Override
	public WFResult get(WFCtxInfo wfCtxInfo) {
		LOGGER.debug("Enter");

		wfCtxInfo.addEntityViewInfo(new EntityViewInfo<EventInfo>());

		LOGGER.debug("Exit");
		return WFResult.SUCCESS;
	}
}
