package erta.common.wf.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import erta.common.config.AppConfigUtil;
import erta.common.constants.EntityConstants;
import erta.common.entity.BaseEntity;
import erta.common.wf.CrudWFTask;
import erta.common.wf.Ui2ServicesDelegate;
import erta.common.wf.WFCtxInfo;
import erta.common.wf.WFResult;

public class Ui2ServicesDelegateWFTask<T extends WFCtxInfo, E extends BaseEntity>
		implements CrudWFTask<T>, Ui2ServicesDelegate<T, E> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui2ServicesDelegateWFTask.class);

	@Autowired
	private AppConfigUtil appConfigUtil;

	@Autowired
	private RestTemplate servicesRestTemplate;

	private String processContextName;

	public Ui2ServicesDelegateWFTask(String processContextName) {
		this.processContextName = processContextName;
	}

	@Override
	public WFResult get(T x) {
		LOGGER.debug("Enter");

		WFCtxInfo wfCtxInfo = deleteRequestToServices(null, "/" + x.getEntityId(),
				EntityConstants.ENTITY_TRANSAC_TYPE_GET);

		x.addEntityViewInfo(wfCtxInfo.getEntityViewInfo());

		LOGGER.debug("Exit");
		return WFResult.SUCCESS;
	}

	@Override
	public WFResult getAll(T x) {
		LOGGER.debug("Enter");

		WFCtxInfo wfCtxInfo = deleteRequestToServices(null, "/" + x.getEntityId(),
				EntityConstants.ENTITY_TRANSAC_TYPE_GET_ALL);

		x.addEntityViewInfo(wfCtxInfo.getEntityViewInfo());

		LOGGER.debug("Exit");
		return WFResult.SUCCESS;
	}

	@Override
	public RestTemplate getRestTempalte() {
		return servicesRestTemplate;
	}

	@Override
	public AppConfigUtil getAppConfigUtil() {
		return appConfigUtil;
	}

	@Override
	public String getProcessContextName() {
		return processContextName;
	}

}
