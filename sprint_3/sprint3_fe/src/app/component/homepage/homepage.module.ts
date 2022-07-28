import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomepageRoutingModule } from './homepage-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {HomepageComponent} from "./homepage.component";


@NgModule({
  declarations: [HomepageComponent],
  exports: [
    HomepageComponent
  ],
  imports: [
    CommonModule,
    HomepageRoutingModule,
    HttpClientModule
  ]
})
export class HomepageModule { }
