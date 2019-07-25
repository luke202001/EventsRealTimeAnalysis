package erta.common.wf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import erta.common.domain.BaseEntity;
import erta.common.domain.EventInfo;
import erta.common.dto.BaseDTO;
import erta.common.dto.EventViewInfo;

public class WFCtxInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> ctxData = new HashMap<>();

	public static final String KEY_CTX_EVENT_INFO = "CTX_EVENT_INFO";
	public static final String KEY_CTX_EVENT_VIEW_INFO = "CTX_EVENT_VIEW_INFO";
	public static final String KEY_CTX_EVENT_INFO_ID = "CTX_EVENT_INFO_ID";
	public static final String KEY_CTX_EVENT_INFO_CRUD_TYPE = "CTX_EVENT_INFO_CRUD_TYPE";

	public WFCtxInfo() {
	}

	public WFCtxInfo(Long eventInfoId) {
		this.addEventInfoId(eventInfoId);
	}

	public WFCtxInfo(EventInfo eventInfo) {
		this.addEventInfo(eventInfo);
	}

	public void addCtxData(String key, Object val) {
		this.ctxData.put(key, val);
	}

	public void addCtxData(String key, EventInfo val) {
		this.addCtxData(key, val);
	}

	public void addEventInfo(EventInfo val) {
		this.addCtxData(KEY_CTX_EVENT_INFO, val);
	}

	public EventInfo getEventInfo() {
		return (EventInfo) this.getCtxData(KEY_CTX_EVENT_INFO);
	}

	public void addEventInfo(EventViewInfo val) {
		this.addCtxData(KEY_CTX_EVENT_VIEW_INFO, val);
	}

	public EventViewInfo getEventViewInfo() {
		return (EventViewInfo) this.getCtxData(KEY_CTX_EVENT_VIEW_INFO);
	}

	public void addEventInfoId(Long val) {
		this.addCtxData(KEY_CTX_EVENT_INFO_ID, val);
	}

	public Long getEventInfoId() {
		return (Long) this.getCtxData(KEY_CTX_EVENT_INFO_ID);
	}

	public void addEventInfoCRUDType(String eventType) {
		this.addCtxData(KEY_CTX_EVENT_INFO_CRUD_TYPE, eventType);
	}

	public String getEventInfoCRUDType() {
		return (String) this.ctxData.get(KEY_CTX_EVENT_INFO_CRUD_TYPE);
	}

	public Object getCtxData(String key) {
		return this.ctxData.get(key);
	}

	public BaseEntity getCtxDataAsEntity(String key) {
		return (BaseEntity) this.ctxData.get(key);
	}

	public BaseDTO getCtxDataAsDTO(String key) {
		return (BaseDTO) this.ctxData.get(key);
	}

	public EventInfo getCtxDataAsEventInfo(String key) {
		return (EventInfo) this.ctxData.get(key);
	}

	public EventViewInfo getCtxDataAsEventViewInfo(String key) {
		return (EventViewInfo) this.ctxData.get(key);
	}

	public void removeCtxData(String key) {
		this.ctxData.remove(key);
	}

	public boolean containsCtxData(String key) {
		return this.ctxData.containsKey(key);
	}

}
