import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AttendenceService } from '../../Services/attendence.service';
import { CommonModule, NgFor } from '@angular/common';

@Component({
  selector: 'app-employee-attendence',
  standalone: true,
  imports: [FormsModule, NgFor, CommonModule],
  templateUrl: './employee-attendence.component.html',
  styleUrl: './employee-attendence.component.css'
})
export class EmployeeAttendenceComponent implements OnInit {
  employeeId: string = '';
  attendanceList: any[] = [];
  message: string = '';

  constructor(private attendanceService: AttendenceService) {}

  ngOnInit(): void {
    this.attendanceService.getAllAttendance().subscribe({
      next: (data) => {
        this.attendanceList = data;
      },
      error: (err) => {
        console.error(err);
        this.message = '❌ Failed to load attendance list.';
      }
    });
  }

  markAttendance(): void {
    if (!this.employeeId) {
      this.message = '❌ Please enter an Employee ID.';
      return;
    }

    this.attendanceService.markAttendance(this.employeeId).subscribe({
      next: (res: any) => {
        this.message = res.message;
        this.employeeId = '';
        this.ngOnInit(); // refresh the table
      },
      error: (err) => {
        console.error(err);
        this.message = err.error?.message || '❌ Failed to mark attendance.';
      }
    });
  }
}
