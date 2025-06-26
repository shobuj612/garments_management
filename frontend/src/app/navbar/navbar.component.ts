import { Component } from '@angular/core';
import { AuthService } from '../SecurityService/auth.service';  // Correct path to your AuthService
import { NgIf } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [NgIf,RouterModule],
  templateUrl: './navbar.component.html'
})
export class NavbarComponent {

    
  constructor(public authService: AuthService, private router:Router) {}
  



  // Updated method to use getUserRoles() from AuthService
  hasRole(role: string): boolean {
    return this.authService.getUserRoles().includes(role);
  }

  // this is the method that show or hide the Logoutbutton

  IsGetToken():boolean{

    return this.authService.getToken() !== null;
  }

  //  this is logout method call in  the  navbar.ts
  
  onLogout() {
    this.authService.logout();
    this.router.navigate(['/login']); // Redirect to the login page after logout
  }

}
