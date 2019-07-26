package erta.common.services;

import erta.common.dto.AppCtxRequestInfo;
import erta.common.dto.AppCtxResponseInfo;

public interface AppService<T extends AppCtxRequestInfo> {

	AppCtxResponseInfo create(T x);

	AppCtxResponseInfo update(T x);

	AppCtxResponseInfo delete(T x);

	AppCtxResponseInfo get(T x);

	AppCtxResponseInfo getAll(T x);

}
