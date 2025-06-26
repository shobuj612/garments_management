import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from '../../SecurityService/auth.service';
import { Observable } from 'rxjs';
import { Tender } from '../../Model/tender';

@Injectable({
  providedIn: 'root'
})
export class TenderserviceService {
 private baseUrl='http://localhost:8080/api/tender';
  constructor(private http:HttpClient,private authService:AuthService) { }

  private getAuthHeader():HttpHeaders{
    const token=this.authService.getToken();
      return new HttpHeaders({
      Authorization:`Bearer ${token}`
      })
  }

  //get all the tender from the database
  getAllTender():Observable<Tender[]>{
    return this.http.get<Tender[]>(this.baseUrl,{headers:this.getAuthHeader()})
  }

  // this is post data in the database
postTender(file:File):Observable<Tender>{
   const formData=new FormData();
   formData.append('file',file)
   return this.http.post<Tender>(`${this.baseUrl}/upload`,formData,{headers:this.getAuthHeader()})
}
}
