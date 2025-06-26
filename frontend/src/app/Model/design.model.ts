export class Design {
  design_id?: number;
  order: {order_id:number};
  design_name: string;
  design_image_url: string;
  status: string;
  remarks: string;

  constructor() {
   // this.design_id = 0;  // Initializing design_id as a number
    this.order= {order_id:0};    // Initializing order_id as a number
    this.design_name = '';
    this.design_image_url = '';
    this.status = '';
    this.remarks = '';
  }
}
