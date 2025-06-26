import { Component, OnInit } from '@angular/core';
import { Sewing } from '../../Model/sewing.model';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SewingService } from '../../Services/sewingService/sewing.service';
import { NgFor } from '@angular/common';
import { Order } from '../../Model/order.model';
import { OrderService } from '../../Services/OrderService/order.service';

@Component({
  selector: 'app-add-sewing',
  standalone:true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-sewing.component.html',
  styleUrl: './add-sewing.component.css'
})
export class AddSewingComponent implements OnInit {
 
  orders:Order[]=[];
  sew:Sewing=new Sewing();

   
  isUpdate=false;

  constructor(private router:Router,private sewService:SewingService,private orderService:OrderService){
    
    const nav= this.router.getCurrentNavigation();

    if(nav?.extras.state&&nav.extras.state['a']){

      this.sew=nav.extras.state['a'];

      this.isUpdate=true;
    }

    }
    // this is the method to get all the data from the order table
    ngOnInit(): void {
        this.orderService.getAllOrderByService().subscribe((data)=>{
          this.orders=data;
        })
    }

    // this is the form Method

    submission(){
       
     /**
      * 
      *  let  orders: Sewing[]=JSON.parse(localStorage.getItem('b') || '[]');

      if(this.isUpdate){

       for(let i=0; i<orders.length;i++){

        if(orders[i].sewing_qty==this.sew.sewing_qty){

          orders[i]=this.sew;

        }

       
       }
      }

      else{

        orders.push(this.sew)
      }

      localStorage.setItem('b',JSON.stringify(orders))

      this.sew=new Sewing();

      this.router.navigate(['/sl'])
      */
       

      if(this.isUpdate){


          this.sewService.updateByService(this.sew.sewing_id!,this.sew).subscribe(()=>{


             this.router.navigate(['/sl'])
          })
      }
       
      else{

         this.sewService.postSewingByService(this.sew).subscribe(()=>{

              this.router.navigate(['/sl'])

              this.sew= new Sewing()
         })
      }
    }



  }






