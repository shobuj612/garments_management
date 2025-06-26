import { Component, OnInit } from '@angular/core';
import { Sewing } from '../../Model/sewing.model';
import { SewingService } from '../../Services/sewingService/sewing.service';

@Component({
  selector: 'app-sewing-table',
  imports: [],
  templateUrl: './sewing-table.component.html',
  styleUrl: './sewing-table.component.css'
})
export class SewingTableComponent implements OnInit {
 item:Sewing={} as Sewing;
 constructor(private sewingService:SewingService){}
 ngOnInit(): void {
     this.sewingService.getLastSewing().subscribe(data=>{
      this.item=data;
     })
 }
}
