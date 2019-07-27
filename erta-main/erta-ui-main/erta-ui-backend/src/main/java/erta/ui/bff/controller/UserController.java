package erta.ui.bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import erta.common.constants.AppServiceConstants;
import erta.common.entity.user.UserInfo;
import erta.common.wf.WFCtxInfo;
import erta.common.wf.tasks.Ui2ServicesDelegateWFTask;

@RestController
@RequestMapping("/ui/services/user")
public class UserController extends Ui2ServicesDelegateWFTask<WFCtxInfo, UserInfo> {

	@Autowired
	public UserController(RestTemplate restTemplate) {
		super(restTemplate, AppServiceConstants.SERVICES_USER_NAME);
	}

	

}
