import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BookListComponent} from "../book/book-list/book-list.component";


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomepageRoutingModule { }
