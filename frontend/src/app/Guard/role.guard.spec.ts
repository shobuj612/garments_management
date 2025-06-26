import { TestBed } from '@angular/core/testing';
import { Router } from '@angular/router';
import { RoleGuard } from './role.guard';
import { AuthService } from '../SecurityService/auth.service';
import { RouterTestingModule } from '@angular/router/testing';
import { ActivatedRouteSnapshot } from '@angular/router';

describe('RoleGuard', () => {
  let guard: RoleGuard;
  let authServiceSpy: jasmine.SpyObj<AuthService>;
  let router: Router;

  beforeEach(() => {
    const spy = jasmine.createSpyObj('AuthService', ['isLoggedIn', 'getUserRoles']);

    TestBed.configureTestingModule({
      imports: [RouterTestingModule],
      providers: [
        RoleGuard,
        { provide: AuthService, useValue: spy },
      ],
    });

    guard = TestBed.inject(RoleGuard);
    authServiceSpy = TestBed.inject(AuthService) as jasmine.SpyObj<AuthService>;
    router = TestBed.inject(Router);
  });

  it('should return true if user is logged in and has required role', () => {
    authServiceSpy.isLoggedIn.and.returnValue(true);
    authServiceSpy.getUserRoles.and.returnValue(['ADMIN']);

    const routeSnapshot = new ActivatedRouteSnapshot();
    (routeSnapshot as any).data = { roles: ['ADMIN'] };

    expect(guard.canActivate(routeSnapshot)).toBeTrue();
  });

  it('should redirect to login if user is not logged in', () => {
    spyOn(router, 'navigate');
    authServiceSpy.isLoggedIn.and.returnValue(false);

    const routeSnapshot = new ActivatedRouteSnapshot();
    (routeSnapshot as any).data = { roles: ['ADMIN'] };

    expect(guard.canActivate(routeSnapshot)).toBeFalse();
    expect(router.navigate).toHaveBeenCalledWith(['/login']);
  });

  it('should redirect to unauthorized if user lacks role', () => {
    spyOn(router, 'navigate');
    authServiceSpy.isLoggedIn.and.returnValue(true);
    authServiceSpy.getUserRoles.and.returnValue(['USER']);

    const routeSnapshot = new ActivatedRouteSnapshot();
    (routeSnapshot as any).data = { roles: ['ADMIN'] };

    expect(guard.canActivate(routeSnapshot)).toBeFalse();
    expect(router.navigate).toHaveBeenCalledWith(['/unauthorized']);
  });
});
