import { Component, OnInit } from '@angular/core';
import { AuthentifictionService } from '../authentifiction.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.scss']
})
export class WelcomeComponent implements OnInit {


  ngOnInit() {
  }
  utilisateurs:any[]=[];
  utilisateur= {
    id: null,
    nom: '',
    prenom:'',
  };
  constructor(
   
    public authentifictionService:AuthentifictionService
  ){}
  logout(){
    this.authentifictionService.logout();
  }
  islogged(){
    this.authentifictionService.isLogged();
  }


}
