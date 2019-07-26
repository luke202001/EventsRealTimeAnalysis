package eta.customer.services.impl;

import org.springframework.stereotype.Service;

import erta.common.constants.AppServiceConstants;
import erta.common.entity.customer.CustomerInfo;
import erta.common.services.event.AppService;
import erta.common.wf.api.WFCtxInfo;
import erta.common.wf.service.CRUDWFTaskBaseService;

@Service(AppServiceConstants.BEAN_ID_CUSTOMER_SERVICES_IMPL)
public class CustomerServiceImpl extends CRUDWFTaskBaseService<WFCtxInfo, CustomerInfo>
		implements AppService<WFCtxInfo> {

	public CustomerServiceImpl() {
	}

}
