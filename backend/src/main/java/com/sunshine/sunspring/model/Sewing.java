

package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sewing")
public class Sewing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sewing_id")
    public Long sewing_id; // Follows the TypeScript camelCase style
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    
    @Column(name = "sewing_start_date")
    @Temporal(TemporalType.DATE)
    public Date sewing_start_date; // Follows the TypeScript camelCase style

    @Column(name = "sewing_end_date")
    @Temporal(TemporalType.DATE)
    public Date sewing_end_date; // Follows the TypeScript camelCase style

    @Column(name = "sewing_qty")
    public int sewing_qty; // Follows the TypeScript camelCase style

    // Default constructor
    public Sewing() {}

    // Getters and Setters
    public Long getSewing_id() {
        return sewing_id;
    }

    public void setSewing_id(Long sewing_id) {
        this.sewing_id = sewing_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getSewing_start_date() {
        return sewing_start_date;
    }

    public void setSewing_start_date(Date sewing_start_date) {
        this.sewing_start_date = sewing_start_date;
    }

    public Date getSewing_end_date() {
        return sewing_end_date;
    }

    public void setSewing_end_date(Date sewing_end_date) {
        this.sewing_end_date = sewing_end_date;
    }

    public int getSewing_qty() {
        return sewing_qty;
    }

    public void setSewing_qty(int sewing_qty) {
        this.sewing_qty = sewing_qty;
    }
}



/*
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sewing")
public class Sewing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sewing_id")
    private Long sewing_id;

    @Temporal(TemporalType.DATE)
    @Column(name = "sewing_start_date")
    private Date sewing_start_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "sewing_end_date")
    private Date sewing_end_date;

    @Column(name = "sewing_qty")
    private int sewing_qty;

    // ✅ Relationship with Order
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    private Order order;

    // Default constructor
    public Sewing() {}

    // Getters and Setters
    public Long getSewing_id() {
        return sewing_id;
    }

    public void setSewing_id(Long sewing_id) {
        this.sewing_id = sewing_id;
    }

    public Date getSewing_start_date() {
        return sewing_start_date;
    }

    public void setSewing_start_date(Date sewing_start_date) {
        this.sewing_start_date = sewing_start_date;
    }

    public Date getSewing_end_date() {
        return sewing_end_date;
    }

    public void setSewing_end_date(Date sewing_end_date) {
        this.sewing_end_date = sewing_end_date;
    }

    public int getSewing_qty() {
        return sewing_qty;
    }

    public void setSewing_qty(int sewing_qty) {
        this.sewing_qty = sewing_qty;
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
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sewing")
public class Sewing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sewing_id")
    public Long sewing_id; // Follows the TypeScript camelCase style

    @Column(name = "order_id", nullable = false)
    public Long order_id; // Follows the TypeScript camelCase style

    @Column(name = "sewing_start_date")
    @Temporal(TemporalType.DATE)
    public Date sewing_start_date; // Follows the TypeScript camelCase style

    @Column(name = "sewing_end_date")
    @Temporal(TemporalType.DATE)
    public Date sewing_end_date; // Follows the TypeScript camelCase style

    @Column(name = "sewing_qty")
    public int sewing_qty; // Follows the TypeScript camelCase style

    // Default constructor
    public Sewing() {}

    // Getters and Setters
    public Long getSewing_id() {
        return sewing_id;
    }

    public void setSewing_id(Long sewing_id) {
        this.sewing_id = sewing_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Date getSewing_start_date() {
        return sewing_start_date;
    }

    public void setSewing_start_date(Date sewing_start_date) {
        this.sewing_start_date = sewing_start_date;
    }

    public Date getSewing_end_date() {
        return sewing_end_date;
    }

    public void setSewing_end_date(Date sewing_end_date) {
        this.sewing_end_date = sewing_end_date;
    }

    public int getSewing_qty() {
        return sewing_qty;
    }

    public void setSewing_qty(int sewing_qty) {
        this.sewing_qty = sewing_qty;
    }
}


*/
