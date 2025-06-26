import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Design } from '../../Model/design.model';

@Injectable({
  providedIn: 'root'
})
export class DesignService {
    
  private baseUrl='http://localhost:8080/design'

  constructor(private http:HttpClient) { }

  getAllDesign():Observable<Design[]>{
    const token =localStorage.getItem('token');
    const headers=new HttpHeaders({
      'Authorization':`Bearer ${token}`
    })
    return this.http.get<Design[]>(this.baseUrl,{headers})
  }
  getLastDesign():Observable<Design>{
    const token=localStorage.getItem('token');
    const headers=new HttpHeaders({
      'Authorization':`Bearer ${token}`
    });
    return this.http.get<Design>(`${this.baseUrl}/last`,{headers})
  }

  updateDesignByService(id:number,design:Design):Observable<Design>{

    if(id==null){
      throw new Error('Invalid Id?')

    }

    const token =localStorage.getItem('token');
    const headers=new HttpHeaders({

      'Authorization':`Bearer ${token}`
    })

    return this.http.put<Design>(this.baseUrl+'/'+id,design,{headers})
  }

    postDesingByService(design:Design):Observable<Design>{

    const token =localStorage.getItem('token');
    const headers=new HttpHeaders({

      'Authorization':`Bearer ${token}`
    })

      return this.http.post<Design>(this.baseUrl,design,{headers})
    }

    deleteDesignByService(id:number):Observable<void>{

      if(id<=0){

        throw new Error('Invalid Erorr')
      }

    const token =localStorage.getItem('token');
    const headers=new HttpHeaders({

      'Authorization':`Bearer ${token}`
    })

      return this.http.delete<void>(this.baseUrl+'/'+id,{headers})
    }

    // this is method for  downloading the report
    downloadReport():Observable<Blob>{
      const token=localStorage.getItem('token');
      const headers=new HttpHeaders({
        'Authorization':`Bearer ${token}`
      });
      return this.http.get('http://localhost:8080/api/report/design',{headers,responseType:'blob'})
    }

}
