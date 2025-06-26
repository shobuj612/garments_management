export class Cutting {
  cutting_id?: number;
  order:{order_id:number};
  cutting_start_date: Date;
  cutting_end_date: Date;
  cut_qty: number;
  supervisor_name: string;

  constructor() {
    //this.cutting_id = 0;  // Initializing cutting_id as a number
    this.order = {order_id:0};    // Initializing order_id as a number
    this.cutting_start_date = new Date();
    this.cutting_end_date = new Date();
    this.cut_qty = 0;
    this.supervisor_name = '';
  }
}
