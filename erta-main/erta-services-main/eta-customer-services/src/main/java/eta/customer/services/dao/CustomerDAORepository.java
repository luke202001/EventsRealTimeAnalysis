package eta.customer.services.dao;

import org.springframework.stereotype.Repository;

import erta.common.dto.AppCtxResponseInfo;
import erta.common.entity.customer.CustomerInfo;
import erta.common.wf.api.WFCtxInfo;
import erta.common.wf.dao.CRUDWFTaskBaseDAO;

@Repository("CustomerDAORepository")
public interface CustomerDAORepository extends CRUDWFTaskBaseDAO<WFCtxInfo, CustomerInfo, AppCtxResponseInfo> {

}
