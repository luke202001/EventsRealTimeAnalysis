/**
 * 
 */
package erta.events.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erta.common.controller.AppCRUDBaseController;

@RestController
@RequestMapping("/api/events-app")
public class EventController extends AppCRUDBaseController {

	public EventController() {
		super("events.app");
	}

}
