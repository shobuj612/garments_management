import { Component, OnInit } from '@angular/core';
import { Sewing } from '../../Model/sewing.model';
import { Router } from '@angular/router';
import { SewingService } from '../../Services/sewingService/sewing.service';

@Component({
  selector: 'app-sewing-list',
  standalone:true,
  imports: [],
  templateUrl: './sewing-list.component.html',
  styleUrl: './sewing-list.component.css'
})
export class SewingListComponent implements OnInit{

  
  // this is object for this  class

  collect_order:Sewing[]=[];

  constructor(private router:Router, private sewService:SewingService){


  }


  ngOnInit(): void {

    this.fetchAllSewing()
      
    //this.collect_order=JSON.parse(localStorage.getItem('b') || '[]');

  }

  // this is the method to get all the data from the databae

  fetchAllSewing(){

    this.sewService.getAllSewingByService().subscribe((data)=>{

       this.collect_order=data;
    })
  }

  // this is the method to edit data in the database


  Edit(a:Sewing){

    this.router.navigate(['/as'],{state:{a}})
  }


    // this is the method to deltete data from the database


  Delete(a:Sewing) :void {

     if(a.sewing_id !=null){

      if(confirm("are you want to delete?")){

         this.sewService.deleteSewingByService(a.sewing_id).subscribe(()=>{


              this.fetchAllSewing()
         })
       // this.collect_order=this.collect_order.filter(f=>f!==a);
  
        //localStorage.setItem('b',JSON.stringify(this.collect_order))
      }
     }

     else{

      alert('Invalid Id?')
     }
  }
   mydownload(){
      this.sewService.downloadReport().subscribe((res:Blob)=>{
        const blob=new Blob([res],{type:'application/pdf'});
        const url=window.URL.createObjectURL(blob);
        const a=document.createElement('a');
        a.href=url;
        a.download='SewingReport.pdf';
        a.click();
        window.URL.revokeObjectURL(url);
      })
    }
}






