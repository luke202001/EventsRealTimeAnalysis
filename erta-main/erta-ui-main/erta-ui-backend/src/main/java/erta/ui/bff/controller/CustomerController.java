package erta.ui.bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import erta.common.constants.AppServiceConstants;
import erta.common.entity.customer.CustomerInfo;
import erta.common.wf.WFCtxInfo;
import erta.common.wf.tasks.Ui2ServicesDelegateWFTask;

//@RestController("/ui/services/customer")
public class CustomerController extends Ui2ServicesDelegateWFTask<WFCtxInfo, CustomerInfo> {

	@Autowired
	public CustomerController(RestTemplate restTemplate) {
		super(restTemplate, AppServiceConstants.SERVICES_CUSTOMER_NAME);
	}

}
