import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Cutting } from '../../Model/cutting.model';
import { Router } from '@angular/router';
import { CutService } from '../../Services/cutService/cut.service';
import { NgFor } from '@angular/common';
import { Order } from '../../Model/order.model';
import { OrderService } from '../../Services/OrderService/order.service';

@Component({
  selector: 'app-add-cutting',
  standalone:true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-cutting.component.html',
  styleUrl: './add-cutting.component.css'
})
export class AddCuttingComponent  implements OnInit{
  orders:Order[]=[]

  cut:Cutting =new Cutting();

  
   
  isUpdate=false;

  constructor(private router:Router , private cutService:CutService,private orderService:OrderService){
    
    const nav= this.router.getCurrentNavigation();

    if(nav?.extras.state&&nav.extras.state['a']){

      this.cut=nav.extras.state['a'];

      this.isUpdate=true;
    }
     
    }

    // this is the method to get all the order from the order table

    ngOnInit(): void {
        this.orderService.getAllOrderByService().subscribe(data=>{
          this.orders=data;
        })
    }

    // this is the form Method

    submission(){
       
      /**
       * 
       * let  orders: Cutting[]=JSON.parse(localStorage.getItem('b') || '[]');

      if(this.isUpdate){

       for(let i=0; i<orders.length;i++){

        if(orders[i].cut_qty==this.cut.cut_qty){

          orders[i]=this.cut;

        }

       
       }
      }

      else{

        orders.push(this.cut)
      }

      localStorage.setItem('b',JSON.stringify(orders))

      this.cut=new Cutting();

      this.router.navigate(['/cl'])
    }



       */

    if(this.isUpdate){
     
      this.cutService.updateCuttingByServie(this.cut.cutting_id!,this.cut).subscribe(()=>{

        this.router.navigate(['/cl'])
      })

    }
  
     else{

      this.cutService.postDesignByService(this.cut).subscribe(()=>{

        this.cut= new Cutting()

        this.router.navigate(['/cl'])
      })
     }

}

}
