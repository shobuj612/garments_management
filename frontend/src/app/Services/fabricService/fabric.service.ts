import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FabricStore } from '../../Model/fabric.model';

@Injectable({
  providedIn: 'root'
})
export class FabricService {

  private baseUrl = 'http://localhost:8080/fabric'

  constructor(private http: HttpClient) { }

  // this is the method to get all the data from the database

  getAllFabric(): Observable<FabricStore[]> {

    // this is the method to get the token from the localstorage

    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.get<FabricStore[]>(this.baseUrl, { headers })
  }

  // this is the method to update fabric in the database

  updateFabricByService(id: number, fabric: FabricStore): Observable<FabricStore> {

    if (id == null) {

      throw new Error('Invalid ID?')
    }

    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.put<FabricStore>(this.baseUrl + '/' + id, fabric, { headers })
  }

  // this is the method to post data in the database

  postFabricByService(fabric: FabricStore): Observable<FabricStore> {

    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.post<FabricStore>(this.baseUrl, fabric, { headers })
  }

  // this is method to delete data from the database

  deleteFabricByService(id: number): Observable<void> {

    if (id <= 0) {

      throw new Error('Invalid Id?')
    }

    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({

      'Authorization':`Bearer ${token}`
    })

    return this.http.delete<void>(this.baseUrl + '/' + id, { headers })
  }

  // this is the method to get the report from the database

  downloadReport():Observable<Blob>{
    const token=localStorage.getItem('token');
    const headers=new HttpHeaders({
      'Authorization':`Bearer ${token}`
    });
    return this.http.get('http://localhost:8080/api/report/fabric',{headers,responseType:'blob'})
  }
  // this is the method to get the last row of the table
  getLastFabric():Observable<FabricStore>{
    const hiToken=localStorage.getItem('token');
    const headers=new HttpHeaders({
      'Authorization':`Bearer ${hiToken}`
    });
    return this.http.get<FabricStore>(this.baseUrl+'/last',{headers})
  }
}
