import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-production-dashboard',
  standalone:true,
  imports: [RouterModule,NgIf],
  templateUrl: './production-dashboard.component.html',
  styleUrl: './production-dashboard.component.css'
})
export class ProductionDashboardComponent {

  constructor(private router:Router){}

  isAtRoot():boolean{

    return this.router.url==='/production';
  }

}
