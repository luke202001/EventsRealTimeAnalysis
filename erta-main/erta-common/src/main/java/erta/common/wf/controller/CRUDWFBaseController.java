package erta.common.wf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import erta.common.config.AppConfigUtil;
import erta.common.dto.AppCtxResponseInfo;
import erta.common.entity.event.EventInfo;
import erta.common.wf.api.WFProcessor;
import erta.common.wf.dto.EntityWFCtxInfo;

public class CRUDWFBaseController extends WFProcessor<EntityWFCtxInfo> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CRUDWFBaseController.class);

	private String processorContext;

	@Autowired
	protected AppConfigUtil appConfigUtil;

	public CRUDWFBaseController(String processorContext) {
		this.processorContext = processorContext;
	}

	@PostMapping(path = "/save")
	public ResponseEntity<Long> saveEventInfo(@RequestBody EventInfo eventInfo) {

		EntityWFCtxInfo ctxInfo = EntityWFCtxInfo.buildtCreateCRUDTypeInstance(eventInfo);

		super.executeWFTasks(this.processorContext, ctxInfo.getEntityCRUDType(), ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEntityId());
	}

	@PostMapping(path = "/update")
	public ResponseEntity<Long> updateEventInfo(@RequestBody EventInfo eventInfo) {

		EntityWFCtxInfo ctxInfo = EntityWFCtxInfo.buildUpdateCRUDTypeInstance(eventInfo);

		super.executeWFTasks(this.processorContext, ctxInfo.getEntityCRUDType(), ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEntityId());
	}

	@PostMapping(path = "/delete/{id}")
	public ResponseEntity<Long> deleteEventInfo(@PathVariable Long entityInfoId) {

		EntityWFCtxInfo ctxInfo = EntityWFCtxInfo.buildDeleteCRUDTypeInstance(entityInfoId);

		super.executeWFTasks(this.processorContext, ctxInfo.getEntityCRUDType(), ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEntityId());
	}

	@RequestMapping(path = "/get/{id}")
	public ResponseEntity<AppCtxResponseInfo> getEventInfo(@PathVariable("id") Long entityInfoId) {
		LOGGER.debug("Enter");

		EntityWFCtxInfo ctxInfo = EntityWFCtxInfo.buildGetCRUDTypeInstance(entityInfoId);

		super.executeWFTasks(this.processorContext, ctxInfo.getEntityCRUDType(), ctxInfo);

		LOGGER.debug("Exit");
		return ResponseEntity.ok().body(ctxInfo.getEntityViewInfo());
	}

	@RequestMapping(path = "/getall")
	public ResponseEntity<AppCtxResponseInfo> getAllEventInfos() {

		EntityWFCtxInfo ctxInfo = EntityWFCtxInfo.buildGetAllCRUDTypeInstance();

		super.executeWFTasks(this.processorContext, ctxInfo.getEntityCRUDType(), ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEntityViewInfo());
	}

	public String getProcessorContext() {
		return processorContext;
	}

	public void setProcessorContext(String processorContext) {
		this.processorContext = processorContext;
	}

}
