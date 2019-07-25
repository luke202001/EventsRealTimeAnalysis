/**
 * 
 */
package erta.common.wf;

public interface WFTask<T extends WFCtxInfo, R extends WFResult> {

	R executeTask(T wfCtxInfo);

}
