package eta.customer.services.impl;

import org.springframework.stereotype.Service;

import erta.common.constants.AppServiceConstants;
import erta.common.entity.customer.CustomerInfo;
import erta.common.services.AppService;
import erta.common.wf.WFCtxInfo;
import erta.common.wf.tasks.CrudWFTaskBaseService;

@Service(AppServiceConstants.BEAN_ID_CUSTOMER_SERVICES_IMPL)
public class CustomerServiceImpl extends CrudWFTaskBaseService<WFCtxInfo, CustomerInfo>
		implements AppService<WFCtxInfo> {

	public CustomerServiceImpl() {
	}

}
