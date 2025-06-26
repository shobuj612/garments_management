import { Component, OnInit } from '@angular/core';
import { Order } from '../../Model/order.model';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { OrderService } from '../../Services/OrderService/order.service';
import { BuyerServiceService } from '../../Services/buyer.service.service';
import { Buyer } from '../../Model/buyer.model';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-add-order',
  standalone:true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-order.component.html',
  styleUrl: './add-order.component.css'
})
export class AddOrderComponent implements OnInit{

 buyers:Buyer[]=[];

  order:Order=new Order()

  isUpdate=false;

  constructor(private router:Router,private orderService:OrderService,private buyerService:BuyerServiceService){
    
    const nav= this.router.getCurrentNavigation();

    if(nav?.extras.state&&nav.extras.state['a']){

      this.order=nav.extras.state['a'];

      this.isUpdate=true;
    }
     
    }


    // this the method to fetch all the buyer from the Buertable

    ngOnInit(): void {
        this.buyerService.getAllBuyerByService().subscribe((data)=>{
          this.buyers=data;
        })
    }


    // this is the form Method

    submission(){

       /**
        * 
        * 
      let  orders: Order[]=JSON.parse(localStorage.getItem('b') || '[]');

      if(this.isUpdate){

       for(let i=0; i<orders.length;i++){

        if(orders[i].order_id==this.order.order_id){

          orders[i]=this.order;

        }

       
       }
      }

      else{

        orders.push(this.order)
      }

      localStorage.setItem('b',JSON.stringify(orders))

      this.order=new Order();

      this.router.navigate(['/ol'])

        */

      if(this.isUpdate){

      this.orderService.updateOrderByService(this.order.order_id!,this.order).subscribe(()=>{


        this.router.navigate(['/ol'])
      })

      }


      else{

        this.orderService.createOrderByService(this.order).subscribe(()=>{


          this.order=new Order()

          this.router.navigate(['/ol'])
        })
      }

      
    }



  }
