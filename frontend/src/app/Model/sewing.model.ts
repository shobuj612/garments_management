export class Sewing {
    sewing_id?: number;
    order: {order_id:number};
    sewing_start_date: Date;
    sewing_end_date: Date;
    sewing_qty: number;
  
    constructor() {
    //  this.sewing_id = 0;          // Initializing sewing_id as a number
      this.order = {order_id:0};           // Initializing order_id as a number
      this.sewing_start_date = new Date();
      this.sewing_end_date = new Date();
      this.sewing_qty = 0;
    }
  }
  