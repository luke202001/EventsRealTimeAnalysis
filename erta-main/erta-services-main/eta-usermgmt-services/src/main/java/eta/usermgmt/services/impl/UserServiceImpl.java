package eta.usermgmt.services.impl;

import org.springframework.stereotype.Service;

import erta.common.constants.AppServiceConstants;
import erta.common.entity.user.UserInfo;
import erta.common.services.AppService;
import erta.common.wf.WFCtxInfo;
import erta.common.wf.tasks.CrudWFTaskBaseService;

@Service(AppServiceConstants.BEAN_ID_USER_SERVICES_IMPL)
public class UserServiceImpl extends CrudWFTaskBaseService<WFCtxInfo, UserInfo> implements AppService<WFCtxInfo> {

	public UserServiceImpl() {
	}

}
