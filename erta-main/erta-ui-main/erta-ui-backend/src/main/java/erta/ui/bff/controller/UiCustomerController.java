package erta.ui.bff.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erta.common.wf.controller.CRUDWFBaseController;

@RestController
@RequestMapping("/ui/services/customer")
public class UiCustomerController extends CRUDWFBaseController {

	public UiCustomerController() {
		super(UiCustomerController.class.getName());
	}

}
