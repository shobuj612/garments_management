package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders") // 'order' is a reserved keyword in SQL
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long order_id;

    // Many orders can belong to one buyer
    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private Buyer buyer;
    
    @Column(name="order_name",nullable=false)
    private String order_name;

    @Column(name = "style_no")
    private String style_no;

    @Column(name = "order_qty")
    private int order_qty;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date order_date;

    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date delivery_date;

    @Column(name = "status")
    private String status;

    public Order() {}

    // Getters and Setters
    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
    
    public String getOrder_name() {
    	return order_name;
    }
    
    public void setOrder_name(String order_name) {
    	this.order_name=order_name;
    }

    public String getStyle_no() {
        return style_no;
    }

    public void setStyle_no(String style_no) {
        this.style_no = style_no;
    }

    public int getOrder_qty() {
        return order_qty;
    }

    public void setOrder_qty(int order_qty) {
        this.order_qty = order_qty;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


/*
 * 
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders") // 'order' is reserved in SQL
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "buyer_id", nullable = false)
    private Long buyer_id;

    @Column(name = "style_no")
    private String style_no;

    @Column(name = "order_qty")
    private int order_qty;

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date order_date;

    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date delivery_date;

    @Column(name = "status")
    private String status;

    public Order() {}

    // Getters and Setters
    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Long buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getStyle_no() {
        return style_no;
    }

    public void setStyle_no(String style_no) {
        this.style_no = style_no;
    }

    public int getOrder_qty() {
        return order_qty;
    }

    public void setOrder_qty(int order_qty) {
        this.order_qty = order_qty;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


 * 
 * */
