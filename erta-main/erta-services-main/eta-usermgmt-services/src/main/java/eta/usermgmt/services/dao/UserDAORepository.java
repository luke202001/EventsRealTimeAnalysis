package eta.usermgmt.services.dao;

import org.springframework.stereotype.Repository;

import erta.common.dto.AppCtxResponseInfo;
import erta.common.entity.user.UserInfo;
import erta.common.wf.api.WFCtxInfo;
import erta.common.wf.dao.CRUDWFTaskBaseDAO;

@Repository("UserDAORepository")
public interface UserDAORepository extends CRUDWFTaskBaseDAO<WFCtxInfo, UserInfo, AppCtxResponseInfo> {

}
