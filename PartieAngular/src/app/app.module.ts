import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CodeforinterviewComponent } from './codeforinterview/codeforinterview.component';
import { AllUsersComponent } from './all-users/all-users.component';
import { SearchComponent } from './search/search.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { CommonModule } from '@angular/common';
import { LogoutGuard } from './login/logout.guard';
import { AuthGuard } from './login/auth.guard';
import { AuthentifictionService } from './authentifiction.service';
import { GestionUtilisateursComponent } from './gestion-utilisateurs/gestion-utilisateurs/gestion-utilisateurs.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ScrapingComponent } from './scraping/scraping.component';
import { DataComponent } from './data/data.component';
//import { HighchartsChartComponent } from 'highcharts-angular';

//import { HighchartsChartModule } from 'highcharts-angular';
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    CodeforinterviewComponent,
    AllUsersComponent,
    SearchComponent,
    FooterComponent,
    LoginComponent,
    GestionUtilisateursComponent,
    WelcomeComponent,
    ScrapingComponent,
    DataComponent,
   // HighchartsChartComponent 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule,
   // HighchartsChartModule
  ],
  providers: [AuthGuard,LogoutGuard,AuthentifictionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
