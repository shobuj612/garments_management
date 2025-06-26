import { Component, OnInit } from '@angular/core';
import { Finishing } from '../../Model/fInishing.model';
import { Router } from '@angular/router';
import { FinishService } from '../../Services/finishingSevice/finish.service';

@Component({
  selector: 'app-finishing-list',
  standalone:true,
  imports: [],
  templateUrl: './finishing-list.component.html',
  styleUrl: './finishing-list.component.css'
})
export class FinishingListComponent implements OnInit {


  
  collect_order:Finishing[]=[];

  constructor(private router:Router , private finisService:FinishService){


  }


  ngOnInit(): void {
      
    this.fetchAllFinsihing()
    //this.collect_order=JSON.parse(localStorage.getItem('b') || '[]');

  }

  // this is the method to get all the  data from the database


  fetchAllFinsihing(){

    this.finisService.getAllFinish().subscribe((data)=>{


      this.collect_order=data;
    })
  }


   // this is the edit method for the form

  Edit(a:Finishing){

    this.router.navigate(['/afi'],{state:{a}})
  }


  // this is the method for deleting data from the databse


  Delete(a:Finishing) :void {

    if(a.finish_id !=null){

      if(confirm("are you want to delete?")){

       
        this.finisService.deleteFinishingByService(a.finish_id).subscribe(()=>{

          this.fetchAllFinsihing()
        })
       // this.collect_order=this.collect_order.filter(f=>f!==a);
  
       // localStorage.setItem('b',JSON.stringify(this.collect_order))
      }
    }

    else{
      alert('Invalid Id?')
    }
    }

    mydownload(){
      this.finisService.downloadReport().subscribe((res:Blob)=>{
        const blob=new Blob([res],{type:'application/pdf'});
        const url=window.URL.createObjectURL(blob);
        const a=document.createElement('a');
        a.href=url;
        a.download='FinishingReport.pdf';
        a.click();
        window.URL.revokeObjectURL(url);
      })
    }

}



