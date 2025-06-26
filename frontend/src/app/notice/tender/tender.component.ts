import { Component, OnInit } from '@angular/core';
import { Tender } from '../../Model/tender';
import { NgFor, NgIf } from '@angular/common';
import { TenderserviceService } from '../../Services/tender/tenderservice.service';

@Component({
  selector: 'app-tender',
  imports: [NgIf,NgFor],
  templateUrl: './tender.component.html',
  styleUrl: './tender.component.css'
})
export class TenderComponent implements OnInit{
  showTable=true;
  tenderList:Tender[]=[];
  constructor(private tenderService:TenderserviceService){}
  closeTable():boolean{
    return this.showTable=false;
  }
  ngOnInit(): void {
      this.tenderService.getAllTender().subscribe(data=>{
        this.tenderList=data;
      })
  }
  
}
