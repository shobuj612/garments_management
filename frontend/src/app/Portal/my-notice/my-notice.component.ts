import { CommonModule, NgIf} from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NoticeService } from '../../Services/noticeServie/notice.service';

@Component({
  selector: 'app-my-notice',
  standalone: true,
  imports: [RouterModule, FormsModule, CommonModule,NgIf],
  templateUrl: './my-notice.component.html',
  styleUrl: './my-notice.component.css'
})
export class MyNoticeComponent {
  selectedFile!: File;
  showfrom:boolean=true;

  constructor(private fileService: NoticeService) {}

  closeTable():boolean{
    return this.showfrom=false;
  }

  onFileChange(event: any) {
    this.selectedFile = event.target.files[0];
  }

  upload() {
    if (this.selectedFile) {
      this.fileService.uploadFile(this.selectedFile).subscribe( {
        next:(resposnse)=>{console.log('file uploaded successfully'+resposnse)},
        error:(error)=>{
          console.error('upload fail'+error)
        }
        
      });
    }
  }
}
