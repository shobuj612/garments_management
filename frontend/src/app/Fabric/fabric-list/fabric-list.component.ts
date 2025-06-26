import { Component, OnInit } from '@angular/core';
import { FabricStore } from '../../Model/fabric.model';
import { Router } from '@angular/router';
import { FabricService } from '../../Services/fabricService/fabric.service';

@Component({
  selector: 'app-fabric-list',
  standalone:true,
  imports: [],
  templateUrl: './fabric-list.component.html',
  styleUrl: './fabric-list.component.css'
})
export class FabricListComponent  implements OnInit{

   
  // this is object for this  class

  collect_order:FabricStore[]=[];

  constructor(private router:Router , private fabricService:FabricService){


  }


  ngOnInit(): void {
      
   // this.collect_order=JSON.parse(localStorage.getItem('b') || '[]');
    
    this.fetchAllFabric()


  }

  // this is the method to get all the data from the database

  fetchAllFabric(){

    this.fabricService.getAllFabric().subscribe((data)=>{

      this.collect_order=data;
    })
  }


  // this is the method for edit


  Edit(a:FabricStore){

    this.router.navigate(['/af'],{state:{a}})
  }

  Delete(a:FabricStore):void {
   
    if(a.fabric_id !=null){
       
      
    if(confirm("are you want to delete?")){


       // this.collect_order=this.collect_order.filter(f=>f!==a);

         // localStorage.setItem('b',JSON.stringify(this.collect_order))

         this.fabricService.deleteFabricByService(a.fabric_id).subscribe(()=>{

           this.fetchAllFabric()
         })

         
    }
  }

   else{

     alert('Invalid Id?')
   }

    }

    // this is the method to get the report from the database
    mydownload(){
      this.fabricService.downloadReport().subscribe((res)=>{
        const blob=new Blob([res],{type:'application/pdf'});
        const url=window.URL.createObjectURL(blob);
        const a=document.createElement('a');
        a.href=url;
        a.download='FabricReport.pdf';
        a.click();
        window.URL.revokeObjectURL(url);
      })
    }

}





