package eta.events.services.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erta.common.constants.AppServiceConstants;
import erta.common.dto.EntityWFCtxInfo;
import erta.common.entity.event.EventInfo;
import erta.common.wf.controller.CRUDWFBaseController;

@RestController
@RequestMapping("/api/events-services")
public class EventsController extends CRUDWFBaseController<EntityWFCtxInfo, EventInfo> {

	public EventsController() {
		super(AppServiceConstants.SERVICES_EVENTS_NAME);
	}

}
