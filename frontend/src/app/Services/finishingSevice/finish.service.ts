import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Finishing } from '../../Model/fInishing.model';

@Injectable({
  providedIn: 'root'
})
export class FinishService {

  private baseUrl = 'http://localhost:8080/finis'

  constructor(private http: HttpClient) { }

  // this is the method to get data from the database

  getAllFinish(): Observable<Finishing[]> {


    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.get<Finishing[]>(this.baseUrl, { headers })
  }


  // this is the method to update data in the database

  updateFinisngByService(id: number, finis: Finishing): Observable<Finishing> {

    if (id == null) {

      throw new Error('Invalid Id?')

    }


    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.put<Finishing>(this.baseUrl + '/' + id, finis, { headers })
  }


  // thi is the method for post data in the database

  postFinishingByService(finis: Finishing): Observable<Finishing> {


    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.post<Finishing>(this.baseUrl, finis, { headers })
  }

  // this is the method for delete data from the database

  deleteFinishingByService(id: number): Observable<void> {

    if (id <= 0) {

      throw new Error('Invalid Id?')
    }



    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

    return this.http.delete<void>(this.baseUrl + '/' + id, { headers })

  }

  downloadReport():Observable<Blob>{
  const token=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${token}`
  });
  return this.http.get('http://localhost:8080/api/report/finish',{headers,responseType:'blob'})
}
  // this is a method to find the data last data from the database
  getLastFinisRow():Observable<Finishing>{
    const token=localStorage.getItem('token');
    const headers=new HttpHeaders({
      'Authorization':`Bearer ${token}`
    })
    return this.http.get<Finishing>(this.baseUrl+'/last',{headers})
  }
}
