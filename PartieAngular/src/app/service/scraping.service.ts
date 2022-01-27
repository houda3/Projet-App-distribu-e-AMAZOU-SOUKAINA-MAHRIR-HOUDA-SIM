import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ScrapingService {

  constructor( private http:HttpClient) { }

  UrlForScraping(url: string){
    return this.http.put(`http://localhost:8080/scrapedData`,url);
  }
  ParametreScraping(item: any){
    return this.http.put(`http://localhost:8080/parametre`,item);
  }
}
