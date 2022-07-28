import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BookDto} from "../dtos/book-dto";
import {Book} from "../models/book";


export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/api/book'
};
const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getAll(name: any, page: number, id: number): Observable<any> {
    return this.http.get<any>(API_URL + `/list?page=${page}&keyName=${name}`);
  }

  deleteBook(a: Book): Observable<Book> {
    // @ts-ignore
    return this.http.patch<Book>(API_URL + `/delete/` + `${a.id}`);
  }
}
