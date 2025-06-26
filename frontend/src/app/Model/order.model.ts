export class Order {
  order_id?: number; // optional
  buyer: {
    buyerName: any;
    buyerId: number;
  };
  order_name: string;
  style_no: string;
  order_qty: number;
  order_date: Date;
  delivery_date: Date;
  status: string;

  constructor() {
    this.buyer = { buyerId: 0, buyerName: '' };  // <-- fix here
    this.order_name = '';
    this.style_no = '';
    this.order_qty = 0;
    this.order_date = new Date();
    this.delivery_date = new Date();
    this.status = '';
  }
}
