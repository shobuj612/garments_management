import { Component, OnInit } from '@angular/core';
import { Design } from '../../Model/design.model';
import { DesignService } from '../../Services/DesignSerivce/design.service';

@Component({
  selector: 'app-design-table',
  imports: [],
  templateUrl: './design-table.component.html',
  styleUrl: './design-table.component.css'
})
export class DesignTableComponent implements OnInit{
    item:Design={} as Design;
    constructor(private designService:DesignService){}

     ngOnInit(): void {
         this.designService.getLastDesign().subscribe(data=>{
          this.item=data;
         })
     }
}
