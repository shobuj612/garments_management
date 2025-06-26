import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { TenderserviceService } from '../../Services/tender/tenderservice.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-my-tender',
  imports: [RouterModule,NgIf,FormsModule],
  templateUrl: './my-tender.component.html',
  styleUrl: './my-tender.component.css'
})
export class MyTenderComponent {
  selectedFile!:File;
  show=true;
  constructor(private tenderService:TenderserviceService){}
  showForm():boolean{
   return this.show=false;
  }

  sentFile(event:any){
    this.selectedFile=event.target.files[0];
  }
uploadsFile(){
 if(this.selectedFile){
   this.tenderService.postTender(this.selectedFile).subscribe({
    next: (res) => console.log('Upload success:', res),
    error: (err) => console.error('Upload failed:', err.status, err)
  });
 }
}


}
