import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AttendenceService {
  private baseUrl = 'http://localhost:8080/api/attendence';

  constructor(private http: HttpClient) {}

  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token') || '';
    return new HttpHeaders({ 'Authorization': `Bearer ${token}` });
  }

  markAttendance(employeeId: string) {
    const headers = this.getAuthHeaders();
    return this.http.post(`${this.baseUrl}/mark?employeeId=${employeeId}`, {}, { headers });
  }

  getAllAttendance():Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/all`, { headers: this.getAuthHeaders() });
  }
}
