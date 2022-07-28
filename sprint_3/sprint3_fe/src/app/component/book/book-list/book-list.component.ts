import { Component, OnInit } from '@angular/core';
import {BookDto} from "../../../dtos/book-dto";
import {Book} from "../../../models/book";
import {BookService} from "../../../services/book.service";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: BookDto[] = [];
  message: boolean;
  page: any;
  totalPages = 0;
  pageSize: 0;
  firsts: boolean;
  last: boolean;
  name: any = '';
  check: boolean;
  deleteFriend: Book;
  id: number;


  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    let preveiwContainer = document.querySelector('.products-preview');
    let previewBox = preveiwContainer.querySelectorAll('.preview');

    document.querySelectorAll('.products-container .product').forEach(product =>{
      // @ts-ignore
      product.onclick = () =>{
        // @ts-ignore
        preveiwContainer.style.display = 'flex';
        let name = product.getAttribute('data-name');
        previewBox.forEach(preview =>{
          let target = preview.getAttribute('data-target');
          if(name == target){
            preview.classList.add('active');
          }
        });
      };
    });

    previewBox.forEach(close =>{
      // @ts-ignore
      close.querySelector('.fa-times').onclick = () =>{
        close.classList.remove('active');
        // @ts-ignore
        preveiwContainer.style.display = 'none';
      };
    });

    this.getAll();
  }

  private getAll() {
    this.message = false;
    this.bookService.getAll('', this.page, this.id).subscribe(data => {
      // @ts-ignore
      this.books = data.content;
      this.page = data.number;
      this.totalPages = data.totalPages;
      this.pageSize  = data.pageable.pageSize;
      this.firsts = data.first;
      this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
    }, error => {
      this.message = true;
    });
  }

  previous() {
    if (this.page > 0) {
      this.bookService.getAll(this.name, this.page - 1, this.id).subscribe(
        data => {
          this.books = data.content;
          this.page = data.number;
          this.firsts = data.first;
          this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
        }, err => {
          console.log(err);
        }
      );
    }
  }

  next() {
    if (this.page < this.totalPages - 1) {
      this.bookService.getAll(this.name, this.page + 1, this.id).subscribe(
        data => {
          this.books = data.content;
          this.page = data.number;
          this.firsts = data.first;
          this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
        }, err => {
          console.log(err);
        }
      );
    }
  }
}
