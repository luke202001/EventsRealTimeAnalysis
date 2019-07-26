package erta.common.wf.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import erta.common.dto.AppCtxRequestInfo;
import erta.common.dto.AppCtxResponseInfo;
import erta.common.entity.BaseEntity;

public class WFCtxInfo extends AppCtxRequestInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> ctxData = new HashMap<>();

	public static final String KEY_CTX_BASE_ENTITY_INFO = "CTX_BASE_ENTITY_INFO";
	public static final String KEY_CTX_BASE_ENTITY_VIEW_INFO = "CTX_BASE_ENTITY_VIEW_INFO";
	public static final String KEY_CTX_BASE_ENTITY_ID = "CTX_BASE_ENTITY_INFO_ID";
	public static final String KEY_CTX_BASE_ENTITY_CRUD_TYPE = "CTX_BASE_ENTITY_CRUD_TYPE";

	public WFCtxInfo() {
	}

	public WFCtxInfo(Long baseEntityId) {
		this.addEntityId(baseEntityId);
	}

	public WFCtxInfo(BaseEntity baseEntityInfo) {
		this.addEntityInfo(baseEntityInfo);
	}

	public void putCtxData(String key, Object val) {
		this.ctxData.put(key, val);
	}

	public void addCtxData(String key, BaseEntity val) {
		this.putCtxData(key, val);
	}

	public void addEntityInfo(BaseEntity val) {
		this.addCtxData(KEY_CTX_BASE_ENTITY_INFO, val);
	}

	public BaseEntity getEntityInfo() {
		return (BaseEntity) this.getCtxData(KEY_CTX_BASE_ENTITY_INFO);
	}

	public void addEntityViewInfo(AppCtxResponseInfo val) {
		this.putCtxData(KEY_CTX_BASE_ENTITY_VIEW_INFO, val);
	}

	public AppCtxResponseInfo getEntityViewInfo() {
		return (AppCtxResponseInfo) this.getCtxData(KEY_CTX_BASE_ENTITY_VIEW_INFO);
	}

	public void addEntityId(Long val) {
		this.putCtxData(KEY_CTX_BASE_ENTITY_ID, val);
	}

	public Long getEntityId() {
		return (Long) this.getCtxData(KEY_CTX_BASE_ENTITY_ID);
	}

	public void addEntityCRUDType(String baseEntityCrudType) {
		this.putCtxData(KEY_CTX_BASE_ENTITY_CRUD_TYPE, baseEntityCrudType);
	}

	public String getEntityCRUDType() {
		return (String) this.ctxData.get(KEY_CTX_BASE_ENTITY_CRUD_TYPE);
	}

	public Object getCtxData(String key) {
		return this.ctxData.get(key);
	}

	public BaseEntity getCtxDataAsEntity(String key) {
		return (BaseEntity) this.ctxData.get(key);
	}

	public AppCtxResponseInfo getCtxDataAsDTO(String key) {
		return (AppCtxResponseInfo) this.ctxData.get(key);
	}

	public BaseEntity getCtxDataAsBaseEntityInfo(String key) {
		return (BaseEntity) this.ctxData.get(key);
	}

	public AppCtxResponseInfo getCtxDataAsBaseEntityViewInfo(String key) {
		return (AppCtxResponseInfo) this.ctxData.get(key);
	}

	public void removeCtxData(String key) {
		this.ctxData.remove(key);
	}

	public boolean containsCtxData(String key) {
		return this.ctxData.containsKey(key);
	}

}
