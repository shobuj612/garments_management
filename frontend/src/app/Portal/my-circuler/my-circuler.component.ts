import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CirculerserviceService } from '../../Services/circuler/circulerservice.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-my-circuler',
  imports: [RouterModule,NgIf,FormsModule],
  templateUrl: './my-circuler.component.html',
  styleUrl: './my-circuler.component.css'
})
export class MyCirculerComponent {
  show=true;
  selectedFile!:File;
  constructor(private circulerService:CirculerserviceService){}
  showForm():boolean{
    return this.show=false;
  }
  setFile(event:any){
    this.selectedFile=event.target.files[0];
  }

  uploadFile(){
   if(this.selectedFile){
     this.circulerService.postCirculer(this.selectedFile).subscribe({
      next:(response)=>{
        console.log('file uploaded successfully'+response)
      },
      error:(error)=>{
        console.error('upload failed'+error)
      }
    })
   }

  }

}
