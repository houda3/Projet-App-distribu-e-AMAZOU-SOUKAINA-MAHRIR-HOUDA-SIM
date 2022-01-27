import { Component, OnInit } from '@angular/core';
import { Data } from '../service/data';
import { DataService } from '../service/data.service';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.scss']
})
export class DataComponent implements OnInit {
 datas:any;
 irisData={
  id!:null,
  sepallength:null,

  sepalwidth:null,
   petallength:null,
    petalwidth:null,
    classification:''
 }


  constructor(private service :DataService) { }

  ngOnInit() {
   let re=this.service.getAll();
   re.subscribe(data=>this.datas=data);
  }
  getAll(){
    this.service.getAll().subscribe(data=>this.datas=data);
  }
  edit(u: any){
    this.irisData={
      ...u
    };
  }

  save(){
    if(this.irisData.id!){
      this.service.updateIris(this.irisData.id,this.irisData).subscribe(() =>this.getAll());
    }else{
      this.service.createIris(this.irisData).subscribe(() =>this.getAll());
    }
    this.irisData={
      id: null,
      sepallength: '',
      sepalwidth:'',
      petallength:'',
      petalwidth:'',
    classification: '',
    }
  }

}
