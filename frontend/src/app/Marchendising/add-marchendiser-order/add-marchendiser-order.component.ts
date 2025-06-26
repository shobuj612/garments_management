import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Merchandising } from '../../Model/marchendising.model';
import { Router } from '@angular/router';
import { MarchService } from '../../Services/marService/march.service';
import { Order } from '../../Model/order.model';
import { OrderService } from '../../Services/OrderService/order.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-add-marchendiser-order',
  standalone:true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-marchendiser-order.component.html',
  styleUrl: './add-marchendiser-order.component.css'
})
export class AddMarchendiserOrderComponent implements OnInit {

  orders:Order[]=[];

  marchendiser:Merchandising=new Merchandising();

   
  isUpdate=false;

  constructor(private router:Router,private marchService:MarchService,private orderService:OrderService){
    
    const nav= this.router.getCurrentNavigation();

    if(nav?.extras.state&&nav.extras.state['a']){

      this.marchendiser=nav.extras.state['a'];

      this.isUpdate=true;
    }
     
    }

    // this is the method to collect all the order from the order table
   ngOnInit(): void {
       this.orderService.getAllOrderByService().subscribe(data=>{
        this.orders=data;
       })
   }

    // this is the form Method

    submission(){
       /**
        * 
      let  orders: Merchandising[]=JSON.parse(localStorage.getItem('b') || '[]');

      if(this.isUpdate){

       for(let i=0; i<orders.length;i++){

        if(orders[i].merchandiser_name==this.marchendiser.merchandiser_name){

          orders[i]=this.marchendiser;

        }

       
       }
      }

      else{

        orders.push(this.marchendiser)
      }

      localStorage.setItem('b',JSON.stringify(orders))

      this.marchendiser=new Merchandising();

      this.router.navigate(['/ml'])


      
        */


      if(this.isUpdate){


        this.marchService.updateMarchByService(this.marchendiser.merch_id!,this.marchendiser).subscribe(()=>{

          this.router.navigate(['/ml'])
        })
      }

      else{

        this.marchService.postMarchByService(this.marchendiser).subscribe(()=>{

          this.marchendiser=new Merchandising();
          this.router.navigate(['/ml'])
        })
      }
    }

  }



