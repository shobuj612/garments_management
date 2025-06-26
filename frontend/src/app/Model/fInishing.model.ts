export class Finishing {
  finish_id?: number;
  order: {order_id:number};
  finishing_date: Date;
  finish_qty: number;
  packing_done: string;

  constructor() {
   // this.finish_id = 0;  // Initializing finish_id as a number
    this.order = {order_id:0};   // Initializing order_id as a number
    this.finishing_date = new Date();
    this.finish_qty = 0;
    this.packing_done = '';
  }
}
