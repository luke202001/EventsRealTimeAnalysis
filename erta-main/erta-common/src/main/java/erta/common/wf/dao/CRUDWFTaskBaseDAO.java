package erta.common.wf.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.NoRepositoryBean;

import erta.common.constants.EntityConstants;
import erta.common.dao.AppCrudDAO;
import erta.common.dto.AppCtxResponseInfo;
import erta.common.dto.EntityViewInfo;
import erta.common.entity.BaseEntity;
import erta.common.wf.api.WFCtxInfo;
import erta.common.wf.api.WFResult;
import erta.common.wf.api.WFTask;

@NoRepositoryBean
public abstract class CRUDWFTaskBaseDAO<C extends WFCtxInfo, E extends BaseEntity, R extends AppCtxResponseInfo>
		implements WFTask<C>, AppCrudDAO<C, E, R> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CRUDWFTaskBaseDAO.class);

	public CRUDWFTaskBaseDAO() {
	}

	@Override
	@SuppressWarnings("unchecked")
	public WFResult executeTask(C wfCtxInfo) {
		LOGGER.debug("Enter EntityCRUDType " + wfCtxInfo.getEntityCRUDType());

		WFResult result = WFResult.NOT_PROCESSED;
		E savedOrUpdatedEntity = null;

		switch (wfCtxInfo.getEntityCRUDType()) {
		case EntityConstants.ENTITY_TRANSAC_TYPE_CREATE:

			savedOrUpdatedEntity = this.save((E) wfCtxInfo.getEntityInfo());
			wfCtxInfo.addEntityInfo(savedOrUpdatedEntity);

			result = WFResult.SUCCESS;

			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_UPDATE:

			savedOrUpdatedEntity = this.save((E) wfCtxInfo.getEntityInfo());
			wfCtxInfo.addEntityInfo(savedOrUpdatedEntity);

			result = WFResult.SUCCESS;

			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_DELETE:

			this.delete((E) wfCtxInfo.getEntityInfo());

			result = WFResult.SUCCESS;
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_GET:

			savedOrUpdatedEntity = this.findById(wfCtxInfo.getEntityId()).get();
			wfCtxInfo.addEntityInfo(savedOrUpdatedEntity);

			result = WFResult.SUCCESS;
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_GET_ALL:

			Iterable<BaseEntity> allRows = (Iterable<BaseEntity>) this.findAll();

			List<BaseEntity> allEntities = new ArrayList<>();
			allRows.forEach(allEntities::add);

			EntityViewInfo<BaseEntity> ctxResponseInfo = new EntityViewInfo<>();
			ctxResponseInfo.setEventInfos(allEntities);

			wfCtxInfo.addEntityViewInfo(ctxResponseInfo);

			result = WFResult.SUCCESS;

			break;
		default:
			break;
		}

		LOGGER.debug("Exit");
		return result;
	}

}
