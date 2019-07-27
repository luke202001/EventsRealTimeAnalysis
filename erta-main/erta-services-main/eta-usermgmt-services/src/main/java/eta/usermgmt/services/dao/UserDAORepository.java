package eta.usermgmt.services.dao;

import org.springframework.stereotype.Repository;

import erta.common.dao.CRUDWFTaskBaseDAO;
import erta.common.dto.AppCtxResponseInfo;
import erta.common.entity.user.UserInfo;
import erta.common.wf.WFCtxInfo;

@Repository("UserDAORepository")
public interface UserDAORepository extends CRUDWFTaskBaseDAO<WFCtxInfo, UserInfo, AppCtxResponseInfo> {

}
