package erta.common.wf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import erta.common.constants.EntityConstants;
import erta.common.services.AppService;

public interface CrudWFTask<T extends WFCtxInfo> extends WFTask<T>, AppService<T> {

	public static final Logger LOGGER = LoggerFactory.getLogger(CrudWFTask.class);

	default WFResult executeTask(T wfCtxInfo) {
		LOGGER.debug("Enter EntityCRUDType " + wfCtxInfo.getEntityCRUDType());

		WFResult result = null;

		switch (wfCtxInfo.getEntityCRUDType()) {
		case EntityConstants.ENTITY_TRANSAC_TYPE_CREATE:
			result = (WFResult) this.create(wfCtxInfo);
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_UPDATE:
			result = (WFResult) this.update(wfCtxInfo);
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_DELETE:
			result = (WFResult) this.delete(wfCtxInfo);
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_GET:
			LOGGER.debug("EntityCRUDType get matched");
			result = (WFResult) this.get(wfCtxInfo);
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_GET_ALL:
			result = (WFResult) this.getAll(wfCtxInfo);
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
	default WFResult create(T x) {
		LOGGER.debug("Enter & Exit");
		return WFResult.NOT_PROCESSED;
	}

	@Override
	default WFResult update(T x) {
		LOGGER.debug("Enter & Exit");
		return WFResult.NOT_PROCESSED;
	}

	@Override
	default WFResult delete(T x) {
		LOGGER.debug("Enter & Exit");
		return WFResult.NOT_PROCESSED;
	}

	@Override
	default WFResult get(T x) {
		LOGGER.debug("Enter & Exit");
		return WFResult.NOT_PROCESSED;
	}

	@Override
	default WFResult getAll(T x) {
		LOGGER.debug("Enter & Exit");
		return WFResult.NOT_PROCESSED;
	}

}
