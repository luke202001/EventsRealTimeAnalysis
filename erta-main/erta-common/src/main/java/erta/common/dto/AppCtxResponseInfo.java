package erta.common.dto;

public class AppCtxResponseInfo extends BaseDTO {

	private static final long serialVersionUID = 1L;

	public static final int RESULT_NOT_PROCESSED = -1;
	public static final int RESULT_FAIL = 0;
	public static final int RESULT_SUCCESS = 1;

	private Integer result = RESULT_NOT_PROCESSED;

	public static final AppCtxResponseInfo NOT_PROCESSED = new AppCtxResponseInfo(RESULT_NOT_PROCESSED);
	public static final AppCtxResponseInfo SUCCESS = new AppCtxResponseInfo(RESULT_SUCCESS);
	public static final AppCtxResponseInfo FAIL = new AppCtxResponseInfo(RESULT_FAIL);

	public AppCtxResponseInfo() {
	}

	public AppCtxResponseInfo(int result) {
		super();
		this.result = result;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer responseResult) {
		this.result = responseResult;
	}

	@Override
	public String toString() {
		return "AppCtxResponseInfo [result=" + result + "]";
	}

}
