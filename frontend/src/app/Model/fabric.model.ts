export class FabricStore {
  fabric_id?: number;
  order:{order_id:number};
  fabric_type: string;
  fabric_qty: number;
  received_date: Date;
  available_stock: number;

  constructor() {
    //this.fabric_id = 0;  // Initializing fabric_id as a number
    this.order = {order_id:0};   // Initializing order_id as a number
    this.fabric_type = '';
    this.fabric_qty = 0;
    this.received_date = new Date();
    this.available_stock = 0;
  }
}
