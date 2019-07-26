package erta.common.wf.util;

import erta.common.wf.api.WFResult;

public class WFUtil {

	public WFUtil() {
	}

	public static boolean isWFResultFailed(WFResult wfResult) {
		return wfResult.getResult() == WFResult.RESULT_FAIL;
	}

}
