package erta.common.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.NoRepositoryBean;

import erta.common.constants.EntityConstants;
import erta.common.dto.AppCtxResponseInfo;
import erta.common.dto.EntityViewInfo;
import erta.common.entity.BaseEntity;
import erta.common.wf.WFCtxInfo;
import erta.common.wf.WFResult;
import erta.common.wf.WFTask;

@NoRepositoryBean
public interface CRUDWFTaskBaseDAO<C extends WFCtxInfo, E extends BaseEntity, R extends AppCtxResponseInfo>
		extends WFTask<C>, AppCrudDAO<C, E, R> {

	public static final Logger LOGGER = LoggerFactory.getLogger(CRUDWFTaskBaseDAO.class);

	@Override
	@SuppressWarnings("unchecked")
	default WFResult executeTask(C wfCtxInfo) {
		LOGGER.debug("Enter EntityCRUDType " + wfCtxInfo.getEntityCRUDType());

		WFResult result = WFResult.NOT_PROCESSED;
		EntityViewInfo<E> entityViewInfo = new EntityViewInfo<E>();

		switch (wfCtxInfo.getEntityCRUDType()) {
		case EntityConstants.ENTITY_TRANSAC_TYPE_CREATE:

			E savedEntity = this.save((E) wfCtxInfo.getEntityInfo());
			wfCtxInfo.addEntityInfo(savedEntity);

			result = WFResult.SUCCESS;

			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_UPDATE:

			E updatedEntity = this.save((E) wfCtxInfo.getEntityInfo());
			wfCtxInfo.addEntityInfo(updatedEntity);

			result = WFResult.SUCCESS;

			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_DELETE:

			this.delete((E) wfCtxInfo.getEntityInfo());

			result = WFResult.SUCCESS;
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_GET:

			Optional<E> dbObject = this.findById(wfCtxInfo.getEntityId());

			if (dbObject.isPresent()) {

				E dbEntity = this.findById(wfCtxInfo.getEntityId()).get();
				entityViewInfo.setEventInfo(dbEntity);
			}

			result = WFResult.SUCCESS;
			break;
		case EntityConstants.ENTITY_TRANSAC_TYPE_GET_ALL:

			Iterable<E> allRows = (Iterable<E>) this.findAll();

			List<E> allEntities = new ArrayList<>();
			allRows.forEach(allEntities::add);

			entityViewInfo.setEventInfos(allEntities);

			wfCtxInfo.addEntityViewInfo(entityViewInfo);

			result = WFResult.SUCCESS;

			break;
		default:
			break;
		}

		wfCtxInfo.addEntityViewInfo(entityViewInfo);

		LOGGER.debug("Exit");
		return result;
	}

}
