package erta.common.dto;

import erta.common.constants.EntityConstants;
import erta.common.entity.BaseEntity;
import erta.common.entity.event.EventInfo;
import erta.common.wf.WFCtxInfo;

public class EntityWFCtxInfo extends WFCtxInfo {

	private static final long serialVersionUID = 1L;

	public EntityWFCtxInfo() {
	}

	public EntityWFCtxInfo(String entityCRUDType) {
		super.addEntityCRUDType(entityCRUDType);
	}

	public EntityWFCtxInfo(String entityCRUDType, BaseEntity entityInfo) {
		this(entityCRUDType);
		super.addEntityInfo(entityInfo);
	}

	public EntityWFCtxInfo(String entityCRUDType, Long entityInfoId) {
		this(entityCRUDType);
		super.addEntityId(entityInfoId);
	}

	public EntityWFCtxInfo(Long eventInfoId) {
		super(eventInfoId);
	}

	public EntityWFCtxInfo(EventInfo eventInfo) {
		super(eventInfo);
	}

	public static EntityWFCtxInfo buildtCreateCRUDTypeInstance(BaseEntity entityInfo) {
		return new EntityWFCtxInfo(EntityConstants.ENTITY_TRANSAC_TYPE_CREATE, entityInfo);
	}

	public static EntityWFCtxInfo buildUpdateCRUDTypeInstance(BaseEntity eventInfo) {
		return new EntityWFCtxInfo(EntityConstants.ENTITY_TRANSAC_TYPE_UPDATE, eventInfo);
	}

	public static EntityWFCtxInfo buildGetCRUDTypeInstance(Long entityInfoId) {
		return new EntityWFCtxInfo(EntityConstants.ENTITY_TRANSAC_TYPE_GET, entityInfoId);
	}

	public static EntityWFCtxInfo buildGetAllCRUDTypeInstance() {
		return new EntityWFCtxInfo(EntityConstants.ENTITY_TRANSAC_TYPE_GET_ALL);
	}

	public static EntityWFCtxInfo buildDeleteCRUDTypeInstance(Long entityInfoId) {
		return new EntityWFCtxInfo(EntityConstants.ENTITY_TRANSAC_TYPE_DELETE, entityInfoId);
	}

}
