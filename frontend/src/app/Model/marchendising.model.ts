export class Merchandising {
  merch_id?: number;
  order: {order_id:number};
  merchandiser_name: string;
  sampling_done: string;
  approval_date: Date;
  remarks: string;

  constructor() {
    //this.merch_id = 0;  // Initializing merch_id as a number
    this.order = {order_id:0};   // Initializing order_id as a number
    this.merchandiser_name = '';
    this.sampling_done = 'N';
    this.approval_date = new Date();
    this.remarks = '';
  }
}
