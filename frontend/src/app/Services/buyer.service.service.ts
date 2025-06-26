import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Buyer } from '../Model/buyer.model';

@Injectable({
  providedIn: 'root'
})
export class BuyerServiceService {

  private baseUrl = 'http://localhost:8080/buyer'

  constructor(private http: HttpClient) { }

  // this is the method to get the token from the localstorage

 // private getToken() {

    // const token=localStorage.getItem('token') ;

    // return {

      // headers: new HttpHeaders({
      
         //   Authorization : `Bearer ${token}`  
      // })

    // };

 // }

  // Method to get all the data from the database
  getAllBuyerByService(): Observable<Buyer[]> {
    const token =localStorage.getItem('token');
    const headers =new HttpHeaders({

      'Authorization' : `Bearer ${token}`
    })

    return this.http.get<Buyer[]>(this.baseUrl,{headers});
  }

  // Method to update a buyer in the database
  updateBuyerByService(id: number, buyer: Buyer): Observable<Buyer> {
    if (id == null) {
      throw new Error('Buyer ID cannot be null or undefined');
    }

    const token =localStorage.getItem('token');
    const headers =new HttpHeaders({

      'Authorization' : `Bearer ${token}`
    })
    return this.http.put<Buyer>(`${this.baseUrl}/${id}`, buyer ,{headers});
  }

  // Method to create a new buyer in the database
  createBuyerByService(buyer: Buyer): Observable<Buyer> {

    const token =localStorage.getItem('token');
    const headers =new HttpHeaders({

      'Authorization' : `Bearer ${token}`
    })

    return this.http.post<Buyer>(this.baseUrl, buyer ,{headers});
  }

  // Method to delete a buyer from the database
  deleteBuyerByService(id: number): Observable<void> {
    if (id <= 0) {
      throw new Error('Invalid ID for deletion');
    }

    const token =localStorage.getItem('token');
    const headers =new HttpHeaders({

      'Authorization' : `Bearer ${token}`
    })

    return this.http.delete<void>(`${this.baseUrl}/${id}` ,{headers});
  }
     
  // this is new to add
downloadBuyerReport(): Observable<Blob> {
  const token = localStorage.getItem('token');
  const headers = new HttpHeaders({
    'Authorization': `Bearer ${token}` // ✅ No space before Bearer
  });

  return this.http.get('http://localhost:8080/api/report/buyer', {
    headers,
    responseType: 'blob'
  });
}
//this is the method from the buyer table
getLastBuyer():Observable<Buyer>{
  const token=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${token}`
  });
  return this.http.get<Buyer>(this.baseUrl+'/last',{headers})
}
}
