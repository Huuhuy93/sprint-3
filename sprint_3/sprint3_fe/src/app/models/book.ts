import {Category} from "./category";

export interface Book {
  id?: number,
  bookName?: string,
  author?: string,
  quantity?: string,
  image?: string,
  discount?: number,
  price?: number,
  description?: string,
  deleteFlag?: boolean,
  category?: Category
}
