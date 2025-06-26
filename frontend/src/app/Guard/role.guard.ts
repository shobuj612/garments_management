import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, Router } from '@angular/router';
import { AuthService } from '../SecurityService/auth.service';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/login']);
      return false;
    }

    const requiredRoles = route.data['roles'] as string[];
    const userRoles = this.authService.getUserRoles();

    const hasAccess = requiredRoles.some(role => userRoles.includes(role));

    if (!hasAccess) {
      this.router.navigate(['/unauthorized']);
      return false;
    }

    return true;
  }
}
