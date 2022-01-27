import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

   
  constructor(
    private http:HttpClient,
  ) { }
  getAll(){
    return this.http.get("http://localhost:8080/irisdata");
  }
  updateIris(id: string,IrisData: any){
    return this.http.put(`http://localhost:8080/addIrisData/${id}`,IrisData);
  }
  
  createIris(iris: any){
    return this.http.post(`http://localhost:8080/addIrisData`,iris);
  }/*
  delete(id: string){
    return this.http.delete(`http://localhost:8080/deleteUtilisateur/${id}`);
  }
  DataHtml(url: string){
    return this.http.put(`http://localhost:8080/datahtml`,url);
  }
  Donnee(item: any){
    return this.http.put(`http://localhost:8080/donne`,item);
  }*/
}
