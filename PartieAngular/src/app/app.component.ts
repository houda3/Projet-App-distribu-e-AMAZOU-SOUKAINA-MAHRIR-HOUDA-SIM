import { Component } from '@angular/core';
import { AuthentifictionService } from './authentifiction.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'project';
  logo = "/assets/images/logo.png";
  
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
