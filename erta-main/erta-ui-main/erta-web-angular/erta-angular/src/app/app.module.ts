import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './controller/user/user-list/user-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { MatToolbarModule, MatIconModule, MatSidenavModule, MatListModule, MatButtonModule,MatCardModule, MatFormFieldModule } from '@angular/material';
import { LoginLayoutComponent } from './controller/user/login-layout/login-layout.component';
import { HomeLayoutComponent } from './controller/user/home-layout/home-layout.component';
import { LoginComponent } from './controller/user/login/login.component';
import { NavigationComponent } from './controller/user/navigation/navigation.component';
import { ToolbarComponent } from './controller/common/toolbar/toolbar.component';
import { SidenavModule } from './modules/sidenav/sidenav.module';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    LoginLayoutComponent,
    HomeLayoutComponent,
    LoginComponent,
    NavigationComponent,
    ToolbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatFormFieldModule,
    SidenavModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
