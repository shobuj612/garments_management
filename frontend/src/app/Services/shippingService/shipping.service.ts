import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Shipping } from '../../Model/shipping.model';

@Injectable({
  providedIn: 'root'
})
export class ShippingService {

  private baseUrl='http://localhost:8080/ship'



  constructor(private http:HttpClient) { }

   
  // this is the method to get all the data from the database


  getAllShippingByService():Observable<Shipping[]>{

    
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })


    return this.http.get<Shipping[]>(this.baseUrl,{headers})
  }
  
  // this is the method to update data in the database


  updateShippingByService(id:number,ship:Shipping):Observable<Shipping>{

   if(id==null){

    throw new Error('INVALID ID?')
   }

   
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.put<Shipping>(`${this.baseUrl}/${id}`,ship,{headers})

  }


  // thisi is the method to post data in the database


  postShippingByService(ship:Shipping):Observable<Shipping>{

    
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.post<Shipping>(this.baseUrl,ship,{headers})
  }

    // this is the method to delete data from the database

    deleteShippingByService(id:number):Observable<void>{

      if(id <=0){

        throw new Error('Invalid id?')
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
  return this.http.get('http://localhost:8080/api/report/ship',{headers,responseType:'blob'})
}
// this is the method to get the data from the database
getLastShipping():Observable<Shipping>{
  const token=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${token}`
  });
  return this.http.get<Shipping>(this.baseUrl+'/last',{headers})
}

}
