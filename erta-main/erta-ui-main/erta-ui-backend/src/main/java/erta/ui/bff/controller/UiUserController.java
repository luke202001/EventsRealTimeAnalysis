package erta.ui.bff.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erta.common.wf.controller.CRUDWFBaseController;

@RestController
@RequestMapping("/ui/services/user")
public class UiUserController extends CRUDWFBaseController {

	public UiUserController() {
		super(UiUserController.class.getSimpleName());
	}

}
