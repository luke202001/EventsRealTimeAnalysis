import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidenavComponent } from './sidenav.component';
import { MatSidenavModule, MatToolbarModule, MatIconModule, MatButtonModule, MatListModule } from '@angular/material';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [SidenavComponent],
  imports: [
    CommonModule
  ],
  exports: [SidenavComponent]
})
export class SidenavModule { }
