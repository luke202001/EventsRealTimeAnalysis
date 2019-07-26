package erta.common.wf.api;

import java.io.Serializable;

import erta.common.dto.AppCtxResponseInfo;

public class WFResult extends AppCtxResponseInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final WFResult NOT_PROCESSED = new WFResult(RESULT_NOT_PROCESSED);
	public static final WFResult SUCCESS = new WFResult(RESULT_SUCCESS);
	public static final WFResult FAIL = new WFResult(RESULT_FAIL);

	public WFResult() {
	}

	public WFResult(int result) {
		super(result);
	}

	@Override
	public String toString() {
		return "WFResult [toString()=" + super.toString() + "]";
	}

}
