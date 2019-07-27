package erta.common.wf.tasks.beans;

import org.springframework.stereotype.Component;

import erta.common.constants.AppServiceConstants;
import erta.common.constants.EntityConstants;
import erta.common.entity.BaseEntity;
import erta.common.entity.user.UserInfo;
import erta.common.wf.Ui2ServicesDelegateImpl;
import erta.common.wf.WFCtxInfo;
import erta.common.wf.WFResult;
import erta.common.wf.WFTask;

@Component("FetchAndCacheUserInfoWFTask")
public class FetchAndCacheUserInfoWFTask extends Ui2ServicesDelegateImpl<WFCtxInfo, BaseEntity>
		implements WFTask<WFCtxInfo> {

	public FetchAndCacheUserInfoWFTask() {
		super(AppServiceConstants.SERVICES_USER_NAME);
	}

	@Override
	public WFResult executeTask(WFCtxInfo wfCtxInfo) {

		if (wfCtxInfo.getCtxUserId() != null) {

			WFCtxInfo userInfoCtx = this.deleteRequestToServices(null, "/" + wfCtxInfo.getCtxUserId(),
					EntityConstants.ENTITY_TRANSAC_TYPE_GET);

			UserInfo userInfo = (UserInfo) userInfoCtx.getEntityInfo();
			wfCtxInfo.addCtxUserInfoObj(userInfo);
		}

		return WFResult.SUCCESS;
	}

}
