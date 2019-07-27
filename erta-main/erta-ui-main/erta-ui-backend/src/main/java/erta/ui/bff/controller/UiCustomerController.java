package erta.ui.bff.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erta.common.dto.EntityWFCtxInfo;
import erta.common.entity.customer.CustomerInfo;
import erta.common.wf.controller.CRUDWFBaseController;

@RestController
@RequestMapping("/ui/services/customer")
public class UiCustomerController extends CRUDWFBaseController<EntityWFCtxInfo, CustomerInfo> {

	public UiCustomerController() {
		super(UiCustomerController.class.getName());
	}

}
