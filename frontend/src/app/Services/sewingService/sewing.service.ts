import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Sewing } from '../../Model/sewing.model';

@Injectable({
  providedIn: 'root'
})
export class SewingService {

  private baseUrl='http://localhost:8080/sew'

  

  constructor(private http:HttpClient) { }

  // this is the method to get all data from the database
  
  getAllSewingByService():Observable<Sewing[]>{

    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.get<Sewing[]>(this.baseUrl,{headers})
  }

    // this is the method to update data in the database

    updateByService(id:number,sew:Sewing):Observable<Sewing>{

      if(id==null){

        throw new Error('Id is Invalid?')
      }

    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })  

       return this.http.put<Sewing>(this.baseUrl+'/'+id,sew,{headers})
    }

    // this is the method to post in the database

    postSewingByService(sew:Sewing):Observable<Sewing>{

      
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

      return this.http.post<Sewing>(this.baseUrl,sew ,{headers})
    }
   
    // this is the method to delete data from the database

    deleteSewingByService(id:number):Observable<void>{

      if(id <=0){

        throw new Error('Id is Invalid')
      }
       
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    }) 
      
      return this.http.delete<void>(`${this.baseUrl}/${id}`,{headers})
    }

    downloadReport():Observable<Blob>{
  const token=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${token}`
  });
  return this.http.get('http://localhost:8080/api/report/sew',{headers,responseType:'blob'})
}
// this is the method to get the last row from the database
getLastSewing():Observable<Sewing>{
  const token=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${token}`
  });
  return this.http.get<Sewing>(this.baseUrl+'/last',{headers})
}
}
