import { Component, OnInit } from '@angular/core';
import { FabricStore } from '../../Model/fabric.model';
import { FabricService } from '../../Services/fabricService/fabric.service';

@Component({
  selector: 'app-fabric-table',
  imports: [],
  templateUrl: './fabric-table.component.html',
  styleUrl: './fabric-table.component.css'
})
export class FabricTableComponent implements OnInit{
   item:FabricStore={} as FabricStore;
   constructor(private fabricService:FabricService){}
   ngOnInit(): void {
       this.fabricService.getLastFabric().subscribe(data=>{
        this.item=data;
       })
   }
}
