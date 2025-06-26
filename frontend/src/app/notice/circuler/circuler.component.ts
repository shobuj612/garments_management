import { Component, OnInit } from '@angular/core';
import { Circuler } from '../../Model/circuler.model';
import { CirculerserviceService } from '../../Services/circuler/circulerservice.service';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-circuler',
  standalone:true,
  imports: [NgIf,NgFor],
  templateUrl: './circuler.component.html',
  styleUrl: './circuler.component.css'
})
export class CirculerComponent implements OnInit{
  show=true;
  circulerList:Circuler[]=[];
  constructor(private circulerService:CirculerserviceService){}
 closeTable():boolean{
  return this.show=false;
 }
 ngOnInit(): void {
     this.circulerService.getAllCirculer().subscribe(data=>{
      this.circulerList=data;
     })
 }

}
