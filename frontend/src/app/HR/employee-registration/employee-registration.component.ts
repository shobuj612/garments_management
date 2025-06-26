import { Component } from '@angular/core';
import { EmployeeService } from '../../Services/employee.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee-registration',
  standalone:true,
  imports: [FormsModule],
  templateUrl: './employee-registration.component.html',
  styleUrl: './employee-registration.component.css'
})
export class EmployeeRegistrationComponent {
employeeId: string = '';
  employeeName: string = '';
  department: string = '';
  message: string = '';

  constructor(private employeeService: EmployeeService) {}

  EmployeeSubmit() {
    const employee = {
      employeeId: this.employeeId,
      employeeName: this.employeeName,
      department: this.department
    };

    this.employeeService.saveEmployee(employee).subscribe({
      next: () => {
        this.message = '✅ Employee registered successfully!';
        this.employeeId = '';
        this.employeeName = '';
        this.department = '';
      },
      error: () => {
        this.message = '❌ Error registering employee.';
      }
    });
  }
}
