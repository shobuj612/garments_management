import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Buyer } from '../../Model/buyer.model';
import { BuyerServiceService } from '../../Services/buyer.service.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-buyer-list',
  standalone:true,
  imports: [CommonModule],
  templateUrl: './buyer-list.component.html',
  styleUrl: './buyer-list.component.css'
})
export class BuyerListComponent  implements OnInit{

  
  // this is object for this  class

  collect_order:Buyer[]=[];

  constructor(private router:Router,private buyerService:BuyerServiceService){


  }

/*
  ngOnInit(): void {
      
    this.collect_order=JSON.parse(localStorage.getItem('b') || '[]');

  }

  Edit(a:Buyer){

    this.router.navigate(['/ab'],{state:{a}})
  }

  Delete(a:Buyer){

    if(confirm("are you want to delete?")){


      this.collect_order=this.collect_order.filter(f=>f!==a);

      localStorage.setItem('b',JSON.stringify(this.collect_order))
    }
  }

  * */



  


  ngOnInit(): void {

    this.getAllBuyer()
      
  }


  // now first get all the buyer from the database



  getAllBuyer(){

    this.buyerService.getAllBuyerByService().subscribe((data)=>{

      this.collect_order=data;
    })
  }


  // thi is the edit function

  Edit(a:Buyer){

    this.router.navigate(['/ab'],{state:{a}})

  }

  // this is the delete method to delete something from the database

  Delete(a: Buyer): void {
    if (a.buyerId != null) {  // Check if buyerId is not null or undefined
      if (confirm('Do you want to delete this buyer?')) {
        this.buyerService.deleteBuyerByService(a.buyerId).subscribe(() => {
          this.getAllBuyer();  // Refresh the list after deletion
        });
      }
    } else {
      alert('Invalid buyer ID');
    }
  }


  // this is to new add

  downloadReport() {
  this.buyerService.downloadBuyerReport().subscribe((res: Blob) => {
    const blob = new Blob([res], { type: 'application/pdf' });
    const url = window.URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = 'BuyerReport.pdf';
    a.click();
    window.URL.revokeObjectURL(url);
  });
}
  
}



