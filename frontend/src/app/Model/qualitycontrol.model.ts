export class QualityControl {
    qc_id?: number;
    order: {order_id:number};
    inspection_date: Date;
    passed_qty: number;
    rejected_qty: number;
    remarks: string;
  
    constructor() {
      //this.qc_id = 0;          // Initializing qc_id as a number
      this.order = {order_id:0};       // Initializing order_id as a number
      this.inspection_date = new Date();
      this.passed_qty = 0;
      this.rejected_qty = 0;
      this.remarks = '';
    }
  }
  