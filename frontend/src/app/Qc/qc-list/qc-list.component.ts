import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QualityControl } from '../../Model/qualitycontrol.model';
import { QcService } from '../../Services/qcService/qc.service';

@Component({
  selector: 'app-qc-list',
  standalone:true,
  imports: [],
  templateUrl: './qc-list.component.html',
  styleUrl: './qc-list.component.css'
})
export class QcListComponent implements OnInit {


  
  // this is object for this  class

  collect_order:QualityControl[]=[];

  constructor(private router:Router , private qcService:QcService){


  }


  ngOnInit(): void {
      
     this.fetchAllQc()

      
    //this.collect_order=JSON.parse(localStorage.getItem('b') || '[]');

  }


  // this is  the method to get all the data from the databse


  fetchAllQc(){

    this.qcService.getAllQcByService().subscribe((data)=>{

       this.collect_order=data;
    })
  }

   // this is the method to edit in the form

  Edit(a:QualityControl){

    this.router.navigate(['/aq'],{state:{a}})
  }


    // this is the method to delete data from the database


  Delete(a:QualityControl) : void {

      if(a.qc_id !=null){

        if(confirm("are you want to delete?")){

           this.qcService.deleteQcByService(a.qc_id).subscribe(()=>{

              this.fetchAllQc()

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
      this.qcService.downloadReport().subscribe((res:Blob)=>{
        const blob=new Blob([res],{type:'application/pdf'});
        const url=window.URL.createObjectURL(blob);
        const a=document.createElement('a');
        a.href=url;
        a.download='QcReport.pdf';
        a.click();
        window.URL.revokeObjectURL(url);
      })
    }

}



