package eta.events.services.dao;

import org.springframework.stereotype.Repository;

import erta.common.dto.AppCtxResponseInfo;
import erta.common.entity.event.EventInfo;
import erta.common.wf.api.WFCtxInfo;
import erta.common.wf.dao.CRUDWFTaskBaseDAO;

@Repository("EventDAORepository")
public interface EventDAORepository extends CRUDWFTaskBaseDAO<WFCtxInfo, EventInfo, AppCtxResponseInfo> {

}
