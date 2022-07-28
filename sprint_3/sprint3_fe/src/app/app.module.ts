import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './common/header/header.component';
import { FooterComponent } from './common/footer/footer.component';
import { BookEditComponent } from './component/book/book-edit/book-edit.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {BookListModule} from "./component/book/book-list/book-list.module";
import {CKEditorModule} from "ckeditor4-angular";
import {AngularFireModule} from "@angular/fire";
import {environment} from "../environments/environment";


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BookEditComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BookListModule,
    CKEditorModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
