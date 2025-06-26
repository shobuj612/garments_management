import { Component, OnInit } from '@angular/core';
import { Order } from '../../Model/order.model';
import { Router } from '@angular/router';
import { OrderService } from '../../Services/OrderService/order.service';

@Component({
  selector: 'app-orderlist',
  standalone:true,
  imports: [],
  templateUrl: './orderlist.component.html',
  styleUrl: './orderlist.component.css'
})
export class OrderlistComponent  implements OnInit{


  // this is object for this  class

  collect_order:Order[]=[];

  constructor(private router:Router, private orderServic:OrderService){}


  ngOnInit(): void {
      
    //this.collect_order=JSON.parse(localStorage.getItem('b') || '[]');

    this.fetchAllOrders()

  }

   fetchAllOrders(){


     this.orderServic.getAllOrderByService().subscribe((mydata)=>{

      this.collect_order=mydata;

     })

   }

     // this is the edit method

  Edit(a:Order){

    this.router.navigate(['/ao'],{state:{a}})
  }

  Delete(a:Order) :void {

    if(a.order_id !=null){

      if(confirm("are you want to delete?")){


        //this.collect_order=this.collect_order.filter(f=>f!==a);
  
        //localStorage.setItem('b',JSON.stringify(this.collect_order))

        this.orderServic.deleteOrderByService(a.order_id).subscribe(()=>{

          this.fetchAllOrders();

          
        })
      }
    }

    else{

      alert('Invalid id?')
    }
  }

  mydownload(){
      this.orderServic.downloadReport().subscribe((res:Blob)=>{
        const blob=new Blob([res],{type:'application/pdf'});
        const url=window.URL.createObjectURL(blob);
        const a=document.createElement('a');
        a.href=url;
        a.download='OrderReport.pdf';
        a.click();
        window.URL.revokeObjectURL(url);
      })
    }

}




