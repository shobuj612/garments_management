import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { QualityControl } from '../../Model/qualitycontrol.model';

@Injectable({
  providedIn: 'root'
})
export class QcService {

  private baseUrl='http://localhost:8080/qc'


   

  constructor( private http:HttpClient) { }


    // this is the method to get all the data fro the data base


     getAllQcByService():Observable<QualityControl[]>{


      
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })


      return this.http.get<QualityControl[]>(this.baseUrl,{headers})
     }

      
     // this is the method to update data in the database


     updateQcByService(id:number,qc:QualityControl):Observable<QualityControl>{


        if(id==null){


          throw new Error('Id is Invalid?')

        }

        
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

        return this.http.put<QualityControl>(this.baseUrl+'/'+id,qc,{headers})
     }


       // this is the method to post data in the database

       postQcByService(qc:QualityControl):Observable<QualityControl>{


        
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    })

        return this.http.post<QualityControl>(this.baseUrl,qc,{headers})
       }

         
       // this is the method to delete data from the database


       deleteQcByService(id:number):Observable<void>{

        if(id <=0){

          throw new Error('Id is Invalid?')
        }

           
    const token=localStorage.getItem('token');
    const headers= new HttpHeaders({

      'Authorization': `Bearer ${token}`
    }) 
           
          return this.http.delete<void>(this.baseUrl+'/'+id,{headers})
       }
       
       downloadReport():Observable<Blob>{
  const token=localStorage.getItem('token');
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${token}`
  });
  return this.http.get('http://localhost:8080/api/report/qc',{headers,responseType:'blob'})
}
// this is the method to get the last data from  the database
getLastQc():Observable<QualityControl>{
  const coken=localStorage.getItem('token')
  const headers=new HttpHeaders({
    'Authorization':`Bearer ${coken}`
  });
  return this.http.get<QualityControl>(this.baseUrl+'/last',{headers})
}

}
