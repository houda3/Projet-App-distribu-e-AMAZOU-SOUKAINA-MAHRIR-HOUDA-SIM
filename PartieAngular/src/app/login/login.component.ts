import { Component, OnInit } from '@angular/core';
import  {Utilisateur}from'../utilisateur';
import { AuthentifictionService } from '../authentifiction.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  utilisateur:Utilisateur=new Utilisateur();
  
    constructor(
      private Service:AuthentifictionService,
      private route: Router
    ){}
  
    ngOnInit(): void {
    }
    login(){
      this.Service.login(this.utilisateur).subscribe(
        (data:any)=>{
          console.log(data);
          if(data.id!=null){
          const token=data.id;
          localStorage.setItem('token',token);
          alert("connection avec succès !");
          this.route.navigate(['/Home'])
          }else{
          alert("Désolé Veuillez entrer des informations correctes");
          }

      },
      );
    }
  
  }