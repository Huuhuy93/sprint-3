import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BookCreateComponent} from "./book-create.component";


const routes: Routes = [{
  path: 'book/create' , component: BookCreateComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookCreateRoutingModule { }
