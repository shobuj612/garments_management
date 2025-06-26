import { Component, OnInit } from '@angular/core';
import { Finishing } from '../../Model/fInishing.model';
import { FinishService } from '../../Services/finishingSevice/finish.service';

@Component({
  selector: 'app-finishing-table',
  imports: [],
  templateUrl: './finishing-table.component.html',
  styleUrl: './finishing-table.component.css'
})
export class FinishingTableComponent implements OnInit {
  item:Finishing={} as Finishing;
  constructor(private finishingService:FinishService){}
  ngOnInit(): void {
      this.finishingService.getLastFinisRow().subscribe(data=>{
        this.item=data;
      })
  }
}
