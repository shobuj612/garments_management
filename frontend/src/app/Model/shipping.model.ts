export class Shipping {
    shipping_id?: number;
    order:{order_id:number};
    shipping_date: Date;
    shipped_qty: number;
    invoice_no: string;
    destination: string;
    carrier: string;
  
    constructor() {
      //this.shipping_id = 0;        // Initializing shipping_id as a number
      this.order = {order_id:0};           // Initializing order_id as a number
      this.shipping_date = new Date();
      this.shipped_qty = 0;
      this.invoice_no = '';
      this.destination = '';
      this.carrier = '';
    }
  }
  