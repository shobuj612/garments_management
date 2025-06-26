import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Finishing } from '../../Model/fInishing.model';
import { Router } from '@angular/router';
import { FinishService } from '../../Services/finishingSevice/finish.service';
import { NgFor } from '@angular/common';
import { Order } from '../../Model/order.model';
import { OrderService } from '../../Services/OrderService/order.service';

@Component({
  selector: 'app-add-finishing',
  standalone:true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-finishing.component.html',
  styleUrl: './add-finishing.component.css'
})
export class AddFinishingComponent implements OnInit {

  orders:Order[]=[];
  finish:Finishing = new Finishing()

  
   
  isUpdate=false;

  constructor(private router:Router , private finsisService:FinishService,private orderService:OrderService){
    
    const nav= this.router.getCurrentNavigation();

    if(nav?.extras.state&&nav.extras.state['a']){

      this.finish=nav.extras.state['a'];

      this.isUpdate=true;
    }

    }

    // this is the method to get all the data from  the database
    ngOnInit(): void {
        this.orderService.getAllOrderByService().subscribe(data=>{
          this.orders=data;
        })
    }

    // this is the form Method

    submission(){
      /**
       * 
       *  
      let  orders: Finishing[]=JSON.parse(localStorage.getItem('b') || '[]');

      if(this.isUpdate){

       for(let i=0; i<orders.length;i++){

        if(orders[i].finish_qty==this.finish.finish_qty){

          orders[i]=this.finish;

        }

       
       }
      }

      else{

        orders.push(this.finish)
      }

      localStorage.setItem('b',JSON.stringify(orders))

      this.finish=new Finishing();

      this.router.navigate(['/fli'])
    }


       */


     if(this.isUpdate){

      this.finsisService.updateFinisngByService(this.finish.finish_id!,this.finish).subscribe(()=>{


        this.router.navigate(['/fli'])
      })
     }
     

     else{

        this.finsisService.postFinishingByService(this.finish).subscribe(()=>{

          this.router.navigate(['/fli'])

          this.finish=new Finishing()
        })
     }
    }

  }





