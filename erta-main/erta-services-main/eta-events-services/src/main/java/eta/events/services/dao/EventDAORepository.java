package eta.events.services.dao;

import org.springframework.stereotype.Repository;

import erta.common.dao.CRUDWFTaskBaseDAO;
import erta.common.dto.AppCtxResponseInfo;
import erta.common.entity.event.EventInfo;
import erta.common.wf.WFCtxInfo;

@Repository("EventDAORepository")
public interface EventDAORepository extends CRUDWFTaskBaseDAO<WFCtxInfo, EventInfo, AppCtxResponseInfo> {

}
