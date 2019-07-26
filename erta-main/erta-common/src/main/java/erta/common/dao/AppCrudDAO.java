package erta.common.dao;

import org.springframework.data.repository.CrudRepository;

import erta.common.dto.AppCtxRequestInfo;
import erta.common.dto.AppCtxResponseInfo;
import erta.common.entity.BaseEntity;

public interface AppCrudDAO<C extends AppCtxRequestInfo, E extends BaseEntity, R extends AppCtxResponseInfo>
		extends AppDAO<C, E, R>, CrudRepository<E, Long> {

}
