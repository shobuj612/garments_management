import { Component, OnInit } from '@angular/core';
import { AttendenceService } from '../../Services/attendence.service';
import { CommonModule, NgFor } from '@angular/common';

@Component({
  selector: 'app-attendence-list',
  standalone:true,
  imports: [NgFor,CommonModule],
  templateUrl: './attendence-list.component.html',
  styleUrl: './attendence-list.component.css'
})
export class AttendenceListComponent implements OnInit {
  list:any[]=[];
  constructor(private attendenceService:AttendenceService){}
  ngOnInit(): void {
      this.attendenceService.getAllAttendance().subscribe(data=>{
        this.list=data;
      })
  }

}
