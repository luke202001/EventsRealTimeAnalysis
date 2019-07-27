package erta.common.wf;

public class WFUtil {

	public WFUtil() {
	}

	public static boolean isWFResultFailed(WFResult wfResult) {
		return wfResult.getResult() == WFResult.RESULT_FAIL;
	}

}
