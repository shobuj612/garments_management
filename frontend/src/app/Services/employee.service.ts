import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
 private baseUrl = 'http://localhost:8080/api/employee';

  constructor(private http: HttpClient) {}

  saveEmployee(employee: any) {
    const token=localStorage.getItem('token');
    const headers=new HttpHeaders({
      'Authorization':`Bearer ${token}`
    })
    return this.http.post(this.baseUrl+'/post', employee,{headers});
  }

  getAllEmployees() {
    const token=localStorage.getItem('token');
    const headers=new HttpHeaders({
      'Authorization':`Bearer ${token}`
    })
    return this.http.get<any[]>(this.baseUrl,{headers});
  }
}
