package erta.common.wf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import erta.common.config.AppConfigUtil;
import erta.common.dto.EntityViewInfo;
import erta.common.entity.BaseEntity;

public interface Ui2ServicesDelegate<T extends WFCtxInfo, E extends BaseEntity> {

	public static final Logger LOGGER = LoggerFactory.getLogger(Ui2ServicesDelegate.class);

	default WFCtxInfo deleteRequestToServices(Object httpEntityObj, String urlQueryParams, String processName) {
		LOGGER.debug("Enter processName " + processName);

		ResponseEntity<EntityViewInfo<E>> response = getRestTempalte().exchange(
				getAppConfigUtil().getUi2ServicesDelegateRestUrl(getProcessContextName(), processName) + urlQueryParams,
				HttpMethod.GET, new HttpEntity<>(httpEntityObj), new ParameterizedTypeReference<EntityViewInfo<E>>() {
				});

		WFCtxInfo wfCtxInfo = new WFCtxInfo();
		wfCtxInfo.addProcessContextName(getProcessContextName());
		wfCtxInfo.addEntityViewInfo(response.getBody());

		LOGGER.debug("Exit");
		return wfCtxInfo;
	}

	RestTemplate getRestTempalte();

	AppConfigUtil getAppConfigUtil();

	String getProcessContextName();

}
