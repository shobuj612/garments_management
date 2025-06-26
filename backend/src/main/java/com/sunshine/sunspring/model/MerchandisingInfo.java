
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "merchandising_info")
public class MerchandisingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merch_id")
    private Long merch_id;
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    
    @Column(name = "merchandiser_name")
    private String merchandiser_name;

    @Column(name = "sampling_done")
    private String sampling_done;

    @Column(name = "approval_date")
    @Temporal(TemporalType.DATE)
    private Date approval_date;

    @Column(name = "remarks")
    private String remarks;

    public MerchandisingInfo() {}

    // Getters and Setters
    public Long getMerch_id() {
        return merch_id;
    }

    public void setMerch_id(Long merch_id) {
        this.merch_id = merch_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getMerchandiser_name() {
        return merchandiser_name;
    }

    public void setMerchandiser_name(String merchandiser_name) {
        this.merchandiser_name = merchandiser_name;
    }

    public String getSampling_done() {
        return sampling_done;
    }

    public void setSampling_done(String sampling_done) {
        this.sampling_done = sampling_done;
    }

    public Date getApproval_date() {
        return approval_date;
    }

    public void setApproval_date(Date approval_date) {
        this.approval_date = approval_date;
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
@Table(name = "merchandising_info")
public class MerchandisingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merch_id")
    private Long merchId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "merchandiser_name")
    private String merchandiserName;

    @Column(name = "sampling_done")
    private String samplingDone;

    @Column(name = "approval_date")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;

    @Column(name = "remarks")
    private String remarks;

    public MerchandisingInfo() {}

	public Long getMerchId() {
		return merchId;
	}

	public void setMerchId(Long merchId) {
		this.merchId = merchId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getMerchandiserName() {
		return merchandiserName;
	}

	public void setMerchandiserName(String merchandiserName) {
		this.merchandiserName = merchandiserName;
	}

	public String getSamplingDone() {
		return samplingDone;
	}

	public void setSamplingDone(String samplingDone) {
		this.samplingDone = samplingDone;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

    // Getters and setters...
    
    
}

*/

/*
package com.sunshine.sunspring.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "merchandising_info")
public class MerchandisingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merch_id")
    private Long merch_id;

    @Column(name = "order_id", nullable = false)
    private Long order_id;

    @Column(name = "merchandiser_name")
    private String merchandiser_name;

    @Column(name = "sampling_done")
    private String sampling_done;

    @Column(name = "approval_date")
    @Temporal(TemporalType.DATE)
    private Date approval_date;

    @Column(name = "remarks")
    private String remarks;

    public MerchandisingInfo() {}

    // Getters and Setters
    public Long getMerch_id() {
        return merch_id;
    }

    public void setMerch_id(Long merch_id) {
        this.merch_id = merch_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getMerchandiser_name() {
        return merchandiser_name;
    }

    public void setMerchandiser_name(String merchandiser_name) {
        this.merchandiser_name = merchandiser_name;
    }

    public String getSampling_done() {
        return sampling_done;
    }

    public void setSampling_done(String sampling_done) {
        this.sampling_done = sampling_done;
    }

    public Date getApproval_date() {
        return approval_date;
    }

    public void setApproval_date(Date approval_date) {
        this.approval_date = approval_date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

*/