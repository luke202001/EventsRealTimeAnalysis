package erta.ui.bff.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erta.common.dto.EntityWFCtxInfo;
import erta.common.entity.event.EventInfo;
import erta.common.wf.controller.CRUDWFBaseController;

@RestController
@RequestMapping("/ui/services/event")
public class UiEventController extends CRUDWFBaseController<EntityWFCtxInfo, EventInfo> {

	public UiEventController() {
		super(UiEventController.class.getName());
	}

}
