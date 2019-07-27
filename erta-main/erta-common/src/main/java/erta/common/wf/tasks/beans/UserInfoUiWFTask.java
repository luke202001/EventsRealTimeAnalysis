package erta.common.wf.tasks.beans;

import org.springframework.stereotype.Component;

import erta.common.constants.AppServiceConstants;
import erta.common.entity.user.UserInfo;
import erta.common.wf.WFCtxInfo;
import erta.common.wf.tasks.Ui2ServicesDelegateWFTask;

@Component("UserInfoUiWFTask")
public class UserInfoUiWFTask extends Ui2ServicesDelegateWFTask<WFCtxInfo, UserInfo> {

	public UserInfoUiWFTask() {
		super(AppServiceConstants.SERVICES_USER_NAME);
	}

}
