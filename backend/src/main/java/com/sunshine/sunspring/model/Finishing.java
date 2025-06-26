
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "finishing")
public class Finishing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finish_id")
    private Long finish_id;
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    
    @Column(name = "finishing_date")
    @Temporal(TemporalType.DATE)
    private Date finishing_date;

    @Column(name = "finish_qty")
    private int finish_qty;

    @Column(name = "packing_done")
    private String packing_done;

    // No-args constructor
    public Finishing() {}

    // Getters and Setters
    public Long getFinish_id() {
        return finish_id;
    }

    public void setFinish_id(Long finish_id) {
        this.finish_id = finish_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getFinishing_date() {
        return finishing_date;
    }

    public void setFinishing_date(Date finishing_date) {
        this.finishing_date = finishing_date;
    }

    public int getFinish_qty() {
        return finish_qty;
    }

    public void setFinish_qty(int finish_qty) {
        this.finish_qty = finish_qty;
    }

    public String getPacking_done() {
        return packing_done;
    }

    public void setPacking_done(String packing_done) {
        this.packing_done = packing_done;
    }
}





/*
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "finishing")
public class Finishing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finish_id")
    private Long finishId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "finishing_date")
    @Temporal(TemporalType.DATE)
    private Date finishingDate;

    @Column(name = "finish_qty")
    private int finishQty;

    @Column(name = "packing_done")
    private String packingDone;

    public Finishing() {}

	public Long getFinishId() {
		return finishId;
	}

	public void setFinishId(Long finishId) {
		this.finishId = finishId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getFinishingDate() {
		return finishingDate;
	}

	public void setFinishingDate(Date finishingDate) {
		this.finishingDate = finishingDate;
	}

	public int getFinishQty() {
		return finishQty;
	}

	public void setFinishQty(int finishQty) {
		this.finishQty = finishQty;
	}

	public String getPackingDone() {
		return packingDone;
	}

	public void setPackingDone(String packingDone) {
		this.packingDone = packingDone;
	}

  
}


*/

/*
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "finishing")
public class Finishing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finish_id")
    private Long finish_id;

    @Column(name = "order_id", nullable = false)
    private Long order_id;

    @Column(name = "finishing_date")
    @Temporal(TemporalType.DATE)
    private Date finishing_date;

    @Column(name = "finish_qty")
    private int finish_qty;

    @Column(name = "packing_done")
    private String packing_done;

    // No-args constructor
    public Finishing() {}

    // Getters and Setters
    public Long getFinish_id() {
        return finish_id;
    }

    public void setFinish_id(Long finish_id) {
        this.finish_id = finish_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Date getFinishing_date() {
        return finishing_date;
    }

    public void setFinishing_date(Date finishing_date) {
        this.finishing_date = finishing_date;
    }

    public int getFinish_qty() {
        return finish_qty;
    }

    public void setFinish_qty(int finish_qty) {
        this.finish_qty = finish_qty;
    }

    public String getPacking_done() {
        return packing_done;
    }

    public void setPacking_done(String packing_done) {
        this.packing_done = packing_done;
    }
}


*/
