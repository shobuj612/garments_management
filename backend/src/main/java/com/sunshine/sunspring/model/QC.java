
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "qc_info")
public class QC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qc_id")
    private Long qc_id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "inspection_date")
    @Temporal(TemporalType.DATE)
    private Date inspection_date;

    @Column(name = "passed_qty")
    private int passed_qty;

    @Column(name = "rejected_qty")
    private int rejected_qty;

    @Column(name = "remarks")
    private String remarks;

    public QC() {}

    // Getters and Setters
    public Long getQc_id() {
        return qc_id;
    }

    public void setQc_id(Long qc_id) {
        this.qc_id = qc_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getInspection_date() {
        return inspection_date;
    }

    public void setInspection_date(Date inspection_date) {
        this.inspection_date = inspection_date;
    }

    public int getPassed_qty() {
        return passed_qty;
    }

    public void setPassed_qty(int passed_qty) {
        this.passed_qty = passed_qty;
    }

    public int getRejected_qty() {
        return rejected_qty;
    }

    public void setRejected_qty(int rejected_qty) {
        this.rejected_qty = rejected_qty;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}




/*
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "qc_info")
public class QC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qc_id")
    private Long qc_id;

    @Temporal(TemporalType.DATE)
    @Column(name = "inspection_date")
    private Date inspection_date;

    @Column(name = "passed_qty")
    private int passed_qty;

    @Column(name = "rejected_qty")
    private int rejected_qty;

    @Column(name = "remarks")
    private String remarks;

    // ✅ Proper relationship with Order
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    private Order order;

    public QC() {}

    // Getters and Setters
    public Long getQc_id() {
        return qc_id;
    }

    public void setQc_id(Long qc_id) {
        this.qc_id = qc_id;
    }

    public Date getInspection_date() {
        return inspection_date;
    }

    public void setInspection_date(Date inspection_date) {
        this.inspection_date = inspection_date;
    }

    public int getPassed_qty() {
        return passed_qty;
    }

    public void setPassed_qty(int passed_qty) {
        this.passed_qty = passed_qty;
    }

    public int getRejected_qty() {
        return rejected_qty;
    }

    public void setRejected_qty(int rejected_qty) {
        this.rejected_qty = rejected_qty;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
@Table(name = "qc_info")
public class QC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qc_id")
    private Long qc_id;

    @Column(name = "order_id", nullable = false)
    private Long order_id;

    @Column(name = "inspection_date")
    @Temporal(TemporalType.DATE)
    private Date inspection_date;

    @Column(name = "passed_qty")
    private int passed_qty;

    @Column(name = "rejected_qty")
    private int rejected_qty;

    @Column(name = "remarks")
    private String remarks;

    public QC() {}

    // Getters and Setters
    public Long getQc_id() {
        return qc_id;
    }

    public void setQc_id(Long qc_id) {
        this.qc_id = qc_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Date getInspection_date() {
        return inspection_date;
    }

    public void setInspection_date(Date inspection_date) {
        this.inspection_date = inspection_date;
    }

    public int getPassed_qty() {
        return passed_qty;
    }

    public void setPassed_qty(int passed_qty) {
        this.passed_qty = passed_qty;
    }

    public int getRejected_qty() {
        return rejected_qty;
    }

    public void setRejected_qty(int rejected_qty) {
        this.rejected_qty = rejected_qty;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

*/
