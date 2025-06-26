import { Component, OnInit } from '@angular/core';
import { QualityControl } from '../../Model/qualitycontrol.model';
import { QcService } from '../../Services/qcService/qc.service';

@Component({
  selector: 'app-qc-table',
  imports: [],
  templateUrl: './qc-table.component.html',
  styleUrl: './qc-table.component.css'
})
export class QcTableComponent implements OnInit{
   item:QualityControl={} as QualityControl;
   constructor(private qualityService:QcService){}
   ngOnInit(): void {
       this.qualityService.getLastQc().subscribe(data=>{
        this.item=data;
       })
   }
}
