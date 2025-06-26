import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-jobpost',
  imports: [RouterModule,NgIf],
  templateUrl: './jobpost.component.html',
  styleUrl: './jobpost.component.css'
})
export class JobpostComponent {

  constructor(private router:Router){

  }

  isAtRoot():boolean{
    return this.router.url==='/job';
  }

}
