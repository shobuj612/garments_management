
// src/app/services/auth.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/login'; // Adjust with your backend API URL

  constructor(private http: HttpClient) { }



  login(email: string, password: string): Observable<any> {
    const loginPayload = { email, password };
    return this.http.post<any>(this.apiUrl, loginPayload);
  }



  saveToken(token: string): void {
    if (token) {
      localStorage.setItem('token', token);
    } else {
      console.error('Error: No token received.');
    }
  }



  getToken(): string | null {
    return localStorage.getItem('token');
  }

  

  getUserRoles(): string[] {
    const token = this.getToken();
    if (!token) return [];
    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return payload.roles || [];
    } catch (error) {
      console.error('Invalid token:', error);
      return [];
    }
  }
  


  isLoggedIn(): boolean {
    return !!this.getToken();  // ✅ Return true if token exists
  }
  



  isAuthenticated(): boolean {
    return this.getToken() !== null;
  }


  // this is for logout option 
  logout(): void {
    localStorage.removeItem('token');
  }


  
}





/*

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080'; // আপনার Spring Boot সার্ভারের URL

  constructor(private http: HttpClient, private router: Router) {}

  // 🔐 Login method: ইউজার লগইন করার জন্য
  login(credentials: any) {
    return this.http.post<any>(`${this.baseUrl}/api/auth/login`, credentials);
  }

  // 🔐 Token সেভ করার জন্য
  setToken(token: string) {
    localStorage.setItem('token', token);
  }

  // 🔐 LocalStorage থেকে টোকেন নেওয়ার জন্য
  getToken() {
    return localStorage.getItem('token');
  }

  // 🔓 লগআউট করার জন্য
  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

  // 🧾 JWT Token থেকে Role গুলো বের করার জন্য
  getUserRoles(): string[] {
    const token = this.getToken();
    if (!token) return [];
    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return payload.roles || [];
    } catch (error) {
      console.error('Invalid token:', error);
      return [];
    }
  }

  // 🔍 ইউজার লগইন আছে কিনা চেক করার জন্য
  isLoggedIn(): boolean {
    return !!this.getToken();
  }
}
*/