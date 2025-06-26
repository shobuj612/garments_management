import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Warehouse } from '../../Model/warehouse.model';

@Injectable({
  providedIn: 'root'
})
export class WareService {

  private baseUrl='http://localhost:8080/war'



  constructor( private http:HttpClient) { }

  // thisi is the method to get data from the database

  getAllWareHoueByService():Observable<Warehouse[]>{

    
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.get<Warehouse[]>(this.baseUrl,{headers})
  }

  // this is the method to update data in the database

  updateWareByService(id:number,war:Warehouse):Observable<Warehouse>{

    if(id==null){

      throw new Error('INvalid Id?')
    }
       
    
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.put<Warehouse>(this.baseUrl+'/'+id,war,{headers})
  }


  // this is the method to post in the database

  createWareByService(war:Warehouse):Observable<Warehouse>{


    
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })


    return this.http.post<Warehouse>(this.baseUrl,war,{headers})
  }


  // this is the method to delete data from the database


  deleteWareByService(id:number):Observable<void>{

    if(id <=0){

      throw new Error('Invalid id?')
    }

    
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.delete<void>(`${this.baseUrl}/${id}`,{headers})
  }
// this is the method to download the file from the database
downloadReport():Observable<Blob>{
  const token=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${token}`
  });
  return this.http.get('http://localhost:8080/api/report/ware',{headers,responseType:'blob'})
}
// this is the method to get the last data from the dataabse
getLastWare():Observable<Warehouse>{
  const token=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${token}`
  });
  return this.http.get<Warehouse>(this.baseUrl+'/last',{headers})
}
}
