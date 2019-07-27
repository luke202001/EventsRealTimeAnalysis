import { AppCtxResponseInfo } from './app-ctx-response-info';
import { BaseEntity } from '../entity/base-entity';

export class EntityViewInfo extends AppCtxResponseInfo{

  eventInfo: BaseEntity;
  entities: BaseEntity[];
  

}
