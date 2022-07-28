import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookListRoutingModule } from './book-list-routing.module';
import {BookListComponent} from "./book-list.component";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [BookListComponent],
  exports: [
    BookListComponent
  ],
  imports: [
    CommonModule,
    BookListRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class BookListModule { }
