import { Component, OnInit } from '@angular/core';
import { UserRegisterService } from '../user-register.service';
import { TestObject } from 'protractor/built/driverProviders';
import{GestionUsersService} from'../gestion-users.service';
@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.scss']
})
export class AllUsersComponent implements OnInit {

 
  utilisateurs:any[]=[];
  utilisateur= {
    id: null,
    nom: '',
    username:'',
    email:'',
    pass:'',
    admin: false, 
  }

  constructor(private service : GestionUsersService) { }

  ngOnInit() {
    
    this.getAll();
    
  }

 
  getAll(){
    this.service.getAll().subscribe((data: any) => this.utilisateurs = data);
  }
  removeUser(utilisateur: any){
    this.service.delete(utilisateur.id).subscribe(()=> this.getAll());
  }
}
