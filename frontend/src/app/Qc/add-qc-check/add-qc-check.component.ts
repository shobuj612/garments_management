import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { QualityControl } from '../../Model/qualitycontrol.model';
import { Router } from '@angular/router';
import { QcService } from '../../Services/qcService/qc.service';
import { NgFor } from '@angular/common';
import { Order } from '../../Model/order.model';
import { OrderService } from '../../Services/OrderService/order.service';

@Component({
  selector: 'app-add-qc-check',
  standalone:true,
  imports: [FormsModule,NgFor],
  templateUrl: './add-qc-check.component.html',
  styleUrl: './add-qc-check.component.css'
})
export class AddQcCheckComponent implements OnInit {

  orders:Order[]=[];
  qc:QualityControl = new QualityControl()
  
  isUpdate=false;

  constructor(private router:Router , private qcService:QcService,private orderService:OrderService){
    
    const nav= this.router.getCurrentNavigation();

    if(nav?.extras.state&&nav.extras.state['a']){

      this.qc=nav.extras.state['a'];

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
      let  orders: QualityControl[]=JSON.parse(localStorage.getItem('b') || '[]');

      if(this.isUpdate){

       for(let i=0; i<orders.length;i++){

        if(orders[i].passed_qty==this.qc.passed_qty){

          orders[i]=this.qc;

        }

       
       }
      }

      else{

        orders.push(this.qc)
      }

      localStorage.setItem('b',JSON.stringify(orders))

      this.qc=new QualityControl();

      this.router.navigate(['/ql'])

      */


      if(this.isUpdate){

        this.qcService.updateQcByService(this.qc.qc_id!,this.qc).subscribe(()=>{

          this.router.navigate(['/ql'])

        })
      }

      else{

        this.qcService.postQcByService(this.qc).subscribe(()=>{

          this.router.navigate(['/ql'])

          this.qc= new QualityControl();

        })
      }

    }



  }



