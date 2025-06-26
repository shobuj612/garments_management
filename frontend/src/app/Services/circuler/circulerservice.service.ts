import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from '../../SecurityService/auth.service';
import { Observable } from 'rxjs';
import { Circuler } from '../../Model/circuler.model';

@Injectable({
  providedIn: 'root'
})
export class CirculerserviceService {
  private httUrl='http://localhost:8080/api/circuler';

  constructor(private http:HttpClient,private authService:AuthService) { }
  private getAuthHeader():HttpHeaders{
  const token=this.authService.getToken();
  return new HttpHeaders({
    Authorization:`Bearer ${token}`
  });
  }
  getAllCirculer():Observable<Circuler[]>{
    return this.http.get<Circuler[]>(this.httUrl,{headers:this.getAuthHeader()})
  }
  postCirculer(file:File):Observable<Circuler>{
    const formData=new FormData();
    formData.append('file',file);
    return this.http.post<Circuler>(`${this.httUrl}/upload`,formData,{headers:this.getAuthHeader()})
  }
}
