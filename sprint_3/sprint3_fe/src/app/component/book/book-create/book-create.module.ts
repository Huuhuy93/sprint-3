
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookCreateRoutingModule } from './book-create-routing.module';
import {BookCreateComponent} from "./book-create.component";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [BookCreateComponent],
  exports: [
    BookCreateComponent
  ],
  imports: [
    CommonModule,
    BookCreateRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class BookCreateModule { }
