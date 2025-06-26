import { Component, OnInit } from '@angular/core';
import { Cutting } from '../../Model/cutting.model';
import { CutService } from '../../Services/cutService/cut.service';

@Component({
  selector: 'app-cutting-table',
  imports: [],
  templateUrl: './cutting-table.component.html',
  styleUrl: './cutting-table.component.css'
})
export class CuttingTableComponent implements OnInit {
  item:Cutting={} as Cutting;
  constructor(private cuttingService:CutService){}
  ngOnInit(): void {
      this.cuttingService.getLastCut().subscribe(data=>{
        this.item=data;
      })
  }


}
