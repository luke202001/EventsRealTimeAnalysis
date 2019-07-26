package eta.usermgmt.services.impl;

import org.springframework.stereotype.Service;

import erta.common.constants.AppServiceConstants;
import erta.common.entity.user.UserInfo;
import erta.common.services.event.AppService;
import erta.common.wf.api.WFCtxInfo;
import erta.common.wf.service.CRUDWFTaskBaseService;

@Service(AppServiceConstants.BEAN_ID_USER_SERVICES_IMPL)
public class UserServiceImpl extends CRUDWFTaskBaseService<WFCtxInfo, UserInfo> implements AppService<WFCtxInfo> {

	public UserServiceImpl() {
	}

}
