import { Component, OnInit } from '@angular/core';
import { Shipping } from '../../Model/shipping.model';
import { ShippingService } from '../../Services/shippingService/shipping.service';

@Component({
  selector: 'app-shipping-table',
  imports: [],
  templateUrl: './shipping-table.component.html',
  styleUrl: './shipping-table.component.css'
})
export class ShippingTableComponent implements OnInit{
  item:Shipping={} as Shipping;
  constructor(private shippingService:ShippingService){}
  ngOnInit(): void {
      this.shippingService.getLastShipping().subscribe(data=>{
        this.item=data;
      })
  }

}
