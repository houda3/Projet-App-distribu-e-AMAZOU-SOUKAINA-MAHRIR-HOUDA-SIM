import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { CodeforinterviewComponent } from './codeforinterview/codeforinterview.component';
import { AllUsersComponent } from './all-users/all-users.component';
import { SearchComponent } from './search/search.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './login/auth.guard';
import { LogoutGuard } from './login/logout.guard';
import { GestionUtilisateursComponent } from './gestion-utilisateurs/gestion-utilisateurs/gestion-utilisateurs.component';
import { WelcomeComponent } from './welcome/welcome.component';
import{ScrapingComponent} from './scraping/scraping.component';
import { DataComponent } from './data/data.component';
const routes: Routes = [
  {
    path : "", redirectTo: "login" , pathMatch : "full"
  },
  {
    path : "Home", component : CodeforinterviewComponent
  },
  {
    path : "register" , component : RegisterComponent
  },
  {
    path : "search" , component : SearchComponent
  },
  {
    path : "all-users", component : AllUsersComponent
  },
  {
    path:"login",component :LoginComponent,canActivate:[LogoutGuard]
  },
  {path:"Gestion Users",component:GestionUtilisateursComponent},
  {path:"welcome",component:WelcomeComponent},
  {path:"scraping",component:ScrapingComponent},
  {path:"ScrapedData",component:DataComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
