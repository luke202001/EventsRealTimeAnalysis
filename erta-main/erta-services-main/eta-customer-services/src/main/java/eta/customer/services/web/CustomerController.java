package eta.customer.services.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erta.common.constants.AppServiceConstants;
import erta.common.dto.EntityWFCtxInfo;
import erta.common.entity.customer.CustomerInfo;
import erta.common.wf.controller.CRUDWFBaseController;

@RestController
@RequestMapping("/api/customer-services")

public class CustomerController extends CRUDWFBaseController<EntityWFCtxInfo, CustomerInfo> {

	public CustomerController() {
		super(AppServiceConstants.SERVICES_CUSTOMER_NAME);
	}

}
