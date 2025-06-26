
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../SecurityService/auth.service';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone:true,
  imports:[FormsModule,NgIf],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) { }

  // Login form submission handler
  onSubmit(): void {
    // Check if email or password is empty
    if (!this.email || !this.password) {
      this.errorMessage = 'Please enter both email and password';
      return; // Do not proceed with the form submission
    }

    // Call AuthService to authenticate the user
    this.authService.login(this.email, this.password).subscribe({
      next: (response) => {
        if (response && response.token) {
          this.authService.saveToken(response.token);
          setTimeout(()=>{
              this.router.navigate(['/']);
          },100);                              // Save token only if received
           // Redirect after successful login
        }
        
        else {
          this.errorMessage = 'Login failed: No token received';
        }


      }

      //error: (error) => {
       // this.errorMessage = 'Login failed: Invalid email or password';
      //}
    });
  }
}



// src/app/auth/login.component.ts
/** 

import { Component } from '@angular/core';
import { AuthService } from '../SecurityService/auth.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports:[FormsModule],
  templateUrl: './login.component.html'
})
export class LoginComponent {
  password = '';
  email    =''

  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login({ password: this.password , email:this.email}).subscribe({
      next: (res) => {
        this.authService.setToken(res.token);
        this.router.navigate(['/dashboard']);
      },
      error: () => {
        this.errorMessage = 'Invalid credentials!';
      }
    });
  }
}
*/