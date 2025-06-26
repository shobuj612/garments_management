import { Component, OnInit } from '@angular/core';
import { Shipping } from '../../Model/shipping.model';
import { Router } from '@angular/router';
import { ShippingService } from '../../Services/shippingService/shipping.service';

@Component({
  selector: 'app-shipmentlist',
  standalone:true,
  imports: [],
  templateUrl: './shipmentlist.component.html',
  styleUrl: './shipmentlist.component.css'
})
export class ShipmentlistComponent implements OnInit {

  
  // this is object for this  class

  collect_order:Shipping[]=[];

  constructor(private router:Router  , private shipService:ShippingService){


  }


  ngOnInit(): void {

    this.fetchAllShip()


      
   // this.collect_order=JSON.parse(localStorage.getItem('b') || '[]');

  }


  // this is the method to get all the data from the database

   fetchAllShip(){

    this.shipService.getAllShippingByService().subscribe((data)=>{

        this.collect_order=data;
    })
   }


   // this is the method to edit somethin in the database


  Edit(a:Shipping){

    this.router.navigate(['/addship'],{state:{a}})
  }

  Delete(a:Shipping) :void {

    if(a.shipping_id !=null){

      if(confirm("are you want to delete?")){

         this.shipService.deleteShippingByService(a.shipping_id).subscribe(()=>{

               this.fetchAllShip()

         })   

       //this.collect_order=this.collect_order.filter(f=>f!==a);
  
        //localStorage.setItem('b',JSON.stringify(this.collect_order))
      }
    }

    else{

      alert('Invalid Id?')
    }
    }

    mydownload(){
      this.shipService.downloadReport().subscribe((res:Blob)=>{
        const blob=new Blob([res],{type:'application/pdf'});
        const url=window.URL.createObjectURL(blob);
        const a=document.createElement('a');
        a.href=url;
        a.download='ShippingReport.pdf';
        a.click();
        window.URL.revokeObjectURL(url);
      })
    }

}






