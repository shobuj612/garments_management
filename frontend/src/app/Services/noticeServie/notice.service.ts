import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FileModel } from '../../Model/file.model';
import { AuthService } from '../../SecurityService/auth.service';

@Injectable({
  providedIn: 'root'
})
export class NoticeService {
   private baseUrl = 'http://localhost:8080/api/notices';

  constructor(private http: HttpClient, private authService: AuthService) {}

  private getAuthHeaders(): HttpHeaders {
    const token = this.authService.getToken();
    return new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
  }

  uploadFile(file: File): Observable<FileModel> {
    const formData = new FormData();
    formData.append('file', file);

    return this.http.post<FileModel>(
      `${this.baseUrl}/upload`,
      formData,
      { headers: this.getAuthHeaders() }
    );
  }

  getFiles(): Observable<FileModel[]> {
    return this.http.get<FileModel[]>(
      this.baseUrl,
      { headers: this.getAuthHeaders() }
    );
  }
}
