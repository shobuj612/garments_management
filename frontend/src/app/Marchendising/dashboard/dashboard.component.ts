import { Component, OnInit } from '@angular/core';
import { Design } from '../../Model/design.model';
import { DesignService } from '../../Services/DesignSerivce/design.service';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  imports: [NgIf],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit{
     show =true;
     design:Design={} as Design;
      //design:Design[]=[];
     constructor(private desingService:DesignService){}
     closeTable():boolean{
      return this.show=false;
     }
     ngOnInit(): void {
         this.desingService.getLastDesign().subscribe(data=>{
          this.design=data;
          // this.design=[data]
         })
     }
}
