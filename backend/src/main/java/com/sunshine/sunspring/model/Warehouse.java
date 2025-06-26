
package com.sunshine.sunspring.model;

import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Long warehouse_id;
    
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    

    @Column(name = "received_date")
    @Temporal(TemporalType.DATE)
    private Date received_date;

    @Column(name = "stored_qty")
    private int stored_qty;

    // Default constructor that initializes fields with default values
    public Warehouse() {
        
    }

    // Getter and Setter methods
    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getReceived_date() {
        return received_date;
    }

    public void setReceived_date(Date received_date) {
        this.received_date = received_date;
    }

    public int getStored_qty() {
        return stored_qty;
    }

    public void setStored_qty(int stored_qty) {
        this.stored_qty = stored_qty;
    }
}

/*
package com.sunshine.sunspring.model;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Long warehouse_id;

    @Temporal(TemporalType.DATE)
    @Column(name = "received_date")
    private Date received_date;

    @Column(name = "stored_qty")
    private int stored_qty;

    // ✅ Relationship with Order
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    private Order order;

    // Default constructor
    public Warehouse() {}

    // Getter and Setter methods
    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Date getReceived_date() {
        return received_date;
    }

    public void setReceived_date(Date received_date) {
        this.received_date = received_date;
    }

    public int getStored_qty() {
        return stored_qty;
    }

    public void setStored_qty(int stored_qty) {
        this.stored_qty = stored_qty;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}


*/

/*
 * 
package com.sunshine.sunspring.model;

import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Long warehouse_id;

    @Column(name = "order_id", nullable = false)
    private Long order_id;

    @Column(name = "received_date")
    @Temporal(TemporalType.DATE)
    private Date received_date;

    @Column(name = "stored_qty")
    private int stored_qty;

    // Default constructor that initializes fields with default values
    public Warehouse() {
        
    }

    // Getter and Setter methods
    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Date getReceived_date() {
        return received_date;
    }

    public void setReceived_date(Date received_date) {
        this.received_date = received_date;
    }

    public int getStored_qty() {
        return stored_qty;
    }

    public void setStored_qty(int stored_qty) {
        this.stored_qty = stored_qty;
    }
}


*/
