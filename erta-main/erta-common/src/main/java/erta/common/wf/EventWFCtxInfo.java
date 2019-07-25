package erta.common.wf;

import erta.common.constants.EventInfoConstants;
import erta.common.domain.EventInfo;

public class EventWFCtxInfo extends WFCtxInfo {

	private static final long serialVersionUID = 1L;

	public EventWFCtxInfo() {
	}

	public EventWFCtxInfo(String eventInfoCRUDType) {
		super.addEventInfoCRUDType(eventInfoCRUDType);
	}

	public EventWFCtxInfo(Long eventInfoId) {
		super(eventInfoId);
	}

	public EventWFCtxInfo(EventInfo eventInfo) {
		super(eventInfo);
	}

	public static EventWFCtxInfo buildtCreateCRUDTypeInstance() {
		return new EventWFCtxInfo(EventInfoConstants.KEY_EVENT_TYPE_CREATE);
	}

	public static EventWFCtxInfo buildUpdateCRUDTypeInstance() {
		return new EventWFCtxInfo(EventInfoConstants.KEY_EVENT_TYPE_UPDATE);
	}

	public static EventWFCtxInfo buildGetCRUDTypeInstance() {
		return new EventWFCtxInfo(EventInfoConstants.KEY_EVENT_TYPE_GET);
	}

	public static EventWFCtxInfo buildGetAllCRUDTypeInstance() {
		return new EventWFCtxInfo(EventInfoConstants.KEY_EVENT_TYPE_GET_ALL);
	}

	public static EventWFCtxInfo buildDeleteCRUDTypeInstance() {
		return new EventWFCtxInfo(EventInfoConstants.KEY_EVENT_TYPE_DELETE);
	}

}
