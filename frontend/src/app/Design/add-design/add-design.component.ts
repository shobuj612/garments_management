import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Design } from '../../Model/design.model';
import { Router } from '@angular/router';
import { DesignService } from '../../Services/DesignSerivce/design.service';
import { NgFor } from '@angular/common';
import { Order } from '../../Model/order.model';
import { OrderService } from '../../Services/OrderService/order.service';

@Component({
  selector: 'app-add-design',
  standalone:true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-design.component.html',
  styleUrl: './add-design.component.css'
})
export class AddDesignComponent implements OnInit {

  orders:Order[]=[];

  desingn : Design = new Design();

  
   
  isUpdate=false;

  constructor(private router:Router , private designService:DesignService,private orderService:OrderService){
    
    const nav= this.router.getCurrentNavigation();

    if(nav?.extras.state&&nav.extras.state['a']){

      this.desingn=nav.extras.state['a'];

      this.isUpdate=true;
    }

    }

    // this is the method to get all the order from the order table
    ngOnInit(): void {
        this.orderService.getAllOrderByService().subscribe((data)=>{
          this.orders=data;
        })
    }

    // this is the form Method

    submission(){
     /**
      * 
      *   
      let  orders: Design[]=JSON.parse(localStorage.getItem('b') || '[]');

      if(this.isUpdate){

       for(let i=0; i<orders.length;i++){

        if(orders[i].design_name==this.desingn.design_name){

          orders[i]=this.desingn;

        }

       
       }
      }

      else{

        orders.push(this.desingn)
      }

      localStorage.setItem('b',JSON.stringify(orders))

      this.desingn=new Design();

      this.router.navigate(['/dl'])
    }


      */

     if(this.isUpdate){

      this.designService.updateDesignByService(this.desingn.design_id!,this.desingn).subscribe(()=>{

        this.router.navigate(['/dl'])
      })
     }
        
     else{

      this.designService.postDesingByService(this.desingn).subscribe(()=>{

        this.desingn= new Design()

        this.router.navigate(['/dl'])
      })
     }
    }
}
