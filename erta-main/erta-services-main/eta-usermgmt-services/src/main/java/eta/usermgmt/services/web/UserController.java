package eta.usermgmt.services.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erta.common.constants.AppServiceConstants;
import erta.common.wf.controller.CRUDWFBaseController;

@RestController
@RequestMapping("/api/user-services")
public class UserController extends CRUDWFBaseController {

	public UserController() {
		super(AppServiceConstants.SERVICES_USER_NAME);
	}
	
	

}
