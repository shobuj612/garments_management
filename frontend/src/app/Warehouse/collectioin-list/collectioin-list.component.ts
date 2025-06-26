import { Component, OnInit } from '@angular/core';
import { Warehouse } from '../../Model/warehouse.model';
import { Router } from '@angular/router';
import { WareService } from '../../Services/warehouseService/ware.service';

@Component({
  selector: 'app-collectioin-list',
  standalone:true,
  imports: [],
  templateUrl: './collectioin-list.component.html',
  styleUrl: './collectioin-list.component.css'
})
export class CollectioinListComponent implements OnInit {



 
  // this is object for this  class

  collect_order:Warehouse[]=[];

  constructor(private router:Router , private warService:WareService){


  }


  ngOnInit(): void {
     
    this.fetchAllWareHouse()

   // this.collect_order=JSON.parse(localStorage.getItem('b') || '[]');

  }


  // thi is the method to get all the data from the database

  fetchAllWareHouse(){


    this.warService.getAllWareHoueByService().subscribe((data)=>{

       this.collect_order=data;
    })
  }

  // thisi is the method to edit data in the database


  Edit(a:Warehouse){

    this.router.navigate(['/aw'],{state:{a}})
  }


  // this is the method to delete data from the database


  Delete(a:Warehouse) : void {

     if(a.warehouse_id !=null){

      
    if(confirm("are you want to delete?")){
      
      this.warService.deleteWareByService(a.warehouse_id).subscribe(()=>{

          this.fetchAllWareHouse()
      })

     // this.collect_order=this.collect_order.filter(f=>f!==a);

       //localStorage.setItem('b',JSON.stringify(this.collect_order))
    }

     }

     else{

       alert('Id is Invalid?')
     }
  }

  mydownload(){
      this.warService.downloadReport().subscribe((res:Blob)=>{
        const blob=new Blob([res],{type:'application/pdf'});
        const url=window.URL.createObjectURL(blob);
        const a=document.createElement('a');
        a.href=url;
        a.download='WareHouseReport.pdf';
        a.click();
        window.URL.revokeObjectURL(url);
      })
    }

}



