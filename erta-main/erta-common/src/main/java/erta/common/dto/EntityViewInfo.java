package erta.common.dto;

import java.util.List;

import erta.common.entity.BaseEntity;

public class EntityViewInfo<E extends BaseEntity> extends AppCtxResponseInfo {

	private static final long serialVersionUID = 1L;

	private E eventInfo;
	private List<E> entities;

	public EntityViewInfo() {
	}

	public EntityViewInfo(E eventInfo) {
		super();
		this.eventInfo = eventInfo;
	}

	public EntityViewInfo(List<E> entities) {
		super();
		this.entities = entities;
	}

	public E getEventInfo() {
		return eventInfo;
	}

	public void setEventInfo(E eventInfo) {
		this.eventInfo = eventInfo;
	}

	public List<E> getEventInfos() {
		return entities;
	}

	public void setEventInfos(List<E> eventInfos) {
		this.entities = eventInfos;
	}

}
