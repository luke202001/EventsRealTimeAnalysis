package erta.common.wf.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import erta.common.config.AppConfigUtil;
import erta.common.constants.EntityConstants;
import erta.common.dto.EntityViewInfo;
import erta.common.entity.BaseEntity;
import erta.common.wf.CrudWFTask;
import erta.common.wf.WFCtxInfo;

public class Ui2ServicesDelegateWFTask<T extends WFCtxInfo, E extends BaseEntity> implements CrudWFTask<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui2ServicesDelegateWFTask.class);

	@Autowired
	private AppConfigUtil appConfigUtil;

	private RestTemplate servicesRestTemplate;
	private String processContextName;

	public Ui2ServicesDelegateWFTask(RestTemplate servicesRestTemplate, String processContextName) {
		this.servicesRestTemplate = servicesRestTemplate;
		this.processContextName = processContextName;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/get/{id}")
	public ResponseEntity<EntityViewInfo<E>> get(@PathVariable("id") Long entityId) {

		WFCtxInfo wfCtxInfo = deleteRequestToServices(null, "/" + entityId);

		return ResponseEntity.ok().body(wfCtxInfo.getEntityViewInfo());
	}

	private WFCtxInfo deleteRequestToServices(Object httpEntityObj, String urlQueryParams) {
		LOGGER.debug("Enter");

		WFCtxInfo wfCtxInfo = new WFCtxInfo();

		wfCtxInfo.addProcessContextName(processContextName);

		ResponseEntity<EntityViewInfo<E>> response = servicesRestTemplate.exchange(
				appConfigUtil.getUi2ServicesDelegateRestUrl(processContextName, EntityConstants.ENTITY_TRANSAC_TYPE_GET)
						+ urlQueryParams,
				HttpMethod.GET, new HttpEntity<>(httpEntityObj), new ParameterizedTypeReference<EntityViewInfo<E>>() {
				});

		wfCtxInfo.addEntityViewInfo(response.getBody());

		LOGGER.debug("Exit");
		return wfCtxInfo;
	}

}
