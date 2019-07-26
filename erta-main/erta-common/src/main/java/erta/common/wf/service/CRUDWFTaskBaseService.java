package erta.common.wf.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import erta.common.constants.EntityConstants;
import erta.common.entity.BaseEntity;
import erta.common.services.AppService;
import erta.common.wf.api.WFCtxInfo;
import erta.common.wf.api.WFResult;
import erta.common.wf.api.WFTask;

public class CRUDWFTaskBaseService<T extends WFCtxInfo, E extends BaseEntity> implements WFTask<T>, AppService<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CRUDWFTaskBaseService.class);

	public CRUDWFTaskBaseService() {
	}

	@Override
	public WFResult executeTask(T wfCtxInfo) {
		LOGGER.debug("Enter EntityCRUDType " + wfCtxInfo.getEntityCRUDType());

		WFResult result = null;

		switch (wfCtxInfo.getEntityCRUDType()) {
		case EntityConstants.ENTITY_TRANSAC_TYPE_CREATE:
			result = this.create(wfCtxInfo);
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_UPDATE:
			result = this.update(wfCtxInfo);
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_DELETE:
			result = this.delete(wfCtxInfo);
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_GET:
			LOGGER.debug("EntityCRUDType get matched");
			result = this.get(wfCtxInfo);
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_GET_ALL:
			result = this.getAll(wfCtxInfo);
			break;
		default:
			LOGGER.debug("EntityCRUDType default matched so WFResult.NOT_PROCESSED");
			result = WFResult.NOT_PROCESSED;
			break;
		}

		LOGGER.debug("Exit");
		return result;
	}

	@Override
	public WFResult create(T x) {
		LOGGER.debug("Enter & Exit");
		return WFResult.NOT_PROCESSED;
	}

	@Override
	public WFResult update(T x) {
		LOGGER.debug("Enter & Exit");
		return WFResult.NOT_PROCESSED;
	}

	@Override
	public WFResult delete(T x) {
		LOGGER.debug("Enter & Exit");
		return WFResult.NOT_PROCESSED;
	}

	@Override
	public WFResult get(T x) {
		LOGGER.debug("Enter & Exit");
		return WFResult.NOT_PROCESSED;
	}

	@Override
	public WFResult getAll(T x) {
		LOGGER.debug("Enter & Exit");
		return WFResult.NOT_PROCESSED;
	}

}
