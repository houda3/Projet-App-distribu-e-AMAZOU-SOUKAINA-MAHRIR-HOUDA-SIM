import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class GestionUsersService {

  
  constructor(
    private http:HttpClient,
  ) { }
  getAll(){
    return this.http.get(`http://localhost:8080/findAllUtilisateurs`);
  }
  update(id: string,utilisateur: any){
    return this.http.put(`http://localhost:8080/updateUtilisateur/${id}`,utilisateur);
  }
  create(Utilisateur: any){
    return this.http.post(`http://localhost:8080/addUtilisateur`,Utilisateur);
  }
  delete(id: string){
    return this.http.delete(`http://localhost:8080/deleteUtilisateur/${id}`);
  }
  DataHtml(url: string){
    return this.http.put(`http://localhost:8080/datahtml`,url);
  }
  Donnee(item: any){
    return this.http.put(`http://localhost:8080/donne`,item);
  }
}
