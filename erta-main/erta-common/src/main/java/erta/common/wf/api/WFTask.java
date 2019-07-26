/**
 * 
 */
package erta.common.wf.api;

public interface WFTask<T extends WFCtxInfo> {

	WFResult executeTask(T wfCtxInfo);

}
