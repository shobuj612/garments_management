import { Component, OnInit } from '@angular/core';
import { Buyer } from '../../Model/buyer.model';
import { BuyerServiceService } from '../../Services/buyer.service.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-buyer-table',
  standalone:true,
  imports: [],
  templateUrl: './buyer-table.component.html',
  styleUrl: './buyer-table.component.css'
})
export class BuyerTableComponent implements OnInit{
  //item:Buyer[]=[];
  item:Buyer={} as Buyer;
  constructor(private buyerService:BuyerServiceService){}
  ngOnInit(): void {
      this.buyerService.getLastBuyer().subscribe(data=>{
        //this.item=[data];
        this.item=data
      })
  }


}
