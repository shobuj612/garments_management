import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FabricStore } from '../../Model/fabric.model';
import { Router } from '@angular/router';
import { FabricService } from '../../Services/fabricService/fabric.service';
import { NgFor } from '@angular/common';
import { Order } from '../../Model/order.model';
import { OrderService } from '../../Services/OrderService/order.service';

@Component({
  selector: 'app-add-fabric',
  standalone:true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-fabric.component.html',
  styleUrl: './add-fabric.component.css'
})
export class AddFabricComponent implements OnInit {
  
  orders:Order[]=[];
  farbric:FabricStore =new FabricStore();

    
  isUpdate=false;

  constructor(private router:Router , private fabricService:FabricService,private orderService:OrderService){
    
    const nav= this.router.getCurrentNavigation();

    if(nav?.extras.state&&nav.extras.state['a']){

      this.farbric=nav.extras.state['a'];

      this.isUpdate=true;
    }

    }

    // this is the method to collect all the order from the order table
    ngOnInit(): void {
        this.orderService.getAllOrderByService().subscribe((data)=>{
          this.orders=data;
        })
    }

    // this is the form Method

    submission(){
      
      /**
       *  
      let  orders: FabricStore[]=JSON.parse(localStorage.getItem('b') || '[]');

      if(this.isUpdate){

       for(let i=0; i<orders.length;i++){

        if(orders[i].fabric_type==this.farbric.fabric_type){

          orders[i]=this.farbric;

        }

       
       }
      }

      else{

        orders.push(this.farbric)
      }

      localStorage.setItem('b',JSON.stringify(orders))

      this.farbric=new FabricStore();

      this.router.navigate(['/fl'])
    }


       */
      
      if(this.isUpdate){

        this.fabricService.updateFabricByService(this.farbric.fabric_id!,this.farbric).subscribe(()=>{

          this.router.navigate(['/fl'])
        })
      }
  
      else{
        this.fabricService.postFabricByService(this.farbric).subscribe(()=>{

          this.router.navigate(['/fl'])

          this.farbric=new FabricStore()
        })
      }

}

}

