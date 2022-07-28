import { Component, OnInit } from '@angular/core';
import {BookDto} from "../../dtos/book-dto";
import {Book} from "../../models/book";
import {BookService} from "../../services/book.service";
import {HomepageService} from "../../services/homepage.service";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private homepageService: HomepageService) { }

  ngOnInit(): void {
    // @ts-ignore
    var swiper = new Swiper(".product-slider", {
      loop:true,
      spaceBetween: 20,
      autoplay: {
        delay: 7500,
        disableOnInteraction: false,
      },
      centeredSlides: true,
      breakpoints: {
        0: {
          slidesPerView: 1,
        },
        768: {
          slidesPerView: 2,
        },
        1020: {
          slidesPerView: 3,
        },
      },
    });

    // @ts-ignore
    var swiper = new Swiper(".review-slider", {
      loop:true,
      spaceBetween: 20,
      autoplay: {
        delay: 7500,
        disableOnInteraction: false,
      },
      centeredSlides: true,
      breakpoints: {
        0: {
          slidesPerView: 1,
        },
        768: {
          slidesPerView: 2,
        },
        1020: {
          slidesPerView: 3,
        },
      },
    });
  }
}
