package erta.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import erta.common.config.AppConfigUtil;
import erta.common.domain.EventInfo;
import erta.common.dto.EventViewInfo;
import erta.common.wf.EventWFCtxInfo;
import erta.common.wf.WFProcessor;
import erta.common.wf.WFResult;

public class AppCRUDBaseController extends WFProcessor<EventWFCtxInfo, WFResult> {

	private String crudConfigPrefixName;
	private String crudConfigPrefixValue;

	@Autowired
	protected AppConfigUtil appConfigUtil;

	public AppCRUDBaseController(String crudConfigPrefixName) {
		this.crudConfigPrefixName = crudConfigPrefixName;
		this.crudConfigPrefixValue = this.crudConfigPrefixName + ".";
	}

	@PostMapping(path = "/save")
	public ResponseEntity<Long> saveEventInfo(@RequestBody EventInfo eventInfo) {

		EventWFCtxInfo ctxInfo = EventWFCtxInfo.buildtCreateCRUDTypeInstance();
		ctxInfo.addEventInfo(eventInfo);

		super.executeWFTasks(this.crudConfigPrefixValue + "workflows.save", ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEventInfoId());
	}

	@PostMapping(path = "/update")
	public ResponseEntity<Long> updateEventInfo(@RequestBody EventInfo eventInfo) {

		EventWFCtxInfo ctxInfo = EventWFCtxInfo.buildUpdateCRUDTypeInstance();
		ctxInfo.addEventInfo(eventInfo);

		super.executeWFTasks(this.crudConfigPrefixValue + "workflows.update", ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEventInfoId());
	}

	@PostMapping(path = "/delete/{id}")
	public ResponseEntity<Long> deleteEventInfo(@PathVariable Long eventInfoId) {

		EventWFCtxInfo ctxInfo = EventWFCtxInfo.buildUpdateCRUDTypeInstance();
		ctxInfo.addEventInfoId(eventInfoId);

		super.executeWFTasks(this.crudConfigPrefixValue + "workflows.delete", ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEventInfoId());
	}

	@RequestMapping(path = "/get/{id}")
	public ResponseEntity<EventViewInfo> getEventInfo(@PathVariable("id") Long eventInfoId) {

		EventWFCtxInfo ctxInfo = EventWFCtxInfo.buildGetCRUDTypeInstance();
		ctxInfo.addEventInfoId(eventInfoId);

		super.executeWFTasks(this.crudConfigPrefixValue + "workflows.get", ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEventViewInfo());
	}

	@RequestMapping(path = "/getall")
	public ResponseEntity<EventViewInfo> getAllEventInfos() {

		EventWFCtxInfo ctxInfo = EventWFCtxInfo.buildGetAllCRUDTypeInstance();

		super.executeWFTasks(this.crudConfigPrefixValue + "workflows.getall", ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEventViewInfo());
	}

	public String getCrudConfigPrefixName() {
		return crudConfigPrefixName;
	}

	public void setCrudConfigPrefixName(String crudConfigPrefixName) {
		this.crudConfigPrefixName = crudConfigPrefixName;
	}

	public String getCrudConfigPrefixValue() {
		return crudConfigPrefixValue;
	}

	public void setCrudConfigPrefixValue(String crudConfigPrefixValue) {
		this.crudConfigPrefixValue = crudConfigPrefixValue;
	}

}
