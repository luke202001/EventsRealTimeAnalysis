package erta.common.wf.tasks.beans;

import org.springframework.stereotype.Component;

import erta.common.constants.AppServiceConstants;
import erta.common.entity.event.EventInfo;
import erta.common.wf.WFCtxInfo;
import erta.common.wf.tasks.Ui2ServicesDelegateWFTask;

@Component("EventInfoUiWFTask")
public class EventInfoUiWFTask extends Ui2ServicesDelegateWFTask<WFCtxInfo, EventInfo> {

	public EventInfoUiWFTask() {
		super(AppServiceConstants.SERVICES_EVENTS_NAME);
	}

}
