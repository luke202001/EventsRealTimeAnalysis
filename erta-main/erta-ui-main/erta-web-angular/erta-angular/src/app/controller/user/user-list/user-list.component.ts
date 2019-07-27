import { Component, OnInit } from '@angular/core';
import { EntityViewInfo } from '../../../common/dto/entity-view-info';
import { UserInfo } from '../../../common/entity/user/user-info';
import { UserServiceService } from '../../../services/user/user-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: UserInfo[];

  constructor(private userService: UserServiceService) { }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    })
  }

}
