package erta.common.wf.tasks.beans;

import org.springframework.stereotype.Component;

import erta.common.constants.AppServiceConstants;
import erta.common.entity.customer.CustomerInfo;
import erta.common.wf.WFCtxInfo;
import erta.common.wf.tasks.Ui2ServicesDelegateWFTask;

@Component("CustomerInfoUiWFTask")
public class CustomerInfoUiWFTask extends Ui2ServicesDelegateWFTask<WFCtxInfo, CustomerInfo> {

	public CustomerInfoUiWFTask() {
		super(AppServiceConstants.SERVICES_CUSTOMER_NAME);
	}

}
