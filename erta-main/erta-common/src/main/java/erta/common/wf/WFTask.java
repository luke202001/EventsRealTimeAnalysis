/**
 * 
 */
package erta.common.wf;

public interface WFTask<T extends WFCtxInfo> {

	WFResult executeTask(T wfCtxInfo);

}
