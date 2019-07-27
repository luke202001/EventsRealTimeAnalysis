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
import erta.common.dto.EntityWFCtxInfo;
import erta.common.entity.BaseEntity;
import erta.common.wf.WFProcessor;

public class CRUDWFBaseController<C extends EntityWFCtxInfo, E extends BaseEntity> extends WFProcessor<C> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CRUDWFBaseController.class);

	private String processorContext;

	@Autowired
	protected AppConfigUtil appConfigUtil;

	public CRUDWFBaseController(String processorContext) {
		this.processorContext = processorContext;
	}

	@SuppressWarnings("unchecked")
	@PostMapping(path = "/save")
	public ResponseEntity<Long> saveEntityInfo(@RequestBody E entityInfo) {

		EntityWFCtxInfo ctxInfo = EntityWFCtxInfo.buildtCreateCRUDTypeInstance(entityInfo);

		super.executeWFTasks(this.processorContext, ctxInfo.getEntityCRUDType(), (C) ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEntityId());
	}

	@SuppressWarnings("unchecked")
	@PostMapping(path = "/update")
	public ResponseEntity<Long> updateEntityInfo(@RequestBody E entityInfo) {

		EntityWFCtxInfo ctxInfo = EntityWFCtxInfo.buildUpdateCRUDTypeInstance(entityInfo);

		super.executeWFTasks(this.processorContext, ctxInfo.getEntityCRUDType(), (C) ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEntityId());
	}

	@SuppressWarnings("unchecked")
	@PostMapping(path = "/delete/{id}")
	public ResponseEntity<Long> deleteEntityInfo(@PathVariable Long entityInfoId) {

		EntityWFCtxInfo ctxInfo = EntityWFCtxInfo.buildDeleteCRUDTypeInstance(entityInfoId);

		super.executeWFTasks(this.processorContext, ctxInfo.getEntityCRUDType(), (C) ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEntityId());
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/get/{id}")
	public ResponseEntity<AppCtxResponseInfo> getEntityInfo(@PathVariable("id") Long entityInfoId) {
		LOGGER.debug("Enter");

		EntityWFCtxInfo ctxInfo = EntityWFCtxInfo.buildGetCRUDTypeInstance(entityInfoId);

		super.executeWFTasks(this.processorContext, ctxInfo.getEntityCRUDType(), (C) ctxInfo);

		LOGGER.debug("Exit");
		return ResponseEntity.ok().body(ctxInfo.getEntityViewInfo());
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(path = "/getall")
	public ResponseEntity<AppCtxResponseInfo> getAllEntityInfos() {

		EntityWFCtxInfo ctxInfo = EntityWFCtxInfo.buildGetAllCRUDTypeInstance();

		super.executeWFTasks(this.processorContext, ctxInfo.getEntityCRUDType(), (C) ctxInfo);

		return ResponseEntity.ok().body(ctxInfo.getEntityViewInfo());
	}

}
