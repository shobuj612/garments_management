import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Merchandising } from '../../Model/marchendising.model';

@Injectable({
  providedIn: 'root'
})
export class MarchService {

  // thi is the url to send the request to the backend

  private hiUrl='http://localhost:8080/march';

  constructor(private httpclient:HttpClient) { }

  // this is the method to get all the Marchendising

  getAllMarchendising():Observable<Merchandising[]>{

    
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.httpclient.get<Merchandising[]>(this.hiUrl,{headers});
  }

  // this is the update method in the database


  updateMarchByService(id:number,march:Merchandising):Observable<Merchandising>{

     if(id==null){

      throw new Error('invalid Id?');
     }

     
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.httpclient.put<Merchandising>(`${this.hiUrl}/${id}`,march,{headers});
  }

  // thi is the method for post in the database

  postMarchByService(march:Merchandising):Observable<Merchandising>{


    
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.httpclient.post<Merchandising>(this.hiUrl,march,{headers})
  }

  // thi is the delete method from something from the database

  deleteMarchByService(id:number):Observable<void>{

    if(id<=0){

      throw new Error('invalid id?')
    }
      
       
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.httpclient.delete<void>(this.hiUrl+'/'+id,{headers})
  }

  downloadReport():Observable<Blob>{
  const token=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${token}`
  });
  return this.httpclient.get('http://localhost:8080/api/report/march',{headers,responseType:'blob'})
}
// this is the method to get the last row from the database
getLastMarch():Observable<Merchandising>{
  const kiToken=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${kiToken}`
  });
  return this.httpclient.get<Merchandising>(this.hiUrl+'/last',{headers})
}
}