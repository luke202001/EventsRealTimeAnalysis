package erta.common.wf;

import java.io.Serializable;

public class WFResult implements Serializable {

	private static final long serialVersionUID = 1L;
	private Boolean result = Boolean.FALSE;

	public static final WFResult SUCCESS = new WFResult(Boolean.TRUE);
	public static final WFResult FAIL = new WFResult(Boolean.FALSE);

	public WFResult() {
	}

	public WFResult(Boolean result) {
		super();
		this.result = result;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

}
