import { Component, OnInit } from '@angular/core';
import { Warehouse } from '../../Model/warehouse.model';
import { WareService } from '../../Services/warehouseService/ware.service';

@Component({
  selector: 'app-warehouse-table',
  imports: [],
  templateUrl: './warehouse-table.component.html',
  styleUrl: './warehouse-table.component.css'
})
export class WarehouseTableComponent implements OnInit{
  item:Warehouse={} as Warehouse;
  constructor(private warehoueService:WareService){}
  ngOnInit(): void {
      this.warehoueService.getLastWare().subscribe(data=>{
        this.item=data;
      })
  }
}
