package erta.common.wf.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import erta.common.config.AppConfigUtil;
import erta.common.wf.util.WFUtil;

public class WFProcessor<T extends WFCtxInfo> {

	private static final Logger LOGGER = LoggerFactory.getLogger(WFProcessor.class);

	@Autowired
	protected AppConfigUtil appConfigUtil;

	public WFProcessor() {
	}

	@SuppressWarnings("unchecked")
	protected void executeWFTasks(String processorContext, String processorName, T ctxInfo) {
		LOGGER.debug("Enter");

		String wfTaskBeanIdsCSV = this.appConfigUtil.getServicesWFActivitiesCSV(processorContext, processorName);
		String[] wfBeanIds = wfTaskBeanIdsCSV.split(",");

		WFResult wfResult;
		for (String aWFBeanId : wfBeanIds) {
			wfResult = executeAWFTaskBean(this.appConfigUtil.appCtx.getBean(aWFBeanId, WFTask.class), ctxInfo);

			if (WFUtil.isWFResultFailed(wfResult)) {
				break;
			}
		}

		LOGGER.debug("Exit");
	}

	public WFResult executeAWFTaskBean(WFTask<T> wfTask, T ctxInfo) {
		return wfTask.executeTask(ctxInfo);
	}

}
