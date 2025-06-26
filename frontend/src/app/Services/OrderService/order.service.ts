import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../../Model/order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  // this is the url to the OrderController for request

  private postUrl='http://localhost:8080/orders';

  constructor(private ht:HttpClient) { }

     // this is the method to get the token from the localsotrage

     private getToken():{headers:HttpHeaders}{

         const token =localStorage.getItem('token');

         return {

            headers: new HttpHeaders({

              Authorization:`Bearer ${token}`
            })
         }

     }

// this is the method to get all the Order from the database
  getAllOrderByService():Observable<Order[]>{

    return this.ht.get<Order[]>(this.postUrl,this.getToken());
  }

  // this is the update method 


  updateOrderByService(id:number,order:Order):Observable<Order>{


      if(id==null){

        throw new Error('id will not be undefined')
      }

      return this.ht.put<Order>(`${this.postUrl}/${id}`,order ,this.getToken())
  }


  // thi is the method for the post to the database


  createOrderByService(order:Order):Observable<Order>{

    return this.ht.post<Order>(this.postUrl,order ,this.getToken())
  }

    // this is the method to delete data from the database


    deleteOrderByService(id:number):Observable<void>{

      if(id<=0){

        throw new Error('invalid id for deletion?')
      }

      return this.ht.delete<void>(`${this.postUrl}/${id}` ,this.getToken())
    }

    downloadReport():Observable<Blob>{
  const token=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${token}`
  });
  return this.ht.get('http://localhost:8080/api/report/order',{headers,responseType:'blob'})
}
// this is the method to get the last datafrom the databas
getLastOrder():Observable<Order>{
  const token=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${token}`
  });
  return this.ht.get<Order>(this.postUrl+'/last',{headers})
}
}
