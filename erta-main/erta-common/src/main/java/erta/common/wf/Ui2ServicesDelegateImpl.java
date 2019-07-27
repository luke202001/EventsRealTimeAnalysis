package erta.common.wf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import erta.common.config.AppConfigUtil;
import erta.common.entity.BaseEntity;

public abstract class Ui2ServicesDelegateImpl<C extends WFCtxInfo, E extends BaseEntity>
		implements Ui2ServicesDelegate<C, E> {

	@Autowired
	private AppConfigUtil appConfigUtil;

	@Autowired
	private RestTemplate restTemplate;

	private String processContextName;

	public Ui2ServicesDelegateImpl(String processContextName) {
		this.processContextName = processContextName;
	}

	@Override
	public RestTemplate getRestTempalte() {
		return restTemplate;
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
