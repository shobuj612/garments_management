import { Component, OnInit } from '@angular/core';
import { Cutting } from '../../Model/cutting.model';
import { Router } from '@angular/router';
import { CutService } from '../../Services/cutService/cut.service';

@Component({
  selector: 'app-cutting-list',
  standalone:true,
  imports: [],
  templateUrl: './cutting-list.component.html',
  styleUrl: './cutting-list.component.css'
})
export class CuttingListComponent implements OnInit{

  
  // this is object for this  class

  collect_order:Cutting[]=[];

  constructor(private router:Router , private cutService:CutService){


  }


  ngOnInit(): void {
      
   // this.collect_order=JSON.parse(localStorage.getItem('b') || '[]');

      this.fetchAllCut()
  }


  // this is the method to collect data from the database

  fetchAllCut(){

    this.cutService.getAllCut().subscribe((data)=>{

      this.collect_order=data;
    })
  }

  Edit(a:Cutting){

    this.router.navigate(['/ac'],{state:{a}})
  }

  Delete(a:Cutting):void {

    if(a.cutting_id !=null){

      if(confirm("are you want to delete?")){


        //this.collect_order=this.collect_order.filter(f=>f!==a);
  
      //  localStorage.setItem('b',JSON.stringify(this.collect_order))

      this.cutService.deleteDesignByService(a.cutting_id).subscribe(()=>{

               this.fetchAllCut()
      })
      }
    }

    else{

      alert('this is invalid id')
    }
    }

    // this is another method to print the report
    mydownload(){
      this.cutService.downloadReport().subscribe((res:Blob)=>{
        const blob=new Blob([res],{type:'application/pdf'});
        const url=window.URL.createObjectURL(blob);
        const a=document.createElement('a');
        a.href=url;
        a.download='CuttingReport.pdf';
        a.click();
        window.URL.revokeObjectURL(url);
      })
    }

}




