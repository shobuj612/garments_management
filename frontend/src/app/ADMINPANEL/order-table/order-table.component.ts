import { Component, OnInit } from '@angular/core';
import { Order } from '../../Model/order.model';
import { OrderService } from '../../Services/OrderService/order.service';
import { CommonModule, NgFor } from '@angular/common';

@Component({
  selector: 'app-order-table',
  standalone:true,
  imports: [CommonModule],
  templateUrl: './order-table.component.html',
  styleUrl: './order-table.component.css'
})
export class OrderTableComponent implements OnInit {
 items:Order={} as Order;

 constructor(private orderService:OrderService){}
 ngOnInit(): void {
     this.orderService.getLastOrder().subscribe(data=>{
      this.items=data;
     })
 }
}
