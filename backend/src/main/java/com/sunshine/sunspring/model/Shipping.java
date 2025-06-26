
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id")
    private Long shipping_id; // No initialization here

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "shipping_date")
    @Temporal(TemporalType.DATE)
    private Date shipping_date;

    @Column(name = "shipped_qty")
    private int shipped_qty;

    @Column(name = "invoice_no")
    private String invoice_no;

    @Column(name = "destination")
    private String destination;

    @Column(name = "carrier")
    private String carrier;

   public Shipping() {
	   
   }

    // Getter and Setter methods
    public Long getShipping_id() {
        return shipping_id;
    }

    public void setShipping_id(Long shipping_id) {
        this.shipping_id = shipping_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getShipping_date() {
        return shipping_date;
    }

    public void setShipping_date(Date shipping_date) {
        this.shipping_date = shipping_date;
    }

    public int getShipped_qty() {
        return shipped_qty;
    }

    public void setShipped_qty(int shipped_qty) {
        this.shipped_qty = shipped_qty;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
}



/*
package com.sunshine.sunspring.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingId;

    private String shippingDate;
    private String destination;
    private String carrier;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

	public Long getShippingId() {
		return shippingId;
	}

	public void setShippingId(Long shippingId) {
		this.shippingId = shippingId;
	}

	public String getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

    // getters and setters
    
    
}

*/



/*
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_id")
    private Long shipping_id; // No initialization here

    @Column(name = "order_id", nullable = false)
    private Long order_id; // No initialization here

    @Column(name = "shipping_date")
    @Temporal(TemporalType.DATE)
    private Date shipping_date;

    @Column(name = "shipped_qty")
    private int shipped_qty;

    @Column(name = "invoice_no")
    private String invoice_no;

    @Column(name = "destination")
    private String destination;

    @Column(name = "carrier")
    private String carrier;

   public Shipping() {
	   
   }

    // Getter and Setter methods
    public Long getShipping_id() {
        return shipping_id;
    }

    public void setShipping_id(Long shipping_id) {
        this.shipping_id = shipping_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Date getShipping_date() {
        return shipping_date;
    }

    public void setShipping_date(Date shipping_date) {
        this.shipping_date = shipping_date;
    }

    public int getShipped_qty() {
        return shipped_qty;
    }

    public void setShipped_qty(int shipped_qty) {
        this.shipped_qty = shipped_qty;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
}


*/
