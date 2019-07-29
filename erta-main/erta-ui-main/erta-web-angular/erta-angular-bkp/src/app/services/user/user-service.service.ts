import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EntityViewInfo } from '../../common/dto/entity-view-info';
import { UserInfo } from '../../common/entity/user/user-info';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private userServicesUrl: string;

  constructor(private http: HttpClient) { 
    this.userServicesUrl = 'http://localhost:9191/ui/services/user';
  }

  public findAll(): Observable<EntityViewInfo> {
    return this.http.get<EntityViewInfo>(this.userServicesUrl + "/getall");
  }

  public save(user: UserInfo) {
    return this.http.post<UserInfo>(this.userServicesUrl + "/save", user);
  }

  public update(user: UserInfo) {
    return this.http.post<UserInfo>(this.userServicesUrl + "/update", user);
  }

  public delete(userId: string) {
    return this.http.post<string>(this.userServicesUrl + "/delete/" , userId);
  }

  public findById(userId: string): Observable<EntityViewInfo> {
    return this.http.get<EntityViewInfo>(this.userServicesUrl + "/get/" + userId);
  }
}
