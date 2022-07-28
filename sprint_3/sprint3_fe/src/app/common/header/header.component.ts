import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    let searchForm = document.querySelector('.search-form');

    // @ts-ignore
    document.querySelector('#search-btn').onclick = () =>{
      searchForm.classList.toggle('active');
      shoppingCart.classList.remove('active');
      loginForm.classList.remove('active');
      navbar.classList.remove('active');
    }

    let shoppingCart = document.querySelector('.shopping-cart');

    // @ts-ignore
    document.querySelector('#cart-btn').onclick = () =>{
      shoppingCart.classList.toggle('active');
      searchForm.classList.remove('active');
      loginForm.classList.remove('active');
      navbar.classList.remove('active');
    }

    let loginForm = document.querySelector('.login-form');

// @ts-ignore
    document.querySelector('#login-btn').onclick = () =>{
      loginForm.classList.toggle('active');
      searchForm.classList.remove('active');
      shoppingCart.classList.remove('active');
      navbar.classList.remove('active');
    }


    let navbar = document.querySelector('.navbar');

    // @ts-ignore
    document.querySelector('#menu-btn').onclick = () =>{
      navbar.classList.toggle('active');
      searchForm.classList.remove('active');
      shoppingCart.classList.remove('active');
      loginForm.classList.remove('active');
    }

    window.onscroll = () =>{
      searchForm.classList.remove('active');
      shoppingCart.classList.remove('active');
      loginForm.classList.remove('active');
      navbar.classList.remove('active');
    }
  }

}


