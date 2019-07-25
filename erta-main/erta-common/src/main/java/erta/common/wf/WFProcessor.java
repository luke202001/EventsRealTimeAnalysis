package erta.common.wf;

import org.springframework.beans.factory.annotation.Autowired;

import erta.common.config.AppConfigUtil;

public class WFProcessor<T extends WFCtxInfo, R extends WFResult> {

	@Autowired
	protected AppConfigUtil appConfigUtil;

	public WFProcessor() {
	}

	@SuppressWarnings("unchecked")
	protected void executeWFTasks(String wfTaskBeanIdsCSVKey, T ctxInfo) {

		String wfTaskBeanIdsCSV = this.appConfigUtil.getProperty(wfTaskBeanIdsCSVKey);
		
		String[] wfBeanIds = wfTaskBeanIdsCSV.split(",");

		WFResult result;
		for (String aWFBeanId : wfBeanIds) {
			result = executeAWFTaskBean(this.appConfigUtil.appCtx.getBean(aWFBeanId, WFTask.class), ctxInfo);

			if (!result.getResult()) {
				break;
			}
		}
	}

	public R executeAWFTaskBean(WFTask<T, R> wfTask, T ctxInfo) {
		return wfTask.executeTask(ctxInfo);
	}

}
