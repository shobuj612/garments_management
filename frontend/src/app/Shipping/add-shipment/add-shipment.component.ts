import { Component, OnInit } from '@angular/core';
import { Shipping } from '../../Model/shipping.model';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ShippingService } from '../../Services/shippingService/shipping.service';
import { NgFor } from '@angular/common';
import { Order } from '../../Model/order.model';
import { OrderService } from '../../Services/OrderService/order.service';

@Component({
  selector: 'app-add-shipment',
  standalone:true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-shipment.component.html',
  styleUrl: './add-shipment.component.css'
})
export class AddShipmentComponent implements OnInit {

  orders:Order[]=[];
  ship:Shipping =new Shipping()

  
  isUpdate=false;

  constructor(private router:Router , private shipService:ShippingService,private orderService:OrderService){
    
    const nav= this.router.getCurrentNavigation();

    if(nav?.extras.state&&nav.extras.state['a']){

      this.ship=nav.extras.state['a'];

      this.isUpdate=true;
    }

    }

    // this is the method to get all the data from  the order table]
    ngOnInit(): void {
        this.orderService.getAllOrderByService().subscribe((data)=>{
          this.orders=data;
        })
    }

    // this is the form Method

    submission(){
       
      /**
       * 
       * let  orders: Shipping[]=JSON.parse(localStorage.getItem('b') || '[]');

      if(this.isUpdate){

       for(let i=0; i<orders.length;i++){

        if(orders[i].shipped_qty==this.ship.shipped_qty){

          orders[i]=this.ship;

        }

       
       }
      }

      else{

        orders.push(this.ship)
      }

      localStorage.setItem('b',JSON.stringify(orders))

      this.ship=new Shipping();

      this.router.navigate(['/shiplist'])

       */


      if(this.isUpdate){

        this.shipService.updateShippingByService(this.ship.shipping_id!,this.ship).subscribe(()=>{

           this.router.navigate(['/shiplist'])
        })
      }

        else{

           this.shipService.postShippingByService(this.ship).subscribe(()=>{

             this.router.navigate(['/shiplist'])

             this.ship=new Shipping()

           })

        }
    }



  }


