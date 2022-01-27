import { Injectable } from '@angular/core';
import { Utilisateur } from './utilisateur';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
@Injectable() 
@Injectable({
  providedIn: 'root'
})
export class AuthentifictionService {
  constructor(
    private http:HttpClient,
    private route:Router
  ) { }
  isLogged(){
    return !!localStorage.getItem('token');
  }
  
  login(utilisateur: Utilisateur):Observable<Object>{
    console.log(utilisateur);
    return this.http.post(`http://localhost:8080/login`,utilisateur);
  }
  logout(){
    localStorage.removeItem('token');
    this.route.navigate(['/login'])
  }
}
