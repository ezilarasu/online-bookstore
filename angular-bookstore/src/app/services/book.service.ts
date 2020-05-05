import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Book } from '../common/book';
import { map } from 'rxjs/Operators';
import { BookCategory } from '../common/bookcategory';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = "http://localhost:8080/api/v1/books";

  private categoryUrl="http://localhost:8080/api/v1/book-category";

  constructor(private httpClient : HttpClient) { }

  getBooks(theCategoryId : number , currentPage : number , pageSize : number) : Observable<getResponseBooks>{
    const  searchUrl =`${this.baseUrl}/search/categoryid?id=${theCategoryId}&page=${currentPage}&size=${pageSize}`;
    return this.httpClient.get<getResponseBooks>(searchUrl);
 
  }

  private getBookList(searchUrl: string): Observable<Book[]> {
    return this.httpClient.get<getResponseBooks>(searchUrl).pipe(map(response => response._embedded.books));
  }

  getBookCategories() : Observable<BookCategory[]> {

    return this.httpClient.get<getResponseBookCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.bookCategory));
  }

  searchBooks(keyword : string) : Observable<Book[]>{
    const  searchUrl =`${this.baseUrl}/search/searchbykeyword?name=${keyword}`
    return this.getBookList(searchUrl);
  }

  get(bookId : number) : Observable<Book>{

    const bookDetailsUrl = `${this.baseUrl}/${bookId}`;
    return this.httpClient.get<Book>(bookDetailsUrl);

  }
}

interface getResponseBooks{

  _embedded:{
    books : Book[];
  },
    page : {
      //no of record in each page
      size : number,
      //total record in db
      totalElements : number,
      //total no of pages
      totalPages : number,
      //current page number
      number : number

    }
  }



interface getResponseBookCategory{

  _embedded : {
    bookCategory : BookCategory[];
  }
}
