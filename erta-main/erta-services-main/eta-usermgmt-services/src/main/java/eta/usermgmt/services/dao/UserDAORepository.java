package eta.usermgmt.services.dao;

import erta.common.dto.AppCtxResponseInfo;
import erta.common.entity.user.UserInfo;
import erta.common.wf.api.WFCtxInfo;
import erta.common.wf.dao.CRUDWFTaskBaseDAO;

public abstract class UserDAORepository extends CRUDWFTaskBaseDAO<WFCtxInfo, UserInfo, AppCtxResponseInfo> {

	public UserDAORepository() {
	}

}
